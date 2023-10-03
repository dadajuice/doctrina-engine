package movingrectangle;

import doctrina.Canvas;
import doctrina.Controller;
import doctrina.Game;

import java.awt.*;

public class MovingRectangleGame extends Game {

    private GamePad gamePad;
    private Player player;
    private Npc npc;

    @Override
    protected void initialize() {
        gamePad = new GamePad();
        super.addKeyListener(gamePad);
        player = new Player(gamePad);
        npc = new Npc();
    }

    @Override
    protected void update() {
        player.update();
        npc.update();
    }

    @Override
    protected void draw(Canvas canvas) {
        canvas.drawRectangle(0, 0, 800, 600, Color.BLUE);
        player.draw(canvas);
        npc.draw(canvas);
    }
}
