package simulation;

import simulation.data.CONSTANTS;
import simulation.data.Diet;

import java.util.ArrayList;

/**
 * The Pike class represents a type of fish entity in the simulation.
 */
public class Pike extends Fish {
    private static int p_count;

    /**
     * Constructs a Pike object with the specified coordinates, diet, and speed.
     *
     * @param x     The x-coordinate of the Pike.
     * @param y     The y-coordinate of the Pike.
     * @param diet  The diet of the Pike.
     * @param speed The speed of the Pike.
     */
    Pike(int x, int y, Diet diet, int speed) {
        super(x, y, diet, speed);
        this.SPRITE = CONSTANTS.GREEN_BOLD + "S" + CONSTANTS.RESET;
        p_count++;
        this.size = 2;
        this.level = 3;
    }

    /**
     * Returns the number of instances of the Pike object.
     *
     * @return The number of instances of the Pike object.
     */
    public static int getNumberOfObjects() {
        return p_count;
    }

    /**
     * Breeds an organism of the same type and adds it to the list of game entities.
     *
     * @param entity_list The list of game entities.
     */
    @Override
    public void Breed(ArrayList<Entity> entity_list) {
        entity_list.add(new Pike(this.position.x, this.position.y, this.diet, this.speed));
    }
}
