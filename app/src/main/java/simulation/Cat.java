package simulation;

import simulation.bodyparts.Claws;

import java.util.ArrayList;

public class Cat extends Cell {

    boolean if_asleep;
    int sleep_count;
    private static int ca_count;
    Claws claws = new Claws();
    Cat(int x, int y, Diet diet, int speed, boolean if_asleep, int sleep_count) {
        super(x, y, diet, speed);
        ca_count++;
    }

    void sleep() {

        if(this.sleep_count > 2)    {
            this.if_asleep = false;
        }   else {
            this.sleep_count++;
        }

    }
    public static int getNumberOfObjects() {
        return ca_count;
    }

    /**
     * Prevents Cat object from moving due to the "sleep" state
     */


    /**
     * Breeds organism of given type and appends it to list of games entities
     * @param entity_list of games entities
     * @param cat  extended class of organism
     */
    @Override
    public void Breed(ArrayList<Entity> entity_list) {
        entity_list.add(new Cat(this.position.x, this.position.y, this.diet, this.speed, false, 0));
    }
}
