import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String s = "1";

        ByteArrayInputStream bytes = new ByteArrayInputStream(s.getBytes());

        var bytesTwo = new ByteArrayInputStream(s.getBytes());

        // 无法使用 var
        Map<String, Map<String, List<String>>> maps = new HashMap<>();

        System.out.println(bytes.available());
        System.out.println(bytesTwo.available());
    }
}
