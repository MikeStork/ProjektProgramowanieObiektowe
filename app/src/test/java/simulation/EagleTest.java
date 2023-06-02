package simulation;

import org.junit.jupiter.api.Test;
import simulation.data.Diet;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the {@link Eagle} class.
 */
class EagleTest {

    /**
     * Test for the {@link Eagle#getNumberOfObjects()} method.
     */
    @Test
    void getNumberOfObjects_shouldReturnCorrectCount() {
        // Arrange
        int initialCount = Eagle.getNumberOfObjects();
        Eagle eagle1 = new Eagle(0, 0, Diet.Omnivore, 5);
        Eagle eagle2 = new Eagle(1, 1, Diet.Carnivore, 3);

        // Act
        int countAfterCreation = Eagle.getNumberOfObjects();
        eagle1 = null;
        System.gc(); // Explicit garbage collection to remove the reference
        int countAfterGarbageCollection = Eagle.getNumberOfObjects();

        // Assert
        assertEquals(initialCount, countAfterCreation - 2); // Two instances created
        assertEquals(initialCount, countAfterGarbageCollection - 1); // One instance garbage collected
    }

    @Test
    void breed_shouldAddNewEagleToList() {
        // Arrange
        ArrayList<Entity> entityList = new ArrayList<>();
        Eagle eagle = new Eagle(0, 0, Diet.Carnivore, 5);

        // Act
        eagle.Breed(entityList);

        // Assert
        assertEquals(1, entityList.size());
        assertTrue(entityList.get(0) instanceof Eagle);
    }

    // Add more tests as needed

}