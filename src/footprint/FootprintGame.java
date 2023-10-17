package footprint;

import doctrina.Canvas;
import doctrina.Game;

import java.awt.*;
import java.util.ArrayList;

public class FootprintGame extends Game {

    private ArrayList<Footprint> footprints;
    private Player playerOne;
    private Player playerTwo;
    private GamePad gamePadOne;
    private GamePad gamePadTwo;

    @Override
    protected void initialize() {
        footprints = new ArrayList<>();
        gamePadOne = new GamePad();
        gamePadTwo = new GamePad();
        gamePadTwo.useWasdKeys();
        playerOne = new Player(gamePadOne, Color.WHITE);
        playerTwo = new Player(gamePadTwo, Color.YELLOW);
    }

    @Override
    protected void update() {
        if (gamePadOne.isQuitPressed()) {
            stop();
        }
        playerOne.update();
        playerTwo.update();
        if (gamePadOne.isMoving()) {
            footprints.add(playerOne.layFootprint());
        }
        if (gamePadTwo.isMoving()) {
            footprints.add(playerTwo.layFootprint());
        }
    }

    @Override
    protected void draw(Canvas canvas) {
        canvas.drawRectangle(0, 0, 800, 600, Color.BLUE);
        drawFootprints(canvas);
        playerOne.draw(canvas);
        playerTwo.draw(canvas);
    }

    private void drawFootprints(Canvas canvas) {
        for (Footprint footprint : footprints) {
            footprint.draw(canvas);
        }
    }
}
