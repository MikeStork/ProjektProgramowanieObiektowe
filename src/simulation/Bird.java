package simulation;

import simulation.bodyparts.Beak;
import simulation.bodyparts.Wings;

public class Bird extends Cell {
    Wings wings = new Wings();
    Beak beak = new Beak();
    Bird(int x, int y, String name, Diet diet, int speed) {
        super(x, y, name, diet, speed);
    }
    void LayEggs(){}
    void BuildNest(){}
}
