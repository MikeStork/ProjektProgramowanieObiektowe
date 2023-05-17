package simulation;

import java.lang.reflect.Field;

public class Entity {
    String name;
    String color = "";
    Position position;
    String SPRITE = "E";
    public int experience;

    Entity(int x, int y, String name){
        this.position = new Position(x,y);
        this.name = name;
    }
    public static boolean hasExperienceField(Object obj) {
        try {
            Field experienceField = obj.getClass().getDeclaredField("experience");
            return experienceField.getType() == int.class;
        } catch (NoSuchFieldException e) {
            return false;
        }
    }

}
