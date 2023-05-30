package simulation;

import java.util.ArrayList;
import java.util.Random;

public class Cell extends Organism{

    Cell(int x, int y, Diet diet, int speed) {
        super(x, y, diet, speed);
        this.SPRITE = CONSTANTS.PURPLE+"K"+CONSTANTS.RESET;
        this.size = 1;
        this.age = 0;
        this.lifespan = 99999;
        this.experience = 0;
        this.level = 1;
    }

    @Override
    public void Breed(ArrayList<Entity> entity_list) {
        //For our best cells won't replicate themselves
    }

    /**
     * Checks whether organism can or cannot evolve
     * If it can, it will create new organism that matches corresponding evolution state in replacement of one that has been there
     * @param  entity_list List of games entities
     */
    @Override
    public void EvolveIfPossible(ArrayList<Entity> entity_list) {
        if (this.experience > 5) {

            Random random = new Random();

            int r = random.nextInt(3);

            if (r == 1) {
                Cat cat = new Cat(this.position.x, this.position.y, Diet.Carnivore, 1, false, 0);
                cat.experience = 6;
                entity_list.add(cat);
            } else if (r == 2) {
                Bird bird = new Bird(this.position.x, this.position.y, Diet.Carnivore, 1);
                bird.experience = 6;
                entity_list.add(bird);
            } else {
                Fish fish = new Fish(this.position.x, this.position.y, Diet.Carnivore, 1);
                fish.experience = 6;
                entity_list.add(fish);
            }
            entity_list.remove(this);
        }
    }
}
