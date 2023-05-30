package simulation;


import simulation.data.CONSTANTS;
import simulation.data.Diet;
import simulation.interfaces.I_Fish;

import java.util.ArrayList;
import java.util.Random;

public class Fish extends Cell implements I_Fish {
    private static int f_count;
    private static int fisherman_count;
    Fish(int x, int y, Diet diet, int speed) {
        super(x, y, diet, speed);
        this.SPRITE = CONSTANTS.BLUE+"F"+CONSTANTS.RESET;
        f_count++;
        this.size = 1;
        this.lifespan = 300;
        this.level = 2;
    }

    /**
     * Removes Fish object from the map
     * @param entity_list list of objects
     */
    public void CaughtByFisherman(ArrayList entity_list)    {
        entity_list.remove(this);
        fisherman_count++;
    }

    public static int getNumberOfObjects() {
        return f_count;
    }

    /**
     * Breeds organism of given type and appends it to list of games entities
     * @param entity_list List of games entities
     */
    @Override
    public void Breed(ArrayList<Entity> entity_list) {
        entity_list.add(new Fish(this.position.x, this.position.y, this.diet, this.speed));
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

                Amfiprion amfiprion = new Amfiprion(this.position.x, this.position.y, Diet.Herbivore, 1);
                entity_list.add(amfiprion);
                amfiprion.experience = 11;
                entity_list.remove(this);

            }   else {

                Pike pike = new Pike(this.position.x, this.position.y, Diet.Carnivore, 1);
                entity_list.add(pike);
                pike.experience = 11;
                entity_list.remove(this);

            }
        }
    }
}
