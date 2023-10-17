package doctrina;

import java.awt.*;

public class Collision {

    private final MovableEntity entity;

    public Collision(MovableEntity entity) {
        this.entity = entity;
    }

    public int getAllowedSpeed(Direction direction) {
        switch (direction) {
            case UP: return getAllowedUpSpeed();
            case DOWN: return getAllowedDownSpeed();
            case LEFT: return getAllowedLeftSpeed();
            case RIGHT: return getAllowedRightSpeed();
        }
        return 0;
    }

    private int getAllowedUpSpeed() {
        return distance(other -> entity.y - (other.y + other.height));
    }

    private int getAllowedDownSpeed() {
        return distance(other -> other.y - (entity.y + entity.height));
    }

    private int getAllowedLeftSpeed() {
        return distance(other -> entity.x - (other.x + other.width));
    }

    private int getAllowedRightSpeed() {
        return distance(other -> other.x - (entity.x + entity.width));
    }

    private int distance(DistanceCalculator calculator) {
        Rectangle collisionBound = entity.getHitBox();
        int allowedDistance = entity.getSpeed();
        for (StaticEntity other : CollidableRepository.getInstance()) {
            if (collisionBound.intersects(other.getBounds())) {
                allowedDistance = Math.min(allowedDistance,
                        calculator.calculateWith(other));
            }
        }
        return allowedDistance;
    }

    private interface DistanceCalculator {
        int calculateWith(StaticEntity other);
    }
}
