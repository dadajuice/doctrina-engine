import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Game {
    private static final int SLEEP = 25;

    private RenderingEngine renderingEngine;
    private Ball ball;
    private boolean playing = true;
    private long before;
    private int score;

    public Game() {
        renderingEngine = new RenderingEngine();
        ball = new Ball(25);
    }

    public void start() {
        renderingEngine.start();
        updateSyncTime();
        while (playing) {
            update();
            drawOnBuffer(renderingEngine.buildBuffer());
            renderingEngine.drawOnScreen();
            sleep();
        }
    }

    private void update() {
        ball.update();
        if (ball.hasTouchBound()) {
            score += 10;
        }
    }

    private void drawOnBuffer(Graphics2D buffer) {
        ball.draw(buffer);
        buffer.setPaint(Color.WHITE);
        buffer.drawString("Score: " + score, 10, 20);
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



    private void updateSyncTime() {
        before = System.currentTimeMillis();
    }


}
