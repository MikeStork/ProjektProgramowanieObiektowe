package simulation;

import org.junit.jupiter.api.Test;
import simulation.data.Diet;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the {@link Bird} class.
 */
class BirdTest {

    /**
     * Test for the {@link Bird#getNumberOfObjects()} method.
     */
    @Test
    void getNumberOfObjects_shouldReturnCorrectCount() {
        // Arrange
        int initialCount = Bird.getNumberOfObjects();
        Bird bird1 = new Bird(0, 0, Diet.Omnivore, 5);
        Bird bird2 = new Bird(1, 1, Diet.Carnivore, 3);

        // Act
        int countAfterCreation = Bird.getNumberOfObjects();
        bird1 = null;
        System.gc(); // Explicit garbage collection to remove the reference
        int countAfterGarbageCollection = Bird.getNumberOfObjects();

        // Assert
        assertEquals(initialCount, countAfterCreation - 2); // Two instances created
        assertEquals(initialCount, countAfterGarbageCollection - 1); // One instance garbage collected
    }

    /**
     * Test for the {@link Bird#Breed(ArrayList)} method.
     */
    @Test
    void breed_shouldAddNewBirdToList() {
        // Arrange
        ArrayList<Entity> entityList = new ArrayList<>();
        Bird bird = new Bird(0, 0, Diet.Omnivore, 5);

        // Act
        bird.Breed(entityList);

        // Assert
        assertEquals(1, entityList.size());
        assertTrue(entityList.get(0) instanceof Bird);
    }

    /**
     * Test for the {@link Bird#EvolveIfPossible(ArrayList)} method.
     */
    @Test
    void evolveIfPossible_shouldReplaceBirdWithStorkOrEagle() {
        // Arrange
        ArrayList<Entity> entityList = new ArrayList<>();
        Bird bird = new Bird(0, 0, Diet.Omnivore, 5);
        bird.experience = 11;

        // Act
        bird.EvolveIfPossible(entityList);

        // Assert
        assertEquals(1, entityList.size());
        assertTrue(entityList.get(0) instanceof Stork || entityList.get(0) instanceof Eagle);
    }

    // Add more tests as needed

}