package simulation;

public class Water extends Entity{
    int speed_modifier = -1;
    Water(int x, int y, String name) {
        super(x, y, name);
        this.SPRITE = "W";
        this.color = "00F";
    }

}
