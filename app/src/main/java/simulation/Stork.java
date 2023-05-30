package simulation;

import simulation.data.CONSTANTS;
import simulation.data.Diet;
import simulation.interfaces.I_Stork;

import java.util.ArrayList;

public class Stork extends Bird implements I_Stork {
    private static int s_count;
    Stork(int x, int y, Diet diet, int speed) {
        super(x, y, diet, speed);
        this.SPRITE = CONSTANTS.RED_BOLD+"M"+CONSTANTS.RESET;
        s_count++;
        this.size = 3;
        this.level = 3;
    }
    void DeliverABaby(){}
    public static int getNumberOfObjects() {
        return s_count;
    }

    /**
     * Breeds organism of given type and appends it to list of games entities
     * @param entity_list List of games entities
     */
    @Override
    public void Breed(ArrayList<Entity> entity_list) {
        entity_list.add(new Stork(this.position.x, this.position.y, this.diet, this.speed));
    }
}
