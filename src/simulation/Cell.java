package simulation;

public class Cell extends Organism{

    Cell(int x, int y, String name, Diet diet, int speed) {
        super(x, y, name, diet, speed);
        this.SPRITE = CONSTANTS.PURPLE+"C"+CONSTANTS.RESET;
    }
}
