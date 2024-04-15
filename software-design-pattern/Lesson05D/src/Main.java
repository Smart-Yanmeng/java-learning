public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(1, 2, "red", 3, 4);

        Rectangle r1 = rectangle; // Shallow copy
        Rectangle r2 = (Rectangle) rectangle.clone(); // Deep copy

        System.out.println(r1 == rectangle ? "r1 is the same object as rectangle" : "r1 is a different object from rectangle");
        System.out.println(r1.compare(rectangle) ? "r1 is the same object as rectangle" : "r1 is a different object from rectangle");

        System.out.println(r2 == rectangle ? "r2 is the same object as rectangle" : "r2 is a different object from rectangle");
        System.out.println(r2.compare(rectangle) ? "r2 is the same object as rectangle" : "r2 is a different object from rectangle");

        Circle circle = new Circle(1, 2, "red", 3);

        Circle c1 = circle; // Shallow copy
        Circle c2 = (Circle) circle.clone(); // Deep copy

        System.out.println(c1 == circle ? "c1 is the same object as circle" : "c1 is a different object from circle");
        System.out.println(c1.compare(circle) ? "c1 is the same object as circle" : "c1 is a different object from circle");

        System.out.println(c2 == circle ? "c2 is the same object as circle" : "c2 is a different object from circle");
        System.out.println(c2.compare(circle) ? "c2 is the same object as circle" : "c2 is a different object from circle");
    }
}
