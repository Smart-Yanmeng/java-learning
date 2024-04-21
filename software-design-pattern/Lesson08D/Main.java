import java.awt.*;

public class Main {
    public static void main(String[] args) {
        ImageEditor editor = new ImageEditor();
        editor.loadShapes(
                new Circle(10, 10, 50, Color.BLUE),
                new CompoundGraphic(
                        new Circle(100, 100, 30, Color.RED),
                        new Dot(150, 150, Color.RED)
                ),
                new CompoundGraphic(
                        new Circle(200, 200, 100, Color.GREEN),
                        new Rectangle(250, 250, 100, 50, Color.GREEN)
                )
        );
    }
}
