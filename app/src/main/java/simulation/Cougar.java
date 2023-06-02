package simulation;

import simulation.data.CONSTANTS;
import simulation.data.Diet;

import java.util.ArrayList;
/**
 * The Cougar class represents a type of cat entity in the simulation.
 */
public class Cougar extends Cat {
    int speed_incrementation = 1;
    private static int co_count;

    Cougar(int x, int y, Diet diet, int speed, boolean if_asleep, int sleep_count) {
        super(x, y, diet, speed, if_asleep, sleep_count);
        this.SPRITE = CONSTANTS.YELLOW_BOLD + "P" + CONSTANTS.RESET;
        co_count++;
        this.size = 4;
        this.level = 3;
    }
    /**
     * Returns number of instances of this object
     * @return Integer describing number of instances of this object
     */
    public static int getNumberOfObjects() {
        return co_count;
    }

    /**
     * Breeds organism of given type and appends it to list of games entities
     * @param entity_list List of games entities
     */
    @Override
    public void Breed(ArrayList<Entity> entity_list) {
        entity_list.add(new Cougar(this.position.x, this.position.y, this.diet, this.speed, false, 0));
    }
}
