package src;

import java.awt.*;

public class MyTree {

    String name;

    Color color;

    String texture;

    int x;

    int y;

    public MyTree(String name, Color color, String texture, int x, int y) {
        this.name = name;
        this.color = color;
        this.texture = texture;
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(x - 1, y, 3, 5);
        g.setColor(color);
        g.fillOval(x - 5, y - 10, 10, 10);
    }
}
