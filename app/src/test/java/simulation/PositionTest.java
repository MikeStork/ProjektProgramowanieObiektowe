package simulation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionTest {
    @Test
    void calculateDistance_shouldReturnCorrectDistance() {
        // Arrange
        Position position = new Position(0, 0);
        int x = 3;
        int y = 4;
        int expectedDistance = 5;

        // Act
        int actualDistance = position.CalculateDistance(x, y);

        // Assert
        assertEquals(expectedDistance, actualDistance);
    }

    // Add more tests as needed
}
