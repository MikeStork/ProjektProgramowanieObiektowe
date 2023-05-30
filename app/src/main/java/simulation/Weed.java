package simulation;

import simulation.data.CONSTANTS;

public class Weed extends Entity{
    Weed(int x, int y) {
        super(x, y, 1);
        this.SPRITE = CONSTANTS.GREEN_UNDERLINED+"W"+CONSTANTS.RESET;
        this.experience = 1;
        this.size = 0;
    }
}
