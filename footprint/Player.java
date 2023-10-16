package footprint;

import doctrina.Canvas;
import doctrina.ControllableEntity;

import java.awt.*;

public class Player extends ControllableEntity {

    public Player(GamePad gamePad) {
        super(gamePad);
        teleport(200, 200);
        setDimension(20, 60);
        setSpeed(3);
    }

    public Footprint layFootprint() {
        return new Footprint(x, y);
    }

    @Override
    public void update() {
        moveWithController();
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRectangle(this, Color.WHITE);
    }
}
