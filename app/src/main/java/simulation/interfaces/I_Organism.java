package simulation.interfaces;

import simulation.Entity;

import java.util.ArrayList;

public interface I_Organism {

    /**
     * Randomly changes coordinates of Organism
     * @param  WIDTH  width of the map
     * @param  HEIGHT height of the map
     */
    void Move(int WIDTH, int HEIGHT);

    /**
     * Given list of entities, search for the first entity which is in the distance of Organism.
     * @param entity_list List of games entities
     */
    public Entity CheckSurroundings(ArrayList<Entity> entity_list);

    /**
     * Controlls consumption of entity
     *
     * @param e           Entity to be eaten
     * @param entity_list List of games entities
     * @param entity_map  String array that serves as map
     */

    private void Eat(Entity e, ArrayList<Entity> entity_list, String[][] entity_map) {
    }

    /**
     * Checks whether given entity can be consumed
     * @param e Entity to be eaten
     * @param entity_list List of games entities
     * @param entity_map String array that serves as map
     */

    void EatIfPossible(Entity e, ArrayList<Entity> entity_list, String[][] entity_map);

    /**
     * Checks whether given entity should be terminated
     * @param entity_list List of games entities
     * @param entity_map String array that serves as map
     */

    boolean DieIfPossible(ArrayList<Entity> entity_list, String[][] entity_map);

    /**
     * Creates new object due to an encounter of the two same-type objects
     * @param entity_list List of games entities
     */

    void Breed(ArrayList<Entity> entity_list);

    /**
     * Checks whether the entity is able to evolve
     * @param entity_list List of games entities
     */

    void EvolveIfPossible(ArrayList<Entity> entity_list);




}
