package simulation;

import simulation.bodyparts.Fins;

import java.util.ArrayList;

public class Fish extends Cell {
    Fins fins = new Fins();
    private static int f_count;
    private static int fisherman_count;
    Fish(int x, int y, Diet diet, int speed) {
        super(x, y, diet, speed);
        f_count++;
    }

    void CaughtByFisherman(ArrayList entity_list, Fish fish)    {

        entity_list.remove(fish);
        fisherman_count++;

    }
    /**
     * Removes Fish object from the map
     * @param entity_list list of objects
     * @param fish Fish object to be removed
     */

    public static int getNumberOfObjects() {
        return f_count;
    }

    public static int getFisherman_count() {
        return fisherman_count;
    }

}
