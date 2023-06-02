package simulation;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the {@link Entity} class.
 */
class EntityTest {

    /**
     * Test for the {@link Entity#hasExperienceField(Object)} method.
     */
    @Test
    void hasExperienceField_shouldReturnTrueForEntityWithExperienceField() {
        // Arrange
        Entity entityWithExperience = new Entity(0, 0, 1);
        Entity entityWithoutExperience = new Entity(0, 0, 1);

        // Act
        boolean hasExperienceField1 = Entity.hasExperienceField(entityWithExperience);
        boolean hasExperienceField2 = Entity.hasExperienceField(entityWithoutExperience);

        // Assert
        assertTrue(hasExperienceField1);
        assertFalse(hasExperienceField2);
    }

    // Add more tests as needed

}