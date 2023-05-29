package simulation;

import java.util.ArrayList;

public class Tiger extends Cat {

    static int camouflage_ratio = 2;
    private static int t_count;
    Tiger(int x, int y, Diet diet, int speed, boolean if_asleep, int sleep_count) {
        super(x, y, diet, speed, if_asleep,sleep_count);
        t_count++;
    }
    void LookForPray(){}

    /**
     * Breeds organism of given type and appends it to list of games entities
     * @param entity_list List of games entities
     */
    @Override
    public void Breed(ArrayList<Entity> entity_list) {
        entity_list.add(new Tiger(this.position.x, this.position.y, this.diet, this.speed, false, 0));
    }

}
