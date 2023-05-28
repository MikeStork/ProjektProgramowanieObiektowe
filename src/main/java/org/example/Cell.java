package org.example;

public class Cell extends Organism{

    Cell(int x, int y, Diet diet, int speed) {
        super(x, y, diet, speed);
        this.SPRITE = CONSTANTS.PURPLE+"C"+CONSTANTS.RESET;
    }
}
