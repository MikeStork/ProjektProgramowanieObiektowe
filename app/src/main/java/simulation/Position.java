package simulation;

/**
 * Class of Position
 */
public class Position {
    int x;
    int y;

    /**
     * Constructs a Position object with the specified coordinates.
     *
     * @param x The x-coordinate of the position.
     * @param y The y-coordinate of the position.
     */
    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Calculates the distance between the given position and the current position.
     *
     * @param x The x-coordinate of the position to calculate distance to.
     * @param y The y-coordinate of the position to calculate distance to.
     * @return The floored distance between the positions.
     */
    public int CalculateDistance(int x, int y) {
        return (int) Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }
}
