package simulation;

import simulation.data.CONSTANTS;
import simulation.data.Diet;

import java.util.ArrayList;
/**
 * The Eagle class represents a type of bird entity in the simulation.
 */
public class Eagle extends Bird {
    private static int e_count;

    Eagle(int x, int y, Diet diet, int speed) {
        super(x, y, diet, speed);
        this.SPRITE = CONSTANTS.GREEN + "E" + CONSTANTS.RESET;
        e_count++;
        this.size = 3;
    }
    /**
     * Returns number of instances of this object
     * @return Integer describing number of instances of this object
     */
    public static int getNumberOfObjects() {
        return e_count;
    }

    /**
     * Breeds organism of given type and appends it to list of games entities
     * @param entity_list of games entities
     */
    public void Breed(ArrayList<Entity> entity_list) {
        entity_list.add(new Eagle(this.position.x, this.position.y, this.diet, this.speed));
    }
}
