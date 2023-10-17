package tank;

import doctrina.Canvas;
import doctrina.CollidableRepository;
import doctrina.Direction;
import doctrina.MovableEntity;

import java.awt.*;

public class Missile extends MovableEntity {

    private final Direction tankDirection;

    public Missile(Tank tank) {
        setSpeed(5);
        tankDirection = tank.getDirection();
        initialize(tank);
        CollidableRepository.getInstance().registerEntity(this);
    }

    @Override
    public void update() {
        move(tankDirection);
        if (x >= 820) {
            x = -20;
        }
        if (y >= 620) {
            y = -20;
        }
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRectangle(this, Color.YELLOW);
    }

    private void initialize(Tank tank) {
        if (tankDirection == Direction.RIGHT) {
            teleport(tank.getX() + tank.getWidth() + 1,
                    tank.getY() + 15 - 2);
            setDimension(8, 4);
        } else if (tankDirection == Direction.LEFT) {
            teleport(tank.getX() - 9, tank.getY() + 15 - 2);
            setDimension(8, 4);
        } else if (tankDirection == Direction.DOWN) {
            teleport(tank.getX() + 15 - 2,
                    tank.getY() + tank.getHeight() + 1);
            setDimension(4, 8);
        } else if (tankDirection == Direction.UP) {
            teleport(tank.getX() + 15 - 2, tank.getY() - 9);
            setDimension(4, 8);
        }
    }
}
