package movingrectangle;

import doctrina.Canvas;
import doctrina.Controller;

import java.awt.*;

public class Player {

    private Controller controller;
    private int x;
    private int y;
    private int speed;

    public Player(Controller controller) {
        x = 200;
        y = 200;
        speed = 3;
        this.controller = controller;
    }

    public void update() {
        if (controller.isDownPressed()) {
            y += speed;
        } else if (controller.isUpPressed()) {
            y -= speed;
        } else if (controller.isLeftPressed()) {
            x -= speed;
        } else if (controller.isRightPressed()) {
            x += speed;
        }
    }

    public void draw(Canvas canvas) {
        canvas.drawRectangle(x, y, 20, 60, Color.WHITE);
    }
}
