package simulation.simulation;

import simulation.simulation.bodyparts.Beak;
import simulation.simulation.bodyparts.Wings;

public class Bird extends Cell {
    Wings wings = new Wings();
    Beak beak = new Beak();
    Bird(int x, int y, Diet diet, int speed) {
        super(x, y, diet, speed);
    }
    /**
     * @exception Unimplemented
     */
    void LayEggs(){}
    /**
     * @exception Unimplemented
     */
    void BuildNest(){}
}
