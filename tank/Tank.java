package tank;

import doctrina.Canvas;
import doctrina.ControllableEntity;
import doctrina.MovementController;

import java.awt.*;

public class Tank extends ControllableEntity {

    private int cooldown = 0;

    public Tank(MovementController controller) {
        super(controller);
        setDimension(30, 30);
        setSpeed(2);
        teleport(100, 100);
    }

    public Missile fire() {
        cooldown = 50;
        return new Missile(this);
    }

    public boolean canFire() {
        return cooldown == 0;
    }

    @Override
    public void update() {
        moveWithController();
        cooldown--;
        if (cooldown < 0) {
            cooldown = 0;
        }
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRectangle(this, Color.GREEN);
        int cooldownWidth = cooldown * width / 50;
        canvas.drawRectangle(x, y - 5, cooldownWidth, 2, Color.RED);
    }
}
