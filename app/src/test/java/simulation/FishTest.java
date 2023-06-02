package simulation;

import org.junit.jupiter.api.Test;
import simulation.data.Diet;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the {@link Fish} class.
 */
class FishTest {

    /**
     * Test for the {@link Fish#CaughtByFisherman(ArrayList)} method.
     */
    @Test
    void caughtByFisherman_shouldRemoveFishFromList() {
        // Arrange
        ArrayList<Entity> entityList = new ArrayList<>();
        Fish fish = new Fish(0, 0, Diet.Herbivore, 1);
        entityList.add(fish);

        // Act
        fish.CaughtByFisherman(entityList);

        // Assert
        assertFalse(entityList.contains(fish));
    }

    /**
     * Test for the {@link Fish#getNumberOfObjects()} method.
     */
    @Test
    void getNumberOfObjects_shouldReturnCorrectCountOfFish() {
        // Arrange
        Fish fish1 = new Fish(0, 0, Diet.Herbivore, 1);
        Fish fish2 = new Fish(0, 0, Diet.Herbivore, 1);

        // Act
        int count = Fish.getNumberOfObjects();

        // Assert
        assertEquals(2, count);
    }

    /**
     * Test for the {@link Fish#Breed(ArrayList)} method.
     */
    @Test
    void breed_shouldAddNewFishToEntityList() {
        // Arrange
        ArrayList<Entity> entityList = new ArrayList<>();
        Fish fish = new Fish(0, 0, Diet.Herbivore, 1);

        // Act
        fish.Breed(entityList);

        // Assert
        assertEquals(1, entityList.size());
        assertTrue(entityList.get(0) instanceof Fish);
    }

    /**
     * Test for the {@link Fish#EvolveIfPossible(ArrayList)} method.
     */
    @Test
    void evolveIfPossible_shouldReplaceFishWithAmfiprionOrPike() {
        // Arrange
        ArrayList<Entity> entityList = new ArrayList<>();
        Fish fish = new Fish(0, 0, Diet.Herbivore, 1);
        fish.experience = 11;

        // Act
        fish.EvolveIfPossible(entityList);

        // Assert
        assertEquals(1, entityList.size());
        assertTrue(entityList.get(0) instanceof Amfiprion || entityList.get(0) instanceof Pike);
    }

    // Add more tests as needed

}