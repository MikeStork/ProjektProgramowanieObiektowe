public class Animal extends Entity{
    Diet diet;
    int speed;
    Animal(int x, int y, String name, Diet diet, int speed) {
        super(x, y, name);
        this.diet = diet;
        this.speed = speed;
        this.SPRITE = "A";
        this.color = "A52";
    }
}
