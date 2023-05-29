package simulation;

import simulation.bodyparts.Beak;
import simulation.bodyparts.Wings;

public class Bird extends Cell {
    Wings wings = new Wings();
    Beak beak = new Beak();
    private static int b_count;
    Bird(int x, int y, Diet diet, int speed) {
        super(x, y, diet, speed);
        b_count++;
    }
    /**
     * @exception Unimplemented
     */
    void FlyFast(int width, int height, Organism org) {
        int count = 0;

        while(count < 3)    {
            org.Move(width, height);
            ++count;
        }
    }
    /**
     * Enables Bird object to make 4 fast moves
     * @param width width of the map
     * @param height height of the map
     * @param org Organism object able to make a move
     */
    public static int getNumberOfObjects() {
        return b_count;
    }
}
