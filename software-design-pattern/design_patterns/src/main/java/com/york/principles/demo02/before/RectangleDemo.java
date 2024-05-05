package com.york.principles.demo02.before;

public class RectangleDemo {

    public static void main(String[] args) {
        // 创建长方形对象
        Rectangle rectangle = new Rectangle();

        // 设置长和宽
        rectangle.setLength(20);
        rectangle.setWidth(10);

        // 调用 resize 方法进行扩宽
        resize(rectangle);

        // 打印长和宽
        printLengthAndWidth(rectangle);

        // 创建正方形对象
        Square square = new Square();

        // 设置边长
        square.setLength(10);

        // 调用 resize 方法进行扩宽
        resize(square);

        // 打印长和宽
        printLengthAndWidth(square);
    }

    // 扩宽方法
    public static void resize(Rectangle rectangle) {
        while (rectangle.getWidth() <= rectangle.getLength()) {
            rectangle.setWidth(rectangle.getWidth() + 1);
        }
    }

    // 打印长和宽
    public static void printLengthAndWidth(Rectangle rectangle) {
        System.out.println("Length: " + rectangle.getLength() + ", Width: " + rectangle.getWidth());
    }
}
