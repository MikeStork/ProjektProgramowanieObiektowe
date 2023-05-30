package simulation;

import java.util.ArrayList;

public interface I_Cell {

    /**
     * Creates new object due to an encounter of the two same-type objects
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
