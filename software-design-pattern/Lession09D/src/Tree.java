package src;

import java.awt.*;

public class Tree {
    TreeType type;
    int x;
    int y;

    public Tree(int x, int y, TreeType type) {
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        type.draw(g, x, y);
    }
}
