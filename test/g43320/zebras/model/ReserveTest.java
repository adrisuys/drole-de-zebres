package g43320.zebras.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Initialize the JUnit tests for the methods of the class Reserve.
 *
 * @author s_u_y_s_a
 */
public class ReserveTest {

    /**
     * Test of isFree method, of class Reserve.
     */
    @Test
    public void testIsFree1() {
        System.out.println("isFree");
        Coordinates pos = new Coordinates(4, 4);
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
        Coordinates pos = new Coordinates(4, 4);
        Reserve instance = new Reserve();
        Animal animal = new Animal(Species.LION, Color.GREEN);
        instance.putAnimal(animal, pos);
        boolean expResult = false;
        boolean result = instance.isFree(pos);
        assertEquals(expResult, result);
    }

    /**
     * Test of putAnimal method, of class Reserve.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testPutAnimal1() {
        System.out.println("putAnimal");
        Animal animal = new Animal(Species.ELEPHANT, Color.RED);
        Coordinates pos = new Coordinates(3, 1);
        Animal animal2 = new Animal(Species.LION, Color.GREEN);
        Reserve instance = new Reserve();
        instance.putAnimal(animal2, pos);
        instance.putAnimal(animal, pos);
    }

    /**
     * Test of putAnimal method, of class Reserve.
     */
    @Test
    public void testPutAnimal2() {
        System.out.println("putAnimal");
        Animal animal = new Animal(Species.ELEPHANT, Color.RED);
        Coordinates pos = new Coordinates(3, 1);
        Reserve instance = new Reserve();
        instance.putAnimal(animal, pos);
    }

    /**
     * Test of getAnimal method, of class Reserve.
     */
    @Test
    public void testGetAnimal1() {
        System.out.println("getAnimal");
        Coordinates pos = new Coordinates(0, 2);
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
        Coordinates pos = new Coordinates(0, 2);
        Reserve instance = new Reserve();
        Animal animal = new Animal(Species.ZEBRA, Color.RED);
        instance.putAnimal(animal, pos);
        Animal expResult = animal;
        Animal result = instance.getAnimal(pos);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getAdjacents method, of class Reserve.
     */
    @Test
    public void testGetAdjacents1() {
        System.out.println("getAdjacents");
        Coordinates position = new Coordinates (0,0);
        Reserve instance = new Reserve();
        List <Coordinates> expResult = new ArrayList<>();
        expResult.add(new Coordinates(0,1));
        expResult.add(new Coordinates(1,0));
        List <Coordinates> result = instance.getAdjacents(position);
        assertTrue(expResult.containsAll(result) && result.containsAll(expResult));
    }
    
    /**
     * Test of getAdjacents method, of class Reserve.
     */
    @Test
    public void testGetAdjacents2() {
        System.out.println("getAdjacents");
        Coordinates position = new Coordinates (0,3);
        Reserve instance = new Reserve();
        List <Coordinates> expResult = new ArrayList<>();
        expResult.add(new Coordinates(0,2));
        expResult.add(new Coordinates(1,3));
        expResult.add(new Coordinates(0,4));
        List <Coordinates> result = instance.getAdjacents(position);
        assertTrue(expResult.containsAll(result) && result.containsAll(expResult));
    }
    
    /**
     * Test of getAdjacents method, of class Reserve.
     */
    @Test
    public void testGetAdjacents3() {
        System.out.println("getAdjacents");
        Coordinates position = new Coordinates (0,5);
        Reserve instance = new Reserve();
        List <Coordinates> expResult = new ArrayList<>();
        expResult.add(new Coordinates(0,4));
        expResult.add(new Coordinates(1,5));
        List <Coordinates> result = instance.getAdjacents(position);
        assertTrue(expResult.containsAll(result) && result.containsAll(expResult));
    }
    
    /**
     * Test of getAdjacents method, of class Reserve.
     */
    @Test
    public void testGetAdjacents4() {
        System.out.println("getAdjacents");
        Coordinates position = new Coordinates (2,1);
        Reserve instance = new Reserve();
        List <Coordinates> expResult = new ArrayList<>();
        expResult.add(new Coordinates(1,1));
        expResult.add(new Coordinates(2,0));
        expResult.add(new Coordinates(2,2));
        expResult.add(new Coordinates(3,1));
        List <Coordinates> result = instance.getAdjacents(position);
        assertTrue(expResult.containsAll(result) && result.containsAll(expResult));
    }
    
    /**
     * Test of getAdjacents method, of class Reserve.
     */
    @Test
    public void testGetAdjacents5() {
        System.out.println("getAdjacents");
        Coordinates position = new Coordinates (2,3);
        Reserve instance = new Reserve();
        List <Coordinates> expResult = new ArrayList<>();
        expResult.add(new Coordinates(2,2));
        expResult.add(new Coordinates(2,4));
        expResult.add(new Coordinates(1,3));
        expResult.add(new Coordinates(3,3));
        List <Coordinates> result = instance.getAdjacents(position);
        assertTrue(expResult.containsAll(result) && result.containsAll(expResult));
    }
    
    /**
     * Test of getAdjacents method, of class Reserve.
     */
    @Test
    public void testGetAdjacents6() {
        System.out.println("getAdjacents");
        Coordinates position = new Coordinates (2,5);
        Reserve instance = new Reserve();
        List <Coordinates> expResult = new ArrayList<>();
        expResult.add(new Coordinates(1,5));
        expResult.add(new Coordinates(2,4));
        expResult.add(new Coordinates(3,5));
        List <Coordinates> result = instance.getAdjacents(position);
        assertTrue(expResult.containsAll(result) && result.containsAll(expResult));
    }
    
    /**
     * Test of getAdjacents method, of class Reserve.
     */
    @Test
    public void testGetAdjacents7() {
        System.out.println("getAdjacents");
        Coordinates position = new Coordinates (4,0);
        Reserve instance = new Reserve();
        List <Coordinates> expResult = new ArrayList<>();
        expResult.add(new Coordinates(3,0));
        expResult.add(new Coordinates(4,1));
        List <Coordinates> result = instance.getAdjacents(position);
        assertTrue(expResult.containsAll(result) && result.containsAll(expResult));
    }
    
    /**
     * Test of getAdjacents method, of class Reserve.
     */
    @Test
    public void testGetAdjacents8() {
        System.out.println("getAdjacents");
        Coordinates position = new Coordinates (4,2);
        Reserve instance = new Reserve();
        List <Coordinates> expResult = new ArrayList<>();
        expResult.add(new Coordinates(4,1));
        expResult.add(new Coordinates(3,2));
        expResult.add(new Coordinates(4,3));
        List <Coordinates> result = instance.getAdjacents(position);
        assertTrue(expResult.containsAll(result) && result.containsAll(expResult));
    }
    
    /**
     * Test of getAdjacents method, of class Reserve.
     */
    @Test
    public void testGetAdjacents9() {
        System.out.println("getAdjacents");
        Coordinates position = new Coordinates (4,5);
        Reserve instance = new Reserve();
        List <Coordinates> expResult = new ArrayList<>();
        expResult.add(new Coordinates(3,5));
        expResult.add(new Coordinates(4,4));
        List <Coordinates> result = instance.getAdjacents(position);
        assertTrue(expResult.containsAll(result) && result.containsAll(expResult));
    }

}
