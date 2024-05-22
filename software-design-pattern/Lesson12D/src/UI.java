package src;

import javax.swing.*;
import java.awt.*;

public class UI {

    private final Player player;

    private static final JTextField textField = new JTextField();

    public UI(Player player) {
        this.player = player;
    }

    public void init() {

        JFrame frame = new JFrame("Test player");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel context = new JPanel();
        context.setLayout(new BoxLayout(context, BoxLayout.Y_AXIS));
        frame.getContentPane().add(context);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        context.add(textField);
        context.add(buttons);

        JButton play = new JButton("Play");
        play.addActionListener(_ -> textField.setText(player.getState().onPlay()));

        JButton stop = new JButton("Stop");
        stop.addActionListener(_ -> textField.setText(player.getState().onLock()));

        JButton next = new JButton("Next");
        next.addActionListener(_ -> textField.setText(player.getState().onNext()));

        JButton prev = new JButton("Prev");
        prev.addActionListener(_ -> textField.setText(player.getState().onPrevious()));

        frame.setVisible(true);
        frame.setSize(400, 100);
        buttons.add(play);
        buttons.add(stop);
        buttons.add(next);
        buttons.add(prev);
    }
}
