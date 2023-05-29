package simulation.simulation;

public class Weed extends Entity{
    Weed(int x, int y) {
        super(x, y, 1);
        this.SPRITE = CONSTANTS.GREEN_UNDERLINED+"W"+CONSTANTS.RESET;
        this.experience = 5;
    }
}
