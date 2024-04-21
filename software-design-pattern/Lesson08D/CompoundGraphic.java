import java.awt.*;
import java.util.*;
import java.util.List;

public class CompoundGraphic extends BaseShape {

    private List<Graphic> children = new ArrayList<>();

    public CompoundGraphic(Graphic... components) {
        super(1000, 1000, Color.white);
        add(components);
    }

    public void add(Graphic... components) {
        children.addAll(Arrays.asList(components));
    }

    public void remove(Graphic... components) {
        children.removeAll(Arrays.asList(components));
    }

    public void clear() {
        children.clear();
    }

    @Override
    public void move(int x, int y) {
        super.move(x, y);

        for (Graphic child : children) {
            child.move(x, y);
        }
    }

    @Override
    public void select() {
        super.select();

        for (Graphic child : children) {
            child.select();
        }
    }

    public void unselect() {
        super.unselect();

        for (Graphic child : children) {
            child.unselect();
        }
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawRect(getX(), getY(), getWidth(), getHeight());
        for (Graphic child : children) {
            child.draw(graphics);
        }
    }

    @Override
    public boolean isInsideBounds(int x, int y) {
        for (Graphic child : children) {
            if (child.isInsideBounds(x, y)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int getX() {
        if (children.size() == 0) return 0;

        int x = children.get(0).getX();

        for (Graphic child : children) {
            if (child.getX() < x) {
                x = child.getX();
            }
        }

        return x;
    }

    @Override
    public int getY() {
        if (children.size() == 0) return 0;

        int y = children.get(0).getY();

        for (Graphic child : children) {
            if (child.getY() < y) {
                y = child.getY();
            }
        }

        return y;
    }

    @Override
    public int getWidth() {
        int maxWidth = 0;

        int x = getX();

        for (Graphic child : children) {
            int cX = child.getX() - x;
            int cW = cX + child.getWidth();

            if (cW > maxWidth) {
                maxWidth = cW;
            }
        }

        return maxWidth;
    }

    @Override
    public int getHeight() {
        int maxHeight = 0;

        int y = getY();

        for (Graphic child : children) {
            int cY = child.getY() - y;
            int cH = cY + child.getHeight();

            if (cH > maxHeight) {
                maxHeight = cH;
            }
        }

        return maxHeight;
    }

    public boolean selectChildAt(int x, int y) {
        for (Graphic child : children) {
            if (child.isInsideBounds(x, y)) {
                child.select();
                return true;
            }
        }

        return false;
    }
}
