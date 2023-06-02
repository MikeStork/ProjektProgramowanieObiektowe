package simulation;

import org.junit.jupiter.api.Test;
import simulation.data.Diet;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the {@link Cat} class.
 */
class CatTest {

    /**
     * Test for the {@link Cat#getNumberOfObjects()} method.
     */
    @Test
    void getNumberOfObjects_shouldReturnCorrectCount() {
        // Arrange
        int initialCount = Cat.getNumberOfObjects();
        Cat cat1 = new Cat(0, 0, Diet.Omnivore, 5, false, 0);
        Cat cat2 = new Cat(1, 1, Diet.Carnivore, 3, false, 0);

        // Act
        int countAfterCreation = Cat.getNumberOfObjects();
        cat1 = null;
        System.gc(); // Explicit garbage collection to remove the reference
        int countAfterGarbageCollection = Cat.getNumberOfObjects();

        // Assert
        assertEquals(initialCount, countAfterCreation - 2); // Two instances created
        assertEquals(initialCount, countAfterGarbageCollection - 1); // One instance garbage collected
    }

    @Test
    void breed_shouldAddNewCatToList() {
        // Arrange
        ArrayList<Entity> entityList = new ArrayList<>();
        Cat cat = new Cat(0, 0, Diet.Omnivore, 5, false, 0);

        // Act
        cat.Breed(entityList);

        // Assert
        assertEquals(1, entityList.size());
        assertTrue(entityList.get(0) instanceof Cat);
    }

    @Test
    void evolveIfPossible_shouldReplaceCatWithCougarOrTiger() {
        // Arrange
        ArrayList<Entity> entityList = new ArrayList<>();
        Cat cat = new Cat(0, 0, Diet.Omnivore, 5, false, 0);
        cat.experience = 11;

        // Act
        cat.EvolveIfPossible(entityList);

        // Assert
        assertEquals(1, entityList.size());
        assertTrue(entityList.get(0) instanceof Cougar || entityList.get(0) instanceof Tiger);
    }

    // Add more tests as needed

}