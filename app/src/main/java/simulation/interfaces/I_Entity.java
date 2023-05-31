package simulation.interfaces;
/**
 * Interface of Entity class
 */
public interface I_Entity {

    /**
     * @deprecated
     * Checks whether object has declared experience field
     * @param obj object to be checked
     * @return Boolean describing whether obj has experience field
     */
    @Deprecated
    static boolean hasExperienceField(Object obj) {
        return false;
    }


}
