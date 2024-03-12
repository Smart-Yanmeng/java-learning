import com.botao.dao.ManagerDao;
import com.botao.dao.impl.ManagerDaoImpl;
import com.botao.dao.impl.ProductDaoImpl;
import com.botao.pojo.Manager;
import com.botao.pojo.Product;
import com.botao.service.impl.ProductServiceImpl;
import com.botao.utils.BaseDao;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.UUID;

public class Ts {
    @Test
    public void a() throws SQLException {
        System.out.println(UUID.randomUUID().toString().replace("-", ""));
        Connection connection = BaseDao.getConnection();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from manager");

        resultSet.next();

        System.out.println(resultSet.getString("username"));
    }

    @Test
    public void b() throws Exception {
        ManagerDao managerDao = new ManagerDaoImpl();

        Connection connection = BaseDao.getConnection();

//        Manager manager = managerDao.getManagerById(connection, "4931d94bd2ad4b359abfdc75538cb030");
//
//        System.out.println(manager.getName());

        Manager jl = managerDao.getManagerByUserName(connection, "adminaa");
        if (jl == null) {
            System.out.println("查无此人！");
        }


    }

    @Test
    public void c() {
        String replace = UUID.randomUUID().toString().replace("-", "");

        System.out.println(replace);
    }

    @Test
    public void d() throws SQLException {
//        Connection connection = BaseDao.getConnection();
//        ProductDao productDao = new ProductDaoImpl();
//        Product product = new Product(null,"威龙辣条","好辣",15.5,100,"a.jpg",null,null);
//        int add = productDao.add(connection, product);
//        connection.close();
//        System.out.println(add);

        //       ProductServiceImpl productService = new ProductServiceImpl();
//        Product product = new Product(null,"臭干子","不辣",155.5,100,"b.jpg",null,null);
//        Boolean add = productService.add(product);
//        System.out.println(add);


//
//        ProductDaoImpl productDao = new ProductDaoImpl();
//        Connection connection = BaseDao.getConnection();
//
//        int remove = productDao.remove(connection, "2e426002614b4becbc630d2b553a0478");
//        System.out.println(remove);
//
//        ProductServiceImpl productService = new ProductServiceImpl();
//
//        Boolean remove = productService.remove("2e426002614b4becbc630d2b553a0478");
//
//        System.out.println(remove);

//        ProductDaoImpl productDao = new ProductDaoImpl();
//
//        List<Product> allProducts = productDao.getAllProducts(BaseDao.getConnection());
//        for (Product product : allProducts) {
//            System.out.println(product.getName());
//        }

//        ProductDaoImpl productDao = new ProductDaoImpl();
//
//        List<Product> allProducts = productDao.getAllProducts(BaseDao.getConnection());
//        for (Product product : allProducts) {
//            System.out.println(product.getName());
//        }
        System.out.println("getproductbyid".equals("getproductbyid?id=75395278e0bf4996b060053985d993a4".substring(0,14)));

    }
}
