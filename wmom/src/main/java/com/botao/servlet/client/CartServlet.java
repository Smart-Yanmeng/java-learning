package com.botao.servlet.client;

import com.botao.dao.impl.CartDaoImpl;
import com.botao.pojo.Product;
import com.botao.pojo.User;
import com.botao.service.CartService;
import com.botao.service.impl.CartServiceImpl;
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
import java.util.List;

@WebServlet("/cart/*")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String action = req.getRequestURI().replace("/cart/", "");
        if ("mycart".equals(action.substring(0, 6))) {
            try {
                mycart(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String action = req.getRequestURI().replace("/cart/", "");
        if ("add".equals(action)) {
            try {
                add(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if ("delete".equals(action.substring(0, 6))) {
            try {
                delete(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void mycart(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        System.out.println("我的购物车页面");
        CartService cartService = new CartServiceImpl();
        User user = (User) req.getSession().getAttribute("user");
        List<Product> products = cartService.getCartsByUserId(user.getId());
        req.setAttribute("products", products);
        req.getRequestDispatcher("/user/cart.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        //移出购物车
        //要移除的商品的id
        String id = req.getParameter("id");
        User user = (User) req.getSession().getAttribute("user");
        String userId = user.getId();
        System.out.println("id===>"+id);
        CartService cartService = new CartServiceImpl();
        boolean b = cartService.deleteCartById(id, userId);
        HashMap<Object, Object> map = new HashMap<>(8);
        if (b) {
            map.put("status", 200);
        } else {
            map.put("status", 0);
        }
        Helper.responseJSON(resp, map);



    }


    private void add(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        String productId = req.getParameter("id");
        User user = (User) req.getSession().getAttribute("user");
        String userId = user.getId();
        System.out.println("商品id" + productId + "用户id" + userId);
        CartServiceImpl cartService = new CartServiceImpl();
        boolean b = cartService.addCat(productId, userId);
        HashMap<Object, Object> map = new HashMap<>(8);
        if (b) {
            map.put("status", 200);
        } else {
            map.put("status", 0);
        }
        Helper.responseJSON(resp, map);
    }
}
