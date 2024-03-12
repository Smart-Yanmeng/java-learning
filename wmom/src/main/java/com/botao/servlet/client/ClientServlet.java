package com.botao.servlet.client;

import com.botao.pojo.User;
import com.botao.service.impl.UserServiceImpl;
import com.botao.utils.Helper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.HashMap;

@WebServlet("/client/*")
public class ClientServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String action = req.getRequestURI().replace("/client/", "");
        if ("update".equals(action)) {
            try {
                update(req,resp);
            } catch (SQLException | NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
    }
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, NoSuchAlgorithmException {
        UserServiceImpl userService = new UserServiceImpl();
        User user =(User) req.getSession().getAttribute("user");
        if(user==null){
            return;
        }
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String imagedir = req.getParameter("imagedir");
        String addr = req.getParameter("addr");

        user.setName(name);
        user.setUsername(username);
        if(!user.getPassword().equals(password)){
            user.setPassword(Helper.toMd5str(password));
        }
        user.setPhone(phone);
        user.setHead(imagedir);
        user.setAddr(addr);
        boolean b = userService.UpdateUserById(user);
        HashMap<Object, Object> map = new HashMap<>(8);
        if(b){
            User newUser = userService.login(user.getUsername(),user.getPassword(),false);
            System.out.println(newUser);
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
            req.getSession().setAttribute("user",newUser);
            map.put("status",200);
            map.put("msg","修改成功");
        }else {
            map.put("status",200);
            map.put("msg","修改成功");
        }
        Helper.responseJSON(resp,map);
    }

}
