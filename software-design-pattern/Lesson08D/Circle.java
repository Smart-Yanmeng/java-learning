import java.awt.*;

public class Circle extends BaseShape {

    private int radius;

    public Circle(int x, int y, int radius, Color color) {
        super(x, y, color);
        this.radius = radius;
    }

    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
        graphics.drawOval(x, y, radius * 2, radius * 2);
    }

    @Override
    public int getWidth() {
        return radius * 2;
    }

    @Override
    public int getHeight() {
        return radius * 2;
    }
}
