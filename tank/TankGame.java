package tank;

import doctrina.Canvas;
import doctrina.Game;

public class TankGame extends Game {

    private Tank tank;
    private GamePad gamePad;

    @Override
    protected void initialize() {
        gamePad = new GamePad();
        tank = new Tank(gamePad);
    }

    @Override
    protected void update() {
        if (gamePad.isQuitPressed()) {
            stop();
        }
        tank.update();
    }

    @Override
    protected void draw(Canvas canvas) {
        tank.draw(canvas);
    }
}
