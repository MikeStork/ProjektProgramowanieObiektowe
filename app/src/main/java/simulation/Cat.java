package simulation;

import simulation.bodyparts.Claws;

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



}
