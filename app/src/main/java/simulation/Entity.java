package simulation;

import simulation.interfaces.I_Entity;

import java.lang.reflect.Field;
/**
 * Class of Entity
 */
public class Entity implements I_Entity {
    /**
     * Field describing position of its owner
     */
    Position position;
    /**
     * Field describing sprite of its owner
     */
    String SPRITE = "E";
    /**
     * Field describing experience of its owner
     */
    public int experience;
    /**
     * Field describing size of its owner
     */
    public int size;

    Entity(int x, int y, int size){
        this.position = new Position(x,y);
        this.size = size;
    }
    /**
     * @deprecated
     * Checks whether object has declared experience field
     * @param obj object to be checked
     * @return Boolean describing whether obj has experience field
     */
    @Deprecated
    public static boolean hasExperienceField(Object obj) {
        try {
            Field experienceField = obj.getClass().getDeclaredField("experience");
            return experienceField.getType() == int.class;
        } catch (NoSuchFieldException e) {
            return false;
        }
    }

}
