package bouncingball;

import doctrina.Canvas;
import doctrina.Game;
import doctrina.GameTime;

import java.awt.*;

public final class BouncingBallGame extends Game {

    private Ball ball;
    private int score;

    @Override
    protected void initialize() {
        ball = new Ball(25);
    }

    @Override
    protected void update() {
        ball.update();
        if (ball.hasTouchBound()) {
            score += 10;
        }
    }

    @Override
    protected void draw(Canvas canvas) {
        ball.draw(canvas);
        canvas.drawString("Score: " + score, 10, 20, Color.WHITE);
        canvas.drawString(GameTime.getElapsedFormattedTime(), 10, 40, Color.WHITE);
        canvas.drawString("FPS: " + GameTime.getCurrentFps(), 10, 60, Color.WHITE);
    }
}
