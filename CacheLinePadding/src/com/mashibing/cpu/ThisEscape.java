package src.com.mashibing.cpu;

import java.io.IOException;

public class ThisEscape {
    private final int num = 8;

    // 不要在构造方法中启动一个线程
    public ThisEscape() {
        new Thread(() -> {
            System.out.println(this.num);
        }).start();
    }

    public static void main(String[] args) throws IOException {
        new ThisEscape();
        System.in.read();
    }
}
