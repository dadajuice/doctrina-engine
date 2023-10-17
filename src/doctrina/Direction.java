package doctrina;

public enum Direction {
    LEFT(-1, 0),
    RIGHT(1, 0),
    UP(0, -1),
    DOWN(0, 1);

    private final int velocityX;
    private final int velocityY;

    Direction(int velocityX, int velocityY) {
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public int calculateVelocityX(int speed) {
        return velocityX * speed;
    }

    public int calculateVelocityY(int speed) {
        return velocityY * speed;
    }
}
