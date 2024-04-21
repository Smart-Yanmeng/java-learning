import java.awt.*;

public interface Graphic {

    void select();

    void unselect();

    boolean isSelected();

    void move(int x, int y);

    void draw(Graphics graphics);

    boolean isInsideBounds(int x, int y);

    int getX();

    int getY();

    int getWidth();

    int getHeight();
}
