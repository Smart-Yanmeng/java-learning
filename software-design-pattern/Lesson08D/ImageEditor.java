import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ImageEditor {

    private EditorCanvas canvas;

    private CompoundGraphic allShapes = new CompoundGraphic();

    public ImageEditor() {
        canvas = new EditorCanvas();
    }

    void loadShapes(Graphic... baseShapes) {
        allShapes.clear();
        allShapes.add(baseShapes);
        canvas.refresh();
    }

    private class EditorCanvas extends Canvas {
        JFrame frame;

        private static final int PADDING = 10;

        public EditorCanvas() {
            createFrame();
            refresh();

            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    allShapes.unselect();
                    allShapes.selectChildAt(e.getX(), e.getY());
                    e.getComponent().repaint();
                }
            });
        }

        private void refresh() {
            this.setSize(800, 500);
            frame.pack();
        }

        void createFrame() {
            frame = new JFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            JPanel panel = new JPanel();
            Border border = BorderFactory.createEmptyBorder(PADDING, PADDING, PADDING, PADDING);
            panel.setBorder(border);
            panel.setBackground(Color.white);

            frame.setContentPane(panel);
            frame.add(this);
            frame.setVisible(true);
        }

        public void paint(Graphics graphics) {
            allShapes.draw(graphics);
        }
    }
}
