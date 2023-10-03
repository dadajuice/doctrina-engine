import doctrina.Game;
import doctrina.GameTime;

public class App {

    public static void main(String[] args) {
        Game game = new BouncingBallGame();
        game.start();
    }
}
