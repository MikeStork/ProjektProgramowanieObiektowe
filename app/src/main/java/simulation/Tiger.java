package simulation;

import java.util.ArrayList;

public class Tiger extends Cat {

    static int camouflage_ratio = 2;
    Tiger(int x, int y, Diet diet, int speed) {
        super(x, y, diet, speed);
    }
    void LookForPray(){}

    @Override
    void Breed(ArrayList<Entity> entity_list) {

    }
}
