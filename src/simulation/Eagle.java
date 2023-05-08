package simulation;

import simulation.Bird;

public class Eagle extends Bird {
    Eagle(int x, int y, String name, Diet diet, int speed) {
        super(x, y, name, diet, speed);
    }
    void PerformAnAirStrike(){}
    void LookForPray(){}
}
