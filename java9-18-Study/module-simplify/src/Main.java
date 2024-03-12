public class Main {
    public static void main(String[] args) {
        // 无法调用外部的类
//        Test test = new Test();

        // 可以调用内部的类
        PrintName name = new PrintName();

        System.out.println("Hello world!");
    }

    static class PrintName {
        public PrintName() {
            System.out.println("My name is ...");
        }

        // 直接运行时只能获取到第一个查找到的 main 方法
        public static void main(String[] args) {
            System.out.println("This is PrintName()'s main");
        }
    }
}
