package org.example;

public class Cougar extends Cat {
    int speed_incrementation = 1;

    Cougar(int x, int y, Diet diet, int speed) {
        super(x, y, diet, speed);
        this.SPRITE = CONSTANTS.YELLOW_BOLD+ "G"+CONSTANTS.RESET;
    }
}
