package src.com.mashibing.cpu;

import java.util.concurrent.CountDownLatch;

public class Disorder {
    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        for (long i = 0; i < Long.MAX_VALUE; i++) {
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            CountDownLatch latch = new CountDownLatch(2);

            Thread one = new Thread(() -> {
                a = 1;
                x = b;

                latch.countDown();
            });

            Thread two = new Thread(() -> {
                b = 1;
                y = a;

                latch.countDown();
            });

            one.start();
            two.start();
            latch.await();
            String result = "第" + i + "次 - (" + x + ", " + y + ")";
            if (x == 0 && y == 0) {
                System.err.println(result);

                break;
            }

        }
    }
}
