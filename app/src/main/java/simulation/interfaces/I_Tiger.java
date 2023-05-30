package simulation.interfaces;

import simulation.Entity;

import java.util.ArrayList;

public interface I_Tiger {

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
    void Breed(ArrayList<Entity> entity_list);
}
