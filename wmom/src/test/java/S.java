import com.botao.dao.impl.OrderDaoImpl;
import com.botao.pojo.Comment;
import com.botao.service.impl.CommentServiceImpl;
import com.botao.service.impl.OrderServiceImpl;
import com.botao.utils.BaseDao;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class S {

    @Test
    public void a() throws SQLException {
       /* Connection connection = BaseDao.getConnection();
        OrderDaoImpl orderDao = new OrderDaoImpl();
        int num = orderDao.getNum(connection, "8362a1f331174058895508c70d4be59f");
        System.out.println(num);*/
        CommentServiceImpl commentService = new CommentServiceImpl();
/*        Comment comment = new Comment();

        comment.setProductid("29f3be4f836b43a6aa1efee0aefb8e7d");
        comment.setText("123456");

        boolean b = commentService.addComment(comment);

        System.out.print(b);*/

        List<Comment> commentByProductId = commentService.getCommentByProductId("29f3be4f836b43a6aa1efee0aefb8e7d");


        commentByProductId.forEach(v->{
            System.out.println(v.getText());
        });


    }



    public static void main(String[] args) throws SQLException {
   /*     OrderDaoImpl orderDao = new OrderDaoImpl();
        Connection connection = BaseDao.getConnection();
        int i = orderDao.updateStatus(connection, "1289957cfd784ead92745513fb97c894", 1);

        System.out.println(i);*/

        OrderServiceImpl orderService = new OrderServiceImpl();
/*

        boolean product = orderService.getProduct("1289957cfd784ead92745513fb97c894");

        System.out.println(product);
*/

        boolean b = orderService.sendProduct("25386dcef0d144cba4496dd6661986ab");

        System.out.println(b);


    }
}
