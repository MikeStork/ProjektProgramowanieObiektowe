package simulation;

import simulation.Cell;
import simulation.bodyparts.Claws;

public class Cat extends Cell {
    Claws claws = new Claws();
    Cat(int x, int y, String name, Diet diet, int speed) {
        super(x, y, name, diet, speed);
    }

}
