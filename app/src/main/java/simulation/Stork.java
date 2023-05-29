package simulation;

public class Stork extends Bird {
    private static int s_count;
    Stork(int x, int y, Diet diet, int speed) {
        super(x, y, diet, speed);
        this.SPRITE = CONSTANTS.RED_BOLD+"M"+CONSTANTS.RESET;
        s_count++;
    }
    void DeliverABaby(){}
    public static int getNumberOfObjects() {
        return s_count;
    }
}
