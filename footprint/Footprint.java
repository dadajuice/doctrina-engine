package footprint;

import doctrina.Canvas;

import java.awt.*;
import java.util.Random;

public class Footprint {

    private int x;
    private int y;
    private int width;
    private int height;

    public Footprint(int x, int y) {
        this.x = x;
        this.y = y;
        width = 5;
        height = 5;
    }

    public void draw(Canvas canvas) {
        Color color = new Color(getRandomValue(),
                getRandomValue(), getRandomValue());
        canvas.drawRectangle(x, y, width, height, color);
    }

    private int getRandomValue() {
        return new Random().nextInt(256);
    }
}
