package simulation;

import simulation.data.CONSTANTS;
import simulation.data.Diet;

public class Amfiprion extends Fish implements I_Amfiprion {
    private static int a_count;
    Amfiprion(int x, int y, Diet diet, int speed) {
        super(x, y, diet, speed);
        this.SPRITE = CONSTANTS.YELLOW+"A"+CONSTANTS.RESET;
        a_count++;
        this.size = 2;
        this.level = 3;
    }
    /**
     * @exception Unimplemented
     */
    public static int getNumberOfObjects() {
        return a_count;
    }
    void DeepDive(){}
}
