package viking;

import doctrina.Canvas;
import doctrina.Game;

public class VikingGame extends Game {

    private Player player;
    private GamePad gamePad;

    @Override
    protected void initialize() {
        gamePad = new GamePad();
        player = new Player(gamePad);
        player.teleport(200, 200);
    }

    @Override
    protected void update() {
        if (gamePad.isQuitPressed()) {
            stop();
        }
        player.update();
    }

    @Override
    protected void draw(Canvas canvas) {
        player.draw(canvas);
    }
}
