package org.example;

import simulation.bodyparts.Beak;
import simulation.bodyparts.Wings;

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
