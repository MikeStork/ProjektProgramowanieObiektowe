package simulation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import simulation.data.Diet;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PikeTest {
    private Pike pike;

    @BeforeEach
    void setUp() {
        // Create a sample Pike for testing
        pike = new Pike(0, 0, Diet.Carnivore, 2);
    }

    @Test
    void getNumberOfObjects_shouldReturnCorrectCount() {
        // Arrange
        int expectedCount = 1;

        // Act
        int actualCount = Pike.getNumberOfObjects();

        // Assert
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void breed_shouldAddNewPikeToEntityList() {
        // Arrange
        ArrayList<Entity> entityList = new ArrayList<>();

        // Act
        pike.Breed(entityList);

        // Assert
        assertEquals(2, entityList.size());
        assertEquals(Pike.class, entityList.get(1).getClass());
    }

    // Add more tests as needed

}
