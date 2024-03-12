package com.botao.servlet.client;

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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@WebServlet("/order/*")
public class OrderServlet extends HttpServlet {
    private OrderServiceImpl orderService = new OrderServiceImpl();
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getRequestURI().replace("/order/", "");
        if ("add".equals(action)) {
            add(req, resp);
        }else if("addone".equals(action)){
            try {
                addone(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if ("deleted".equals(action)){
            try {
                delete(req,resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getRequestURI().replace("/order/", "");
        if("getfp".equals(action.substring(0,5))){
            System.out.println("-----------------------发票");
            try {
                getOrderById(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if("getProduct".equals(action.substring(0,10))){
            try {
                getProduct(req,resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if("getOrdersByUserId".equals(action.substring(0,17))){
            try {
                getOrdersByUserId(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void getProduct(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        String id = req.getParameter("id");
        boolean i = orderService.getProduct(id);
        HashMap<Object, Object> map = new HashMap<>();
        if(i){
            map.put("status",200);
        }else {
            map.put("status",0);
        }
        Helper.responseJSON(resp,map);
    }
    private void getOrderById(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String id = req.getParameter("id");
        Order order = orderService.getOrderById(id);
        //获取该订单商品id
        String productid = order.getProductid();
        ProductService productService = new ProductServiceImpl();
        Product product = productService.getProductById(productid);
        System.out.println(product.getName());

        //获取该订单用户id
        String userid = order.getUserid();

        User user = userService.getUserById(userid);

        req.setAttribute("product",product);
        req.setAttribute("user",user);
        req.setAttribute("order",order);
        req.getRequestDispatcher("/user/order-view.jsp").forward(req,resp);
    }

    private void getOrdersByUserId(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String userId = user.getId();
        List<Order> orders = orderService.getOrdersByUserId(userId);
        req.setAttribute("orders",orders);
        req.getRequestDispatcher("/user/purchase.jsp").forward(req,resp);
    }

    //订单创建(对于购物车)
    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String list = req.getParameter("list");
        String money = req.getParameter("money");
        User user = (User) req.getSession().getAttribute("user");
        String userId = user.getId();
        HashMap<Object, Object> map = new HashMap<>();
        HashMap<Object, Object> mapResp = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(list);
        if (jsonNode.isArray()) {
            for (JsonNode node : jsonNode) {
                JsonNode id = node.get("id");
                JsonNode count = node.get("count");
                //循环插入
                map.put(id, count);
            }
        }
        map.forEach((k, v) -> {
            System.out.println(k + "====>" + v);
            Order order = new Order();
            order.setUserid(userId);
            order.setProductid(k.toString().replaceAll("\"", ""));
            Integer integer = Integer.parseInt(v.toString().replaceAll("\"", ""));
            order.setNumber(integer);
            order.setAddr(user.getAddr());
            boolean b = false;
            try {
                b = orderService.addOrder(order);
                if (b)
                    mapResp.put("status", 200);
            } catch (SQLException e) {
                e.printStackTrace();
                mapResp.put("status", 200);
            } finally {
                System.out.println(b);
            }
        });
        Helper.responseJSON(resp, mapResp);
    }


    private void addone(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        HashMap<Object, Object> map = new HashMap<>(8);
        User user = (User) req.getSession().getAttribute("user");

        String productid = req.getParameter("productid");
        Integer number = Integer.parseInt(req.getParameter("number"));
        Order order = new Order();
        order.setUserid(user.getId());
        order.setProductid(productid);
        order.setNumber(number);
        order.setAddr(user.getAddr());
        boolean b = orderService.addOrder(order);
        if(b){
            map.put("status",200);
        }else {
            map.put("status",0);
        }
        Helper.responseJSON(resp, map);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        String id = req.getParameter("id");
        //为了安全性这里要检查是不是属于该用户的id  在这里我们就不做了！
        HashMap<Object, Object> map = new HashMap<>(8);
        boolean b = orderService.deleteOrder(id);
        if(b){
            map.put("status",200);
        }else {
            map.put("status",0);
        }
        Helper.responseJSON(resp, map);
    }
}
