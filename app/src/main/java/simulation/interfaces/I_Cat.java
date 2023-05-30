package simulation.interfaces;

import simulation.Entity;

import java.util.ArrayList;

public interface I_Cat {

    /**
     * Prevents Cat object from moving due to the "sleep" state
     */
    void sleep();

    /**
     * Return number of objects created during the simulation
     */
    static int getNumberOfObjects() {
        return 0;
    }

    /**
     * Breeds organism of given type and appends it to list of games entities
     * @param entity_list of games entities
     */
    void Breed(ArrayList<Entity> entity_list);

    /**
     * Checks whether organism can or cannot evolve
     * If it can, it will create new organism that matches corresponding evolution state in replacement of one that has been there
     * @param  entity_list List of games entities
     */

    void EvolveIfPossible(ArrayList<Entity> entity_list);





}
