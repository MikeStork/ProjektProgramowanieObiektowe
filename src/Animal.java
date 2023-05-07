public class Animal extends Entity{
    Diet diet;
    int speed;
    Animal(int x, int y, Diet diet, int speed) {
        super(x, y);
        this.diet = diet;
        this.speed = speed;
        this.SPRITE = "A";
    }
}
