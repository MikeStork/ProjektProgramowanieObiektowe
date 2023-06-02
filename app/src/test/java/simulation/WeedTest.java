package simulation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**

 Test class for the Weed class.
 */
public class WeedTest {

    /**

     Test the constructor of the Weed class.
     */
    @Test
    public void testConstructor() {
        int x = 5;
        int y = 5;

        Weed weed = new Weed(x, y);

        assertEquals(x, weed.position.x);
        assertEquals(y, weed.position.y);
        assertEquals("W", weed.SPRITE);
        assertEquals(1, weed.experience);
        assertEquals(0, weed.size);
    }
}