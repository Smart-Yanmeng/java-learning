package src;

import java.awt.*;

public class TreeType {

    String name;

    Color color;

    String texture;

    public TreeType(String name, Color color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    public void draw(Graphics g, int x, int y) {
        g.setColor(Color.black);
        g.fillRect(x - 1, y, 3, 5);
        g.setColor(color);
        g.fillOval(x - 5, y - 10, 10, 10);
    }

}
