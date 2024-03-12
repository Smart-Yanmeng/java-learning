import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int level = new Random().nextInt(4);
        String cnLevel;

        // Java 8
        switch (level) {
            case 1:
                cnLevel = "优秀";
                break;
            case 2:
                cnLevel = "良好";
                break;
            case 3:
                cnLevel = "一般";
                break;
            default:
                cnLevel = "进步空间很大";
                break;
        }
    }
}
