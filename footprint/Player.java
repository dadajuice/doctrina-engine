package footprint;

import doctrina.Canvas;
import doctrina.MovableEntity;

import java.awt.*;

public class Player extends MovableEntity {

    private GamePad gamePad;

    public Player(GamePad gamePad) {
        teleport(200, 200);
        setDimension(20, 60);
        setSpeed(3);
        this.gamePad = gamePad;
    }

    public Footprint layFootprint() {
        return new Footprint(x, y);
    }

    public void update() {
        if (gamePad.isMoving()) {
            move(gamePad.getDirection());
        }
    }

    public void draw(Canvas canvas) {
        canvas.drawRectangle(this, Color.WHITE);
    }
}
