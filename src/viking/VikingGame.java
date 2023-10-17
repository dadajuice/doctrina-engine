package viking;

import doctrina.Canvas;
import doctrina.Game;

public class VikingGame extends Game {

    private Player player;
    private GamePad gamePad;
    private World world;
    private Tree tree;

    @Override
    protected void initialize() {
        gamePad = new GamePad();
        player = new Player(gamePad);
        player.teleport(200, 200);
        world = new World();
        world.load();
        tree = new Tree();
        tree.teleport(300, 350);
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
        // 80 (tree height) - 28 (max for layer switch)
        if (player.getY() < tree.getY() + 52) {
            player.draw(canvas);
            tree.draw(canvas);
        } else {
            tree.draw(canvas);
            player.draw(canvas);
        }
    }
}
