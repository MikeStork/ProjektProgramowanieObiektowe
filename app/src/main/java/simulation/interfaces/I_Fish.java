package simulation.interfaces;

import simulation.Entity;
import simulation.Fish;

import java.util.ArrayList;

public interface I_Fish {

    /**
     * Removes Fish object from the map
     * @param entity_list list of objects
     * @param fish Fish object to be removed
     */

    void CaughtByFisherman(ArrayList entity_list, Fish fish);

    /**
     * Return number of objects created during the simulation
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
     * @param  entity_list List of games entities
     */
    public void EvolveIfPossible(ArrayList<Entity> entity_list);

}
