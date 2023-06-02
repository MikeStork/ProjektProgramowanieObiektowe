package simulation;

import simulation.data.CONSTANTS;
import simulation.data.Diet;

import java.util.ArrayList;

/**
 * The Tiger class represents a type of cat entity in the simulation.
 */
public class Tiger extends Cat {
    private static int camouflage_ratio = 2;
    private static int t_count;

    /**
     * Constructs a Tiger object with the specified coordinates, diet, speed, and sleep properties.
     *
     * @param x            the x-coordinate of the tiger
     * @param y            the y-coordinate of the tiger
     * @param diet         the diet of the tiger
     * @param speed        the speed of the tiger
     * @param if_asleep    indicates if the tiger is asleep
     * @param sleep_count  the sleep count of the tiger
     */
    public Tiger(int x, int y, Diet diet, int speed, boolean if_asleep, int sleep_count) {
        super(x, y, diet, speed, if_asleep, sleep_count);
        this.SPRITE = CONSTANTS.CYAN + "T" + CONSTANTS.RESET;
        t_count++;
        this.size = 4;
        this.level = 3;
    }

    /**
     * Returns the number of instances of the Tiger object.
     *
     * @return the number of instances of the Tiger object
     */
    public static int getNumberOfObjects() {
        return t_count;
    }

    /**
     * Breeds an organism of the same type and appends it to the list of game entities.
     *
     * @param entity_list the list of game entities
     */
    @Override
    public void Breed(ArrayList<Entity> entity_list) {
        entity_list.add(new Tiger(this.position.x, this.position.y, this.diet, this.speed, false, 0));
    }
}