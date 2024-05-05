package com.york.principles.demo02.after;

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
    }

    // 扩宽方法
    public static void resize(Rectangle rectangle) {
        while (rectangle.getWidth() <= rectangle.getLength()) {
            rectangle.setWidth(rectangle.getWidth() + 1);
        }
    }

    // 打印长和宽
    public static void printLengthAndWidth(Quadrilateral quadrilateral) {
        System.out.println("Length: " + quadrilateral.getLength() + ", Width: " + quadrilateral.getWidth());
    }
}
