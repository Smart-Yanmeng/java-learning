import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String s = "A";

        // Java 7 之前
        ByteArrayInputStream stream1 = new ByteArrayInputStream(s.getBytes());

        try {
            System.out.println(stream1.available());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stream1.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // Java 7
//        TestDemo testDemo = new TestDemo();

        try (ByteArrayInputStream stream2 = new ByteArrayInputStream(s.getBytes());
             TestDemo testDemo = new TestDemo()) {
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Java 9
        TestDemo testDemo = new TestDemo();

        try(testDemo) {
            testDemo.exec();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
