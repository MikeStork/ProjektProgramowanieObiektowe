package simulation;

public class Amfiprion extends Fish {
    private static int a_count;
    Amfiprion(int x, int y, Diet diet, int speed) {
        super(x, y, diet, speed);
        this.SPRITE = CONSTANTS.RED_BOLD_BRIGHT+"A"+CONSTANTS.RESET;
        a_count++;
    }
    /**
     * @exception Unimplemented
     */
    public static int getNumberOfObjects() {
        return a_count;
    }
    void DeepDive(){}
}
