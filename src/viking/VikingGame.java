package viking;

import doctrina.Canvas;
import doctrina.Game;

public class VikingGame extends Game {

    private Player player;
    private GamePad gamePad;
    private World world;

    @Override
    protected void initialize() {
        gamePad = new GamePad();
        player = new Player(gamePad);
        player.teleport(200, 200);
        world = new World();
        world.load();
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
        world.draw(canvas);
        player.draw(canvas);
    }
}
