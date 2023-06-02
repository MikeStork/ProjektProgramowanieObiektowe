package simulation.interfaces;

import simulation.Entity;
import simulation.Fish;

import java.util.ArrayList;
/**
 * Interface of Fish class
 */
public interface I_Fish {

    /**
     * Removes Fish object from the map
     * @param entity_list list of objects
     */

    void CaughtByFisherman(ArrayList entity_list);

    /**
     * Returns number of instances of this object
     * @return Integer describing number of instances of this object
     */
    static int getNumberOfObjects() {
        return 0;
    }

    /**
     * Breeds organism of given type and appends it to list of games entities
     * @param entity_list List of games entities
     */
    public void Breed(ArrayList<Entity> entity_list);

    /**
     * Checks whether organism can or cannot evolve
     * If it can, it will create new organism that matches corresponding evolution state in replacement of one that has been there
     * @param entity_list List of games entities
     */
    public void EvolveIfPossible(ArrayList<Entity> entity_list);

}
