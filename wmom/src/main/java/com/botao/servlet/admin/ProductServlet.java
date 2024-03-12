package com.botao.servlet.admin;

import com.botao.pojo.Product;
import com.botao.pojo.User;
import com.botao.service.ProductService;
import com.botao.service.impl.ProductServiceImpl;
import com.botao.utils.Helper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@WebServlet("/admin/product/*")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String action = req.getRequestURI().replace("/admin/product/", "");
        if ("queryall".equals(action)) {
            try {
                getAllProducts(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if ("editpage".equals(action.substring(0, 8))) {
            try {
                editpage(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String action = req.getRequestURI().replace("/admin/product/", "");
        if ("add".equals(action)) {
            try {
                add(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if ("del".equals(action)) {
            try {
                delete(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if ("update".equals(action)) {
            try {
                update(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    //添加商品
    private void add(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        ProductServiceImpl productService = new ProductServiceImpl();
        //获取前端参数
        String name = req.getParameter("name");
        String desc = req.getParameter("desc");
        double price = Double.parseDouble(req.getParameter("price"));
        Integer stock = Integer.parseInt(req.getParameter("stock"));
        String img = req.getParameter("img");

        //创建商品对象
        Product product = new Product(null, name, desc, price, stock, img, null, null);
        //调用业务层添加商品
        Boolean add = productService.add(product);
        HashMap<Object, Object> map = new HashMap<>(8);
        if (add) {
            map.put("status", 200);
        } else {
            map.put("status", 0);
        }
        Helper.responseJSON(resp, map);
    }

    //下架商品（逻辑删除）
    private void delete(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        String id = req.getParameter("id");
        HashMap<Object, Object> map = new HashMap<>(8);
        ProductService productService = new ProductServiceImpl();
        Date deleted = productService.getProductById(id).getDeleted();
        if (deleted == null) {
            Boolean remove = productService.remove(id);
            if (remove) {
                map.put("status", 200);
                map.put("msg", "商品下架成功！");
            }
        } else {
            map.put("status", 0);
            map.put("msg", "商品下架失败！因为该商品已经下架！");
        }

        Helper.responseJSON(resp, map);
    }

    private void editpage(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String id = req.getParameter("id");
        ProductServiceImpl productService = new ProductServiceImpl();
        Product product = productService.getProductById(id);
        req.setAttribute("product", product);
        resp.setContentType("text/html;charset=UTF-8");
        req.getRequestDispatcher("/admin/product-edit.jsp").forward(req, resp);
    }

    //查询所有的商品信息(内容转发)
    public void getAllProducts(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        ProductService productService = new ProductServiceImpl();
        List<Product> allProducts = productService.getAllProducts();
        HashMap<Object, Object> map = new HashMap<>(8);
        map.put("status", 200);
        map.put("data", allProducts);
        resp.setContentType("text/html;charset=UTF-8");
        req.setAttribute("data", map);
        req.getRequestDispatcher("/admin/product-list.jsp").forward(req, resp);
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        ProductServiceImpl productService = new ProductServiceImpl();
        //获取前端参数
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String desc = req.getParameter("desc");
        double price = Double.parseDouble(req.getParameter("price"));
        Integer stock = Integer.parseInt(req.getParameter("stock"));
        String img = req.getParameter("img");
        Product product = new Product();

        product.setId(id);
        product.setName(name);
        product.setDesc(desc);
        product.setPrice(price);
        product.setStock(stock);
        product.setImg(img);

        boolean b = productService.updateProductById(product);
        HashMap<Object, Object> map = new HashMap<>(8);
        if (b) {
            map.put("status", 200);
        } else {
            map.put("status", 0);
        }
        Helper.responseJSON(resp, map);
    }
}
