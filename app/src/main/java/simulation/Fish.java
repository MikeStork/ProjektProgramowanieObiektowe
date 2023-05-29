package simulation;

import simulation.bodyparts.Fins;

import java.util.ArrayList;

public class Fish extends Cell {
    Fins fins = new Fins();
    private static int f_count;
    private static int fisherman_count;
    Fish(int x, int y, Diet diet, int speed) {
        super(x, y, diet, speed);
        this.SPRITE = CONSTANTS.BLUE+"F"+CONSTANTS.RESET;
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

    /**
     * Breeds organism of given type and appends it to list of games entities
     * @param entity_list List of games entities
     */
    @Override
    public void Breed(ArrayList<Entity> entity_list) {
        entity_list.add(new Fish(this.position.x, this.position.y, this.diet, this.speed));
    }
}
