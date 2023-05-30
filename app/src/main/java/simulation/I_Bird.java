package simulation;

import java.util.ArrayList;

public interface I_Bird {

    /**
     * Enables Bird object to make 4 fast moves
     * @param width width of the map
     * @param height height of the map
     * @param org Organism object able to make a move
     */
    void FlyFast(int width, int height, Organism org);

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

    /**
     * Checks whether organism can or cannot evolve
     * If it can, it will create new organism that matches corresponding evolution state in replacement of one that has been there
     * @param  entity_list List of games entities
     */
    void EvolveIfPossible(ArrayList<Entity> entity_list);

}
