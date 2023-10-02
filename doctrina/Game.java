package doctrina;

public abstract class Game {

    private RenderingEngine renderingEngine;
    private boolean playing = true;
    private GameTime gameTime;

    protected abstract void initialize();
    protected abstract void update();
    protected abstract void draw(Canvas canvas);

    public Game() {
        renderingEngine = new RenderingEngine();
    }

    public final void start() {
        initialize();
        run();
        //conclude();
    }

    private void run() {
        renderingEngine.start();
        gameTime = new GameTime();
        while (playing) {
            update();
            draw(renderingEngine.buildCanvas());
            renderingEngine.drawOnScreen();
            gameTime.sleep();
        }
        renderingEngine.stop();
    }
}
