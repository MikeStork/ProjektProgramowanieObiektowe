package simulation;

import simulation.data.CONSTANTS;
import simulation.data.Diet;
/**
 * The Amfiprion class represents a type of cat entity in the simulation.
 */
public class Amfiprion extends Fish {
    private static int a_count;

    Amfiprion(int x, int y, Diet diet, int speed) {
        super(x, y, diet, speed);
        this.SPRITE = CONSTANTS.YELLOW + "A" + CONSTANTS.RESET;
        a_count++;
        this.size = 2;
        this.level = 3;
    }
    /**
     * Returns number of instances of this object
     * @return Integer describing number of instances of this object
     */
    public static int getNumberOfObjects() {
        return a_count;
    }
}
