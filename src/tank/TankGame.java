package tank;

import doctrina.Canvas;
import doctrina.CollidableRepository;
import doctrina.Game;
import doctrina.StaticEntity;

import java.util.ArrayList;

public class TankGame extends Game {

    private Tank tank;
    private GamePad gamePad;
    private ArrayList<Missile> missiles;
    private ArrayList<Brick> bricks;

    @Override
    protected void initialize() {
        gamePad = new GamePad();
        tank = new Tank(gamePad);
        missiles = new ArrayList<>();
        bricks = new ArrayList<>();
        bricks.add(new Brick(500, 100));
        bricks.add(new Brick(500, 116));
        bricks.add(new Brick(500, 132));
        bricks.add(new Brick(484, 148));
        bricks.add(new Brick(500, 164));
    }

    @Override
    protected void update() {
        if (gamePad.isQuitPressed()) {
            stop();
        }
        if (gamePad.isFirePressed() && tank.canFire()) {
            missiles.add(tank.fire());
        }
        tank.update();
        ArrayList<StaticEntity> killedElements = new ArrayList<>();

        for (Missile missile : missiles) {
            missile.update();
            for (Brick brick : bricks) {
                if (missile.hitBoxIntersectWith(brick)) {
                    killedElements.add(missile);
                    killedElements.add(brick);
                }
            }
        }

        for (StaticEntity killedElement : killedElements) {
            if (killedElement instanceof Brick) {
                bricks.remove(killedElement);
            }
            if (killedElement instanceof Missile) {
                missiles.remove(killedElement);
            }
        }
        CollidableRepository.getInstance().unregisterEntities(killedElements);
    }

    @Override
    protected void draw(Canvas canvas) {
        tank.draw(canvas);
        for (Missile missile : missiles) {
            missile.draw(canvas);
        }
        for (Brick brick : bricks) {
            brick.draw(canvas);
        }
    }
}
