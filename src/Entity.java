public class Entity {

    String name;
    String color = "";
    Position position;
    String SPRITE = "E";
    Entity(int x, int y, String name){
        this.position = new Position(x,y);
        this.name = name;
    }

}
