package com.botao.servlet.open;

import com.botao.pojo.Manager;
import com.botao.service.ManagerService;
import com.botao.service.impl.ManagerServiceImpl;
import com.botao.utils.Helper;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/login/*")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String action = req.getRequestURI().replace("/login/", "");
        //内容转发，用户登录和管理员登录
        if ("userlogin".equals(action)) {
            userLogin(req, resp);
        } else if ("managerlogin".equals(action)) {
            try {
                managerLogin(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            resp.sendRedirect("/404.jsp");
        }
    }

    //客户登录
    protected void userLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("userLogin");
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
            manager.setPassword("******");
            map.put("status", 200);
        }
        //存session
        req.getSession().setAttribute("manager", manager);
        map.put("manager", manager);
        //返回json
        Helper.responseJSON(resp,map);
    }
}
