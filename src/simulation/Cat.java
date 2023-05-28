package simulation.simulation;

import simulation.simulation.Cell;
import simulation.simulation.bodyparts.Claws;

public class Cat extends Cell {
    Claws claws = new Claws();
    Cat(int x, int y, Diet diet, int speed) {
        super(x, y, diet, speed);
    }

}
