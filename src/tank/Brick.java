package tank;

import doctrina.Canvas;
import doctrina.CollidableRepository;
import doctrina.StaticEntity;

import java.awt.*;

public class Brick extends StaticEntity {

    public Brick(int x, int y) {
        setDimension(16, 16);
        teleport(x, y);
        CollidableRepository.getInstance().registerEntity(this);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRectangle(this, Color.WHITE);
    }
}
