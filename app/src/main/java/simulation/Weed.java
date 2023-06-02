package simulation;

import simulation.data.CONSTANTS;

/**
 * The Weed class represents a type of entity in the simulation.
 */
public class Weed extends Entity {
    /**
     * Constructs a Weed object with the specified coordinates.
     *
     * @param x the x-coordinate of the weed
     * @param y the y-coordinate of the weed
     */
    public Weed(int x, int y) {
        super(x, y, 1);
        this.SPRITE = CONSTANTS.GREEN_UNDERLINED + "W" + CONSTANTS.RESET;
        this.experience = 1;
        this.size = 0;
    }
}