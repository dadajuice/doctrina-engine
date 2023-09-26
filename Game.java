import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Game {
    private static final int SLEEP = 25;

    private Ball ball;
    private JFrame frame;
    private JPanel panel;
    private boolean playing = true;
    private BufferedImage bufferedImage;
    private Graphics2D bufferEngine;
    private long before;
    private int score;

    public Game() {
        initializeFrame();
        initializePanel();
        ball = new Ball(25);
    }

    public void start() {
        frame.setVisible(true);
        updateSyncTime();
        while (playing) {
            bufferedImage = new BufferedImage(800, 600,
                    BufferedImage.TYPE_INT_RGB);
            bufferEngine = bufferedImage.createGraphics();
            bufferEngine.setRenderingHints(buildRenderingHints());
            update();
            drawOnBuffer();
            drawOnScreen();
            sleep();
        }
    }

    private void update() {
        ball.update();
        if (ball.hasTouchBound()) {
            score += 10;
        }
    }

    private void drawOnBuffer() {
        //bufferEngine.setPaint(Color.BLUE);
        //bufferEngine.fillRect(0, 0, 800, 600);

        ball.draw(bufferEngine);

        bufferEngine.setPaint(Color.WHITE);
        bufferEngine.drawString("Score: " + score, 10, 20);
    }

    private void drawOnScreen() {
        Graphics2D graphics = (Graphics2D) panel.getGraphics();
        graphics.drawImage(bufferedImage, 0, 0, panel);
        Toolkit.getDefaultToolkit().sync();
        graphics.dispose();
    }

    private void sleep() {
        try {
            Thread.sleep(getSleepTime());
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        updateSyncTime();
    }

    private long getSleepTime() {
        long sleep = SLEEP - (System.currentTimeMillis() - before);
        if (sleep < 4) {
            sleep = 4;
        }
        return sleep;
    }

    private void initializePanel() {
        panel = new JPanel();
        panel.setBackground(Color.BLUE);
        panel.setFocusable(true);
        panel.setDoubleBuffered(true);
        frame.add(panel);
    }

    private void initializeFrame() {
        frame = new JFrame();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setTitle("My Bouncing Balls");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setState(JFrame.NORMAL);
        //frame.setUndecorated(true);
    }

    private void updateSyncTime() {
        before = System.currentTimeMillis();
    }

    private RenderingHints buildRenderingHints() {
        RenderingHints hints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        hints.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        return hints;
    }
}
