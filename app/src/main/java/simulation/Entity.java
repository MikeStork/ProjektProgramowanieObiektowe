package simulation;

import java.lang.reflect.Field;

public class Entity {
    String color = "";
    Position position;
    String SPRITE = "E";
    public int experience;
    public int size;

    Entity(int x, int y, int size){
        this.position = new Position(x,y);
        this.size = size;
    }
    /**
     * @deprecated
     * Checks whether object has declared experience field
     */

    public static boolean hasExperienceField(Object obj) {
        try {
            Field experienceField = obj.getClass().getDeclaredField("experience");
            return experienceField.getType() == int.class;
        } catch (NoSuchFieldException e) {
            return false;
        }
    }

}
