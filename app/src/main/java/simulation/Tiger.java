package simulation;

import simulation.data.CONSTANTS;
import simulation.data.Diet;

import java.util.ArrayList;

public class Tiger extends Cat implements I_Tiger {
    static int camouflage_ratio = 2;
    private static int t_count;
    Tiger(int x, int y, Diet diet, int speed, boolean if_asleep, int sleep_count) {
        super(x, y, diet, speed, if_asleep,sleep_count);
        this.SPRITE = CONSTANTS.CYAN+"T"+CONSTANTS.RESET;
        t_count++;
        this.size = 4;
        this.level = 3;
    }
    void LookForPray(){}

    public static int getNumberOfObjects() {
        return t_count;
    }
    /**
     * Breeds organism of given type and appends it to list of games entities
     * @param entity_list List of games entities
     */
    @Override
    public void Breed(ArrayList<Entity> entity_list) {
        entity_list.add(new Tiger(this.position.x, this.position.y, this.diet, this.speed, false, 0));
    }

}
