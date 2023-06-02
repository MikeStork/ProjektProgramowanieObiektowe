package simulation;

import org.junit.jupiter.api.Test;
import simulation.data.Diet;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the {@link Cougar} class.
 */
class CougarTest {

    /**
     * Test for the {@link Cougar#getNumberOfObjects()} method.
     */
    @Test
    void getNumberOfObjects_shouldReturnCorrectCount() {
        // Arrange
        int initialCount = Cougar.getNumberOfObjects();
        Cougar cougar1 = new Cougar(0, 0, Diet.Carnivore, 5, false, 0);
        Cougar cougar2 = new Cougar(1, 1, Diet.Carnivore, 3, false, 0);

        // Act
        int countAfterCreation = Cougar.getNumberOfObjects();
        cougar1 = null;
        System.gc(); // Explicit garbage collection to remove the reference
        int countAfterGarbageCollection = Cougar.getNumberOfObjects();

        // Assert
        assertEquals(initialCount, countAfterCreation - 2); // Two instances created
        assertEquals(initialCount, countAfterGarbageCollection - 1); // One instance garbage collected
    }

    @Test
    void breed_shouldAddNewCougarToList() {
        // Arrange
        ArrayList<Entity> entityList = new ArrayList<>();
        Cougar cougar = new Cougar(0, 0, Diet.Carnivore, 5, false, 0);

        // Act
        cougar.Breed(entityList);

        // Assert
        assertEquals(1, entityList.size());
        assertTrue(entityList.get(0) instanceof Cougar);
    }

    // Add more tests as needed

}