package tank;

import doctrina.Canvas;
import doctrina.ControllableEntity;
import doctrina.MovementController;

import java.awt.*;

public class Tank extends ControllableEntity {

    public Tank(MovementController controller) {
        super(controller);
        setDimension(30, 30);
        setSpeed(2);
        teleport(100, 100);
    }

    @Override
    public void update() {
        moveWithController();
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRectangle(this, Color.GREEN);
    }
}
