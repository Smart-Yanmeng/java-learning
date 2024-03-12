package com.botao.servlet.open;

import com.botao.pojo.Manager;
import com.botao.pojo.User;
import com.botao.service.ManagerService;
import com.botao.service.impl.ManagerServiceImpl;
import com.botao.service.impl.UserServiceImpl;
import com.botao.utils.Helper;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.HashMap;

@WebServlet("/login/*")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String action = req.getRequestURI().replace("/login/", "");
        //内容转发，用户登录和管理员登录
        if ("userlogin".equals(action)) {
            try {
                userLogin(req, resp);
            } catch (SQLException | NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        } else if ("managerlogin".equals(action)) {
            try {
                managerLogin(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if ("regist".equals(action)) {
            try {
                regist(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            resp.sendRedirect("/404.jsp");
        }
    }

    //客户登录
    protected void userLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException, NoSuchAlgorithmException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        HashMap<Object, Object> map = new HashMap<>(8);
        if ("".equals(username) || "".equals(password)) {
            return;
        }
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.login(username, password);
        if (user == null) {
            map.put("status", 0);
            map.put("msg", "用户名或者密码错误");
        } else {
            map.put("status", 200);
            map.put("msg", "登录成功");
            //存session
            req.getSession().setAttribute("user", user);
            map.put("user", user);
        }
        //返回json
        Helper.responseJSON(resp, map);
    }

    //客户注册
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws IOException, NoSuchAlgorithmException {
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //业务层
        UserServiceImpl userService = new UserServiceImpl();
        HashMap<Object, Object> map = new HashMap<>();

        User user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(Helper.toMd5str(password));
        Boolean b = false;
        try {
            b = userService.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
            map.put("status", 0);
            map.put("msg", "该用户已经被注册！");
            Helper.responseJSON(resp, map);
        }
        if (b) {
            map.put("status", 200);
            map.put("user", user);
        } else {
            map.put("status", 0);
        }
        Helper.responseJSON(resp, map);
    }


    //管理员登录
    protected void managerLogin(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //获取前端的用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        HashMap<Object, Object> map = new HashMap<>(8);
        ManagerService managerService = new ManagerServiceImpl();
        //调用业务层检查账号密码
        Manager manager = managerService.ManagerLogin(username, password);

        if (manager == null) {
            map.put("status", 0);
            map.put("msg", "用户名或者密码错误！");
        } else {
            map.put("status", 200);
        }
        //存session
        req.getSession().setAttribute("manager", manager);
        map.put("manager", manager);
        //返回json
        Helper.responseJSON(resp, map);
    }
}
