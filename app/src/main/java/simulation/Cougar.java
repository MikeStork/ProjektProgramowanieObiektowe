package simulation;

public class Cougar extends Cat {
    int speed_incrementation = 1;
    private static int co_count;

    Cougar(int x, int y, Diet diet, int speed, boolean if_asleep, int sleep_count) {
        super(x, y, diet, speed, if_asleep, sleep_count);
        this.SPRITE = CONSTANTS.YELLOW_BOLD+ "G"+CONSTANTS.RESET;
        co_count++;
    }
    public static int getNumberOfObjects() {
        return co_count;
    }
}
