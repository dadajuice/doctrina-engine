package viking;

import doctrina.Canvas;
import doctrina.ControllableEntity;
import doctrina.MovementController;

import java.awt.*;

public class Player extends ControllableEntity {

    public Player(MovementController controller) {
        super(controller);
        setDimension(32, 32);
        setSpeed(3);
    }

    @Override
    public void update() {
        super.update();
        moveWithController();
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRectangle(this, Color.RED);
    }
}
