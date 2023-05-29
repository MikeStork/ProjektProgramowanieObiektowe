package simulation;

public class Pike extends Fish {
    private static int p_count;
    Pike(int x, int y, Diet diet, int speed) {
        super(x, y, diet, speed);
        this.SPRITE = CONSTANTS.GREEN_BOLD+"S"+CONSTANTS.RESET;
        p_count++;
    } public static int getNumberOfObjects() {
        return p_count;
    }


}
