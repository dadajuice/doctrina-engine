package movingrectangle;

import doctrina.Canvas;
import doctrina.Controller;

import java.awt.*;

public class Player {

    private GamePad gamePad;
    private int x;
    private int y;
    private int speed;

    public Player(GamePad gamePad) {
        x = 200;
        y = 200;
        speed = 3;
        this.gamePad = gamePad;
    }

    public void update() {
        if (gamePad.isDownPressed()) {
            y += speed;
        } else if (gamePad.isUpPressed()) {
            y -= speed;
        } else if (gamePad.isLeftPressed()) {
            x -= speed;
        } else if (gamePad.isRightPressed()) {
            x += speed;
        }
    }

    public void draw(Canvas canvas) {
        canvas.drawRectangle(x, y, 20, 60, Color.WHITE);
    }
}
