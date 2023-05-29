package simulation;

import java.util.ArrayList;

public class Cell extends Organism{

    Cell(int x, int y, Diet diet, int speed) {
        super(x, y, diet, speed);
        this.SPRITE = CONSTANTS.PURPLE+"C"+CONSTANTS.RESET;
    }

    /**
     * Breeds organism of given type and appends it to list of games entities
     * @param entity_list List of games entities
     */
    @Override
    public void Breed(ArrayList<Entity> entity_list) {
        entity_list.add(new Cell(this.position.x, this.position.y, this.diet, this.speed));
    }
}
