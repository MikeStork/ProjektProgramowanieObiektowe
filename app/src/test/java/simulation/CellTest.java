package simulation;

import org.junit.jupiter.api.Test;
import simulation.data.Diet;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the {@link Cell} class.
 */
class CellTest {

    /**
     * Test for the {@link Cell#EvolveIfPossible(ArrayList)} method.
     */
    @Test
    void evolveIfPossible_shouldReplaceCellWithCatBirdOrFish() {
        // Arrange
        ArrayList<Entity> entityList = new ArrayList<>();
        Cell cell = new Cell(0, 0, Diet.Omnivore, 5);
        cell.experience = 6;

        // Act
        cell.EvolveIfPossible(entityList);

        // Assert
        assertEquals(1, entityList.size());
        assertTrue(entityList.get(0) instanceof Cat || entityList.get(0) instanceof Bird || entityList.get(0) instanceof Fish);
    }

    // Add more tests as needed

}