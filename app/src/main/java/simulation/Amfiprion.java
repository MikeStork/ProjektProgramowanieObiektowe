package simulation;

import java.util.ArrayList;

public class Amfiprion extends Fish {
    private static int a_count;
    Amfiprion(int x, int y, Diet diet, int speed) {
        super(x, y, diet, speed);
        a_count++;
    }
    /**
     * @exception Unimplemented
     */
    public static int getNumberOfObjects() {
        return a_count;
    }
    void DeepDive(){}

    /**
     * Breeds organism of given type and appends it to list of games entities
     * @param entity_list List of games entities
     */
    @Override
    public void Breed(ArrayList<Entity> entity_list) {
        entity_list.add(new Amfiprion(this.position.x, this.position.y, this.diet, this.speed));
    }
}
