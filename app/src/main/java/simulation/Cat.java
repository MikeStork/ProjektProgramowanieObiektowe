package simulation;

import simulation.bodyparts.Claws;

import java.util.ArrayList;
import java.util.Random;

public class Cat extends Cell implements I_Cat{

    boolean if_asleep;
    int sleep_count;
    private static int ca_count;
    Claws claws = new Claws();
    Cat(int x, int y, Diet diet, int speed, boolean if_asleep, int sleep_count) {
        super(x, y, diet, speed);
        this.SPRITE = CONSTANTS.WHITE+"C"+CONSTANTS.RESET;
        ca_count++;
        this.size = 3;
        this.lifespan = 500;
        this.level = 2;
    }

    /**
     * Prevents Cat object from moving due to the "sleep" state
     */

    public void sleep() {

        if(this.sleep_count > 2)    {
            this.if_asleep = false;
        }   else {
            this.sleep_count++;
        }

    }

    /**
     * Return number of objects created during the simulation
     */
    public static int getNumberOfObjects() {
        return ca_count;
    }


    /**
     * Breeds organism of given type and appends it to list of games entities
     * @param entity_list of games entities
     */
    @Override
    public void Breed(ArrayList<Entity> entity_list) {
        entity_list.add(new Cat(this.position.x, this.position.y, this.diet, this.speed, false, 0));
    }

    /**
     * Checks whether organism can or cannot evolve
     * If it can, it will create new organism that matches corresponding evolution state in replacement of one that has been there
     * @param  entity_list List of games entities
     */
    @Override
    public void EvolveIfPossible(ArrayList<Entity> entity_list) {
        if(this.experience > 10)    {

            Random random = new Random();

            int r = random.nextInt(2);

            if(r == 1)  {

                Cougar cougar = new Cougar(this.position.x, this.position.y, Diet.Carnivore, 1, false, 0);
                cougar.experience = 11;
                entity_list.add(cougar);
                entity_list.remove(this);

            }   else {

                Tiger tiger = new Tiger(this.position.x, this.position.y, Diet.Carnivore, 1, false, 0);
                tiger.experience = 11;
                entity_list.add(tiger);
                entity_list.remove(this);

            }
        }
    }
}
