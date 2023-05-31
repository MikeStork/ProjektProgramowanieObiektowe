package simulation;

import simulation.data.CONSTANTS;
import simulation.data.Diet;

import java.util.ArrayList;

/**
 * The Stork class represents a type of bird entity in the simulation.
 */
public class Stork extends Bird {
    private static int s_count;

    /**
     * Constructs a Stork object with the specified coordinates, diet, and speed.
     *
     * @param x     the x-coordinate of the stork
     * @param y     the y-coordinate of the stork
     * @param diet  the diet of the stork
     * @param speed the speed of the stork
     */
    public Stork(int x, int y, Diet diet, int speed) {
        super(x, y, diet, speed);
        this.SPRITE = CONSTANTS.RED_BOLD + "M" + CONSTANTS.RESET;
        s_count++;
        this.size = 3;
        this.level = 3;
    }

    /**
     * Returns the number of instances of the Stork object.
     *
     * @return the number of instances of the Stork object
     */
    public static int getNumberOfObjects() {
        return s_count;
    }

    /**
     * Breeds an organism of the same type and appends it to the list of game entities.
     *
     * @param entity_list the list of game entities
     */
    @Override
    public void Breed(ArrayList<Entity> entity_list) {
        entity_list.add(new Stork(this.position.x, this.position.y, this.diet, this.speed));
    }
}