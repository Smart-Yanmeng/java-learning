import java.awt.*;

public class Dot extends BaseShape {
    public Dot(int x, int y, Color color) {
        super(x, y, color);
    }

    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
        graphics.fillOval(x, y, 9, 9);
    }

    @Override
    public int getWidth() {
        return 3;
    }

    @Override
    public int getHeight() {
        return 3;
    }
}
