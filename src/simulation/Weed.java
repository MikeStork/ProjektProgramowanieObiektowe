package simulation;

public class Weed extends Entity{
    int experience = 5;
    Weed(int x, int y, String name) {
        super(x, y,name);
        this.SPRITE = "T";
        this.color = "0F0";
    }
}
