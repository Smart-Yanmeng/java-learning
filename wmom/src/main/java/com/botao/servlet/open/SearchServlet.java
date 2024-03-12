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

@WebServlet("/open/search/")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keywords = req.getParameter("keywords");
        ProductService productService = new ProductServiceImpl();
        List<Product> products = null;
        try {
            products = productService.searchProducts(keywords);
            req.setAttribute("products",products);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            req.getRequestDispatcher("/search.jsp").forward(req,resp);
        }

    }
}
