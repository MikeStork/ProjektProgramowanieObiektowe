package simulation;

import java.util.ArrayList;

public class Pike extends Fish implements I_Pike {
    private static int p_count;
    Pike(int x, int y, Diet diet, int speed) {
        super(x, y, diet, speed);
        this.SPRITE = CONSTANTS.GREEN_BOLD+"S"+CONSTANTS.RESET;
        p_count++;
        this.size = 2;
        this.level = 3;
    } public static int getNumberOfObjects() {
        return p_count;
    }

    /**
     * Breeds organism of given type and appends it to list of games entities
     * @param entity_list List of games entities
     */
    @Override
    public void Breed(ArrayList<Entity> entity_list) {
        entity_list.add(new Pike(this.position.x, this.position.y, this.diet, this.speed));
    }
}
