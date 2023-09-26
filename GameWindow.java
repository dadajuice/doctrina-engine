import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    private JPanel panel;

    public GameWindow() {
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("My Bouncing Balls");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setState(JFrame.NORMAL);

        panel = new JPanel();
        panel.setBackground(Color.BLUE);
        panel.setFocusable(true);
        panel.setDoubleBuffered(true);
        add(panel);
    }

    public void start() {
        setVisible(true);
    }

}
