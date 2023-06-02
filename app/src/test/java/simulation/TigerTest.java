package simulation;

import org.junit.jupiter.api.Test;
import simulation.data.Diet;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for the Tiger class.
 */
public class TigerTest {

    /**
     * Test the constructor of the Tiger class.
     */
    @Test
    public void testConstructor() {
        int x = 5;
        int y = 5;
        Diet diet = Diet.Carnivore;
        int speed = 2;
        boolean ifAsleep = true;
        int sleepCount = 3;

        Tiger tiger = new Tiger(x, y, diet, speed, ifAsleep, sleepCount);

        assertEquals(x, tiger.position.x);
        assertEquals(y, tiger.position.y);
        assertEquals(diet, tiger.diet);
        assertEquals(speed, tiger.speed);
        assertTrue(tiger.if_asleep);
        assertEquals(sleepCount, tiger.sleep_count);
        assertEquals("T", tiger.SPRITE);
        assertEquals(4, tiger.size);
        assertEquals(3, tiger.level);
    }

    /**
     * Test the getNumberOfObjects() method of the Tiger class.
     */
    @Test
    public void testGetNumberOfObjects() {
        int initialCount = Tiger.getNumberOfObjects();

        Tiger tiger1 = new Tiger(5, 5, Diet.Carnivore, 2, false, 0);
        assertEquals(initialCount + 1, Tiger.getNumberOfObjects());

        Tiger tiger2 = new Tiger(8, 8, Diet.Herbivore, 3, true, 2);
        assertEquals(initialCount + 2, Tiger.getNumberOfObjects());
    }

    /**
     * Test the Breed() method of the Tiger class.
     */
    @Test
    public void testBreed() {
        ArrayList<Entity> entityList = new ArrayList<>();
        Tiger tiger = new Tiger(5, 5, Diet.Carnivore, 2, false, 0);

        tiger.Breed(entityList);

        assertEquals(1, entityList.size());
        assertTrue(entityList.get(0) instanceof Tiger);
        assertEquals(tiger.position.x, entityList.get(0).position.x);
        assertEquals(tiger.position.y, entityList.get(0).position.y);
        assertEquals(tiger.diet, ((Tiger) entityList.get(0)).diet);
        assertEquals(tiger.speed, ((Tiger) entityList.get(0)).speed);
        assertEquals(tiger.if_asleep, ((Tiger) entityList.get(0)).if_asleep);
        assertEquals(tiger.sleep_count, ((Tiger) entityList.get(0)).sleep_count);
    }
}
