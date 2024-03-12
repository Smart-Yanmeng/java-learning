import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> list1 = Stream.of("1", "2", "3").takeWhile("1"::equals).toList();
        System.out.println(list1);

        List<String> list2 = Stream.of("1", "2", "3").dropWhile("1"::equals).toList();
        System.out.println(list2);

        Stream.ofNullable(null).forEach(item -> {
            System.out.println("item" + item);
        });

        test(null);

        // ifPresentOrElse 方法
        Optional.ofNullable(null).ifPresentOrElse(System.out::println, () -> {
            System.out.println("empty list...");
        });

        // or 方法
        System.out.println(Optional.ofNullable(null).or(() -> Optional.of(List.of("4", "5", "6"))));

        // 直接转成流
        System.out.println(Optional.ofNullable("1").stream().toList());
    }

    public static void test(List<String> list) {
        list = Optional.ofNullable(list).orElse(new ArrayList<>());
        for (String s : list) {
            System.out.println(s);
        }
    }
}
