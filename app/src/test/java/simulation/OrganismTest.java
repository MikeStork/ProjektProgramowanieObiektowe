package simulation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import simulation.data.Diet;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrganismTest {
    private Organism organism;

    @BeforeEach
    void setUp() {
        // Create a sample organism for testing
        organism = new Organism(0, 0, Diet.Herbivore, 1) {
            @Override
            public void Breed(ArrayList<Entity> entity_list) {
                // Implementation not needed for testing
            }

            @Override
            public void EvolveIfPossible(ArrayList<Entity> entity_list) {
                // Implementation not needed for testing
            }
        };
    }

    @Test
    void move_shouldChangeCoordinatesWithinBounds() {
        // Arrange
        int width = 10;
        int height = 10;

        // Act
        organism.Move(width, height);

        // Assert
        assertTrue(organism.position.x >= 0 && organism.position.x < width);
        assertTrue(organism.position.y >= 0 && organism.position.y < height);
    }

    @Test
    void checkSurroundings_shouldReturnEntityIfWithinDistance() {
        // Arrange
        ArrayList<Entity> entityList = new ArrayList<>();
        Entity entity1 = new Entity(1, 0, 1);
        Entity entity2 = new Entity(2, 0, 1);
        entityList.add(entity1);
        entityList.add(entity2);

        // Act
        Entity result = organism.CheckSurroundings(entityList);

        // Assert
        assertEquals(entity1, result);
    }

    @Test
    void checkSurroundings_shouldReturnNullIfNoEntityWithinDistance() {
        // Arrange
        ArrayList<Entity> entityList = new ArrayList<>();
        Entity entity1 = new Entity(2, 2, 1);
        entityList.add(entity1);

        // Act
        Entity result = organism.CheckSurroundings(entityList);

        // Assert
        assertNull(result);
    }

    // Add more tests as needed

}