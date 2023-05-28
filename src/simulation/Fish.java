package simulation.simulation;

import simulation.Cell;
import simulation.bodyparts.Fins;

public class Fish extends Cell {
    Fins fins = new Fins();
    Fish(int x, int y, Diet diet, int speed) {
        super(x, y, diet, speed);
    }
}
