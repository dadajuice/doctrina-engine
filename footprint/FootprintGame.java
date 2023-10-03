package footprint;

import doctrina.Canvas;
import doctrina.Game;

import java.awt.*;
import java.util.ArrayList;

public class FootprintGame extends Game {

    private ArrayList<Footprint> footprints;
    private Player player;
    private GamePad gamePad;

    @Override
    protected void initialize() {
        footprints = new ArrayList<>();
        gamePad = new GamePad();
        player = new Player(gamePad);
    }

    @Override
    protected void update() {
        if (gamePad.isQuitPressed()) {
            stop();
        }
        player.update();
        if (gamePad.isMoving()) {
            footprints.add(player.layFootprint());
        }
    }

    @Override
    protected void draw(Canvas canvas) {
        canvas.drawRectangle(0, 0, 800, 600, Color.BLUE);
        for (Footprint footprint : footprints) {
            footprint.draw(canvas);
        }
        player.draw(canvas);
    }
}
