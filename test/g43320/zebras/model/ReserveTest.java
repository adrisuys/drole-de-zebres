package g43320.zebras.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author s_u_y_s_a
 */
public class ReserveTest {
    
    public ReserveTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isFree method, of class Reserve.
     */
    @Test
    public void testIsFree1() {
        System.out.println("isFree");
        Coordinates pos = new Coordinates(4,4);
        Reserve instance = new Reserve();
        boolean expResult = true;
        boolean result = instance.isFree(pos);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isFree method, of class Reserve.
     */
    @Test
    public void testIsFree2() {
        System.out.println("isFree");
        Coordinates pos = new Coordinates(4,4);
        Reserve instance = new Reserve();
        Animal animal = new Animal (Species.LION, Color.GREEN);
        instance.putAnimal(animal, pos);
        boolean expResult = false;
        boolean result = instance.isFree(pos);
        assertEquals(expResult, result);
    }

    /**
     * Test of putAnimal method, of class Reserve.
     */
    @Test
    public void testPutAnimal1() {
        System.out.println("putAnimal");
        Animal animal = new Animal (Species.ELEPHANT, Color.RED);
        Coordinates pos = new Coordinates(3,1);
        Animal animal2 = new Animal (Species.LION, Color.GREEN);
        Reserve instance = new Reserve();
        instance.putAnimal(animal2, pos);
        instance.putAnimal(animal, pos);
    }
    
    @Test
    public void testPutAnimal2() {
        System.out.println("putAnimal");
        Animal animal = new Animal (Species.ELEPHANT, Color.RED);
        Coordinates pos = new Coordinates(3,1);
        Reserve instance = new Reserve();
        instance.putAnimal(animal, pos);
    }

    /**
     * Test of getAnimal method, of class Reserve.
     */
    @Test
    public void testGetAnimal1() {
        System.out.println("getAnimal");
        Coordinates pos = new Coordinates(0,2);
        Reserve instance = new Reserve();
        Animal expResult = null;
        Animal result = instance.getAnimal(pos);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAnimal method, of class Reserve.
     */
    @Test
    public void testGetAnimal2() {
        System.out.println("getAnimal");
        Coordinates pos = new Coordinates(0,2);
        Reserve instance = new Reserve();
        Animal animal = new Animal(Species.ZEBRA, Color.RED);
        instance.putAnimal(animal, pos);
        Animal expResult = animal;
        Animal result = instance.getAnimal(pos);
        assertEquals(expResult, result);
    }
    
}
