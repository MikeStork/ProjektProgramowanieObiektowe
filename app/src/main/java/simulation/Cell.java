package simulation;

import java.util.ArrayList;

public class Cell extends Organism{

    Cell(int x, int y, Diet diet, int speed) {
        super(x, y, diet, speed);
        this.SPRITE = CONSTANTS.PURPLE+"C"+CONSTANTS.RESET;
    }

    @Override
    public void Breed(ArrayList<Entity> entity_list) {
        //For our best cells won't replicate themselves
    }
}
