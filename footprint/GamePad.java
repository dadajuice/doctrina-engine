package footprint;

import doctrina.MovementController;

import java.awt.event.KeyEvent;

public class GamePad extends MovementController {

    private int quitKey = KeyEvent.VK_Q;

    public GamePad() {
        bindKey(quitKey);
    }

    public boolean isQuitPressed() {
        return isKeyPressed(quitKey);
    }
}
