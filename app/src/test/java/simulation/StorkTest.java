package simulation;

import org.junit.jupiter.api.Test;
import simulation.data.Diet;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**

 Test class for the Stork class.
 */
public class StorkTest {

    /**

     Test the constructor of the Stork class.
     */
    @Test
    public void testConstructor() {
        int x = 5;
        int y = 5;
        Diet diet = Diet.Carnivore;
        int speed = 2;

        Stork stork = new Stork(x, y, diet, speed);

        assertEquals(x, stork.position.x);
        assertEquals(y, stork.position.y);
        assertEquals(diet, stork.diet);
        assertEquals(speed, stork.speed);
        assertEquals("M", stork.SPRITE);
        assertEquals(3, stork.size);
        assertEquals(3, stork.level);
    }

    /**

     Test the getNumberOfObjects() method of the Stork class.
     */
    @Test
    public void testGetNumberOfObjects() {
        int initialCount = Stork.getNumberOfObjects();

        Stork stork1 = new Stork(5, 5, Diet.Carnivore, 2);
        assertEquals(initialCount + 1, Stork.getNumberOfObjects());

        Stork stork2 = new Stork(8, 8, Diet.Herbivore, 3);
        assertEquals(initialCount + 2, Stork.getNumberOfObjects());
    }

    /**

     Test the Breed() method of the Stork class.
     */
    @Test
    public void testBreed() {
        ArrayList<Entity> entityList = new ArrayList<>();
        Stork stork = new Stork(5, 5, Diet.Carnivore, 2);

        stork.Breed(entityList);

        assertEquals(1, entityList.size());
        assertTrue(entityList.get(0) instanceof Stork);
        assertEquals(stork.position.x, entityList.get(0).position.x);
        assertEquals(stork.position.x, entityList.get(0).position.y);
        assertEquals(stork.diet, ((Stork) entityList.get(0)).diet);
        assertEquals(stork.speed, ((Stork) entityList.get(0)).speed);
    }
}