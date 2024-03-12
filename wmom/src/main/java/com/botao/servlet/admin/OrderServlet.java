package com.botao.servlet.admin;

import com.botao.pojo.Order;
import com.botao.pojo.Product;
import com.botao.pojo.User;
import com.botao.service.OrderService;
import com.botao.service.ProductService;
import com.botao.service.UserService;
import com.botao.service.impl.OrderServiceImpl;
import com.botao.service.impl.ProductServiceImpl;
import com.botao.service.impl.UserServiceImpl;
import com.botao.utils.Helper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@WebServlet("/admin/order/*")
public class OrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getRequestURI().replace("/admin/order/", "");
        if("getAllOrders".equals(action)){
            try {
                getAllOrders(req,resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if ("send".equals(action.substring(0,4))){
            try {
                send(req,resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if("getOrderById".equals(action.substring(0,12))){
            try {
                getOrderById(req,resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


    private void send(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        String id = req.getParameter("id");
        OrderService orderService = new OrderServiceImpl();
        boolean b = orderService.sendProduct(id);
        HashMap<Object, Object> map = new HashMap<>();

        if(b){
            map.put("status",200);
        }else {
            map.put("status",0);
        }
        Helper.responseJSON(resp,map);
    }


    private void getAllOrders(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        OrderService orderService = new OrderServiceImpl();
        List<Order> orders = orderService.getAllOrders();
        req.setAttribute("orders",orders);
        req.getRequestDispatcher("/admin/order-list.jsp").forward(req,resp);
    }

    private void getOrderById(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        OrderService orderService = new OrderServiceImpl();
        String id = req.getParameter("id");
        Order order = orderService.getOrderById(id);
        //获取该订单商品id
        String productid = order.getProductid();
        ProductService productService = new ProductServiceImpl();
        Product product = productService.getProductById(productid);
        System.out.println(product.getName());

        //获取该订单用户id
        String userid = order.getUserid();
        UserService userService = new UserServiceImpl();
        User user = userService.getUserById(userid);

        req.setAttribute("product",product);
        req.setAttribute("user",user);
        req.setAttribute("order",order);
        req.getRequestDispatcher("/admin/order-view.jsp").forward(req,resp);
    }

}
