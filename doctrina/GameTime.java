package doctrina;

public class GameTime {

    private static final int SLEEP = 25;

    private long syncTime;

    public static long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public GameTime() {
        updateSyncTime();
    }

    public void sleep() {
        try {
            Thread.sleep(getSleepTime());
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        updateSyncTime();
    }

    private long getSleepTime() {
        long sleep = SLEEP - (System.currentTimeMillis() - syncTime);
        if (sleep < 4) {
            sleep = 4;
        }
        return sleep;
    }

    private void updateSyncTime() {
        syncTime = System.currentTimeMillis();
    }
}
