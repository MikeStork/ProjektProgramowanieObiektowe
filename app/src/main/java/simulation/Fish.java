package simulation;

import simulation.bodyparts.Fins;

import java.util.ArrayList;

public class Fish extends Cell {
    Fins fins = new Fins();
    Fish(int x, int y, Diet diet, int speed) {
        super(x, y, diet, speed);
    }

    void CaughtByFisherman(ArrayList entity_list, Fish fish)    {

        entity_list.remove(fish);

    }
    /**
     * Removes Fish object from the map
     * @param entity_list list of objects
     * @param fish Fish object to be removed
     */

}
