package simulation.interfaces;

import simulation.Entity;
import simulation.Organism;

import java.util.ArrayList;
/**
 * Interface of Bird class
 */
public interface I_Bird {

    /**
     * Enables Bird object to make 4 fast moves
     * @param width width of the map
     * @param height height of the map
     */
    void FlyFast(int width, int height);

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
    void Breed(ArrayList<Entity> entity_list);

    /**
     * Checks whether organism can or cannot evolve
     * If it can, it will create new organism that matches corresponding evolution state in replacement of one that has been there
     * @param  entity_list List of games entities
     */
    void EvolveIfPossible(ArrayList<Entity> entity_list);

}
