package tank;

import doctrina.MovementController;

import java.awt.event.KeyEvent;

public class GamePad extends MovementController {

    private int quitKey = KeyEvent.VK_Q;
    private int fireKey = KeyEvent.VK_SPACE;

    public GamePad() {
        bindKey(quitKey);
        bindKey(fireKey);
    }

    public boolean isFirePressed() {
        return isKeyPressed(fireKey);
    }

    public boolean isQuitPressed() {
        return isKeyPressed(quitKey);
    }
}
