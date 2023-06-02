package simulation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for the {@link Main} class.
 */
class MainTest {

    /**
     * Test for the {@link Main#parseNumbers(String)} method.
     */
    @Test
    void parseNumbers_shouldReturnArrayListOfIntegers() {
        // Arrange
        String input = "12 34 56";

        // Act
        ArrayList<Integer> numbers = Main.parseNumbers(input);

        // Assert
        assertEquals(3, numbers.size());
        assertEquals(12, numbers.get(0));
        assertEquals(34, numbers.get(1));
        assertEquals(56, numbers.get(2));
    }

    // Add more tests as needed

}