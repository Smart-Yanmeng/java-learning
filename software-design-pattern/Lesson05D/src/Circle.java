public class Circle extends Shape {
    private int radius;

    public Circle(int x, int y, String color, int radius) {
        super(x, y, color);
        this.radius = radius;
    }

    public Circle(Circle circle) {
        super(circle);
        this.radius = circle.radius;
    }

    @Override
    public Shape clone() {
        return new Circle(this);
    }

    @Override
    public boolean compare(Object o) {
        if (!(o instanceof Circle)) return false;
        Circle c = (Circle) o;

        return super.compare(c) && c.radius == radius;
    }
}
