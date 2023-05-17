package simulation;

public class Weed extends Entity{
    Weed(int x, int y, String name) {
        super(x, y,name);
        this.SPRITE = CONSTANTS.GREEN_UNDERLINED+"W"+CONSTANTS.RESET;
        this.experience = 5;
    }
}
