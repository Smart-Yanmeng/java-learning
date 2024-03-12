package com.botao.servlet.open;

import com.botao.pojo.Product;
import com.botao.service.ProductService;
import com.botao.service.impl.ProductServiceImpl;
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

@WebServlet("/open/product/*")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String action = req.getRequestURI().replace("/open/product/", "");
        if ("queryall".equals(action)) {
            try {
                getAllProducts(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if("getproductbyid".equals(action.substring(0,14))){
            try {
                getProductById(req,resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("找不到");
        }
    }

    protected void getAllProducts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        ProductService productService = new ProductServiceImpl();
        List<Product> allProducts = productService.getAllProducts();
        HashMap<Object, Object> map = new HashMap<>(8);
        map.put("status", 200);
        map.put("data", allProducts);
        Helper.responseJSON(resp,map);
    }
    protected void getProductById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String id = req.getParameter("id");
        ProductService productService = new ProductServiceImpl();
        Product product = productService.getProductById(id);
        req.setAttribute("product",product);
        req.getRequestDispatcher("/product.jsp").forward(req,resp);
    }

}
