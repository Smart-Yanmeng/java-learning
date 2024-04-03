package src;

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task1());
        Thread thread2 = new Thread(new Task2());
        thread1.start();
        thread2.start();
    }
}

class Task1 implements Runnable {
    @Override
    public void run() {
        Singleton s1 = Singleton.getInstance(1);
        System.out.println(s1.value);
    }
}

class Task2 implements Runnable {
    @Override
    public void run() {
        Singleton s2 = Singleton.getInstance(2);
        System.out.println(s2.value);
    }
}
