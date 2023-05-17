package simulation;

public class Weed extends Entity{
    Weed(int x, int y, String name) {
        super(x, y,name);
        this.SPRITE = "T";
        this.color = "0F0";
        this.experience = 5;
    }
}
