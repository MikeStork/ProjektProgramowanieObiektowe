package simulation;

import org.junit.jupiter.api.Test;
import simulation.data.Diet;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the {@link Amfiprion} class.
 */
class AmfiprionTest {

    /**
     * Test for the {@link Amfiprion#getNumberOfObjects()} method.
     */
    @Test
    void getNumberOfObjects_shouldReturnCorrectCount() {
        // Arrange
        int initialCount = Amfiprion.getNumberOfObjects();
        Amfiprion amfiprion1 = new Amfiprion(0, 0, Diet.Omnivore, 5);
        Amfiprion amfiprion2 = new Amfiprion(1, 1, Diet.Carnivore, 3);

        // Act
        int countAfterCreation = Amfiprion.getNumberOfObjects();
        amfiprion1 = null;
        System.gc(); // Explicit garbage collection to remove the reference
        int countAfterGarbageCollection = Amfiprion.getNumberOfObjects();

        // Assert
        assertEquals(initialCount, countAfterCreation - 2); // Two instances created
        assertEquals(initialCount, countAfterGarbageCollection - 1); // One instance garbage collected
    }

    // Add more tests as needed

}