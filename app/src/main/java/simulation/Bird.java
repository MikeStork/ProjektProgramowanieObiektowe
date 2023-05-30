package simulation;

import simulation.data.CONSTANTS;
import simulation.data.Diet;
import simulation.interfaces.I_Bird;

import java.util.ArrayList;
import java.util.Random;

public class Bird extends Cell implements I_Bird {

    private static int b_count;
    Bird(int x, int y, Diet diet, int speed) {
        super(x, y, diet, speed);
        this.SPRITE = CONSTANTS.RED+"B"+CONSTANTS.RESET;
        b_count++;
        this.SPRITE = CONSTANTS.BLUE_UNDERLINED+"B"+CONSTANTS.RESET;
        this.size = 2;
        this.lifespan = 400;
        this.level = 2;
    }

    /**
     * Enables Bird object to make 4 fast moves
     * @param width width of the map
     * @param height height of the map
     * @param org Organism object able to make a move
     */
    public void FlyFast(int width, int height) {
        int count = 0;

        while(count < 3)    {
            this.Move(width, height);
            ++count;
        }
    }
    public static int getNumberOfObjects() {
        return b_count;
    }

    /**
     * Breeds organism of given type and appends it to list of games entities
     * @param entity_list List of games entities
     */
    @Override
    public void Breed(ArrayList<Entity> entity_list) {
        entity_list.add(new Bird(this.position.x, this.position.y, this.diet, this.speed));
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

                Stork stork = new Stork(this.position.x, this.position.y, Diet.Carnivore, 1);
                stork.experience = 11;
                entity_list.add(stork);

            }   else {

                Eagle eagle = new Eagle(this.position.x, this.position.y, Diet.Carnivore, 1);
                eagle.experience = 11;
                entity_list.add(eagle);

            }
            entity_list.remove(this);
        }
    }
}
