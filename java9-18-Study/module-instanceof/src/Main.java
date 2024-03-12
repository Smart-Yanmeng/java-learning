import com.qztc.Apple;
import com.qztc.Fruit;

public class Main {
    public static void main(String[] args) {
        Fruit apple = new Apple();

        // Java 16 之前
        if (apple instanceof Apple) {
            Apple a = (Apple) apple;
            a.exec();
        }

        if (apple instanceof Apple a) {
            a.exec();
        }
    }
}
