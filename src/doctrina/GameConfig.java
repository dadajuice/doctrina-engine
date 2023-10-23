package doctrina;

public class GameConfig {

    private static boolean debug;

    public static boolean isDebugEnabled() {
        return debug;
    }

    public static void enableDebug() {
        debug = true;
    }

    public static void disableDebug() {
        debug = false;
    }
}
