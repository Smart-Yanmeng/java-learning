public abstract class Shape {
    private int x, y;

    private String color;

    public Shape(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Shape(Shape shape) {
        this.x = shape.x;
        this.y = shape.y;
        this.color = shape.color;
    }

    public abstract Shape clone();

    public boolean compare(Object o) {
        if (!(o instanceof Shape)) return false;
        Shape s = (Shape) o;

        return s.x == x && s.y == y && s.color.equals(color);
    }
}
