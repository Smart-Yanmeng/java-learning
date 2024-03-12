import java.util.Random;

public class EnhanceSwitch {
    public static void main(String[] args) {
        var level = new Random().nextInt(4);
        var cnLevel = "";

        // Java 16
        switch (level) {
            case 1 -> cnLevel = "优秀";
            case 2 -> cnLevel = "良好";
            case 3 -> cnLevel = "一般";
            default -> cnLevel = "进步空间很大";
        }

        var cnLevel2 = switch (level) {
            case 1 -> {
                System.out.println("优秀");
                yield "优秀";
            }
            case 2 -> "良好";
            case 3 -> "一般";
            default -> "进步空间很大";
        };
    }
}
