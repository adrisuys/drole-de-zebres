package g43320.zebras.model;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author s_u_y_s_a
 */
public class PiecesTest {
    
    /**
     * Test of getAnimal method, of class Pieces.
     */
    @Test
    public void testGetAnimal() {
        System.out.println("getAnimal");
        Color color = Color.GREEN;
        Species species = Species.GAZELLE;
        Pieces instance = new Pieces();
        Animal expResult = new Animal(Species.GAZELLE,Color.GREEN);
        Animal result = instance.getAnimal(color, species);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getAnimal method, of class Pieces.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testGetAnimal2() {
        System.out.println("getAnimal");
        Color color = Color.GREEN;
        Species species = Species.ELEPHANT;
        Pieces instance = new Pieces();
        instance.getAnimals().remove(new Animal(species,color));
        Animal expResult = new Animal(Species.ELEPHANT,Color.GREEN);
        Animal result = instance.getAnimal(color, species);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasAvailable method, of class Pieces.
     */
    @Test
    public void testHasAvailable() {
        System.out.println("hasAvailable");
        Pieces instance = new Pieces();
        boolean expResult = true;
        boolean result = instance.hasAvailable();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of hasAvailable method, of class Pieces.
     */
    @Test
    public void testHasAvailable2() {
        System.out.println("hasAvailable");
        Pieces instance = new Pieces();
        instance.getAnimals().clear();
        boolean expResult = false;
        boolean result = instance.hasAvailable();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getNbAnimals method, of class Pieces.
     */
    @Test
    public void testGetNbAnimals() {
        System.out.println("getNbAnimals");
        Color color = Color.GREEN;
        Species species = Species.CROCODILE;
        Pieces instance = new Pieces();
        int expResult = 2;
        int result = instance.getNbAnimals(color, species);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getNbAnimals method, of class Pieces.
     */
    @Test
    public void testGetNbAnimals2() {
        System.out.println("getNbAnimals");
        Color color = Color.RED;
        Species species = Species.GAZELLE;
        Pieces instance = new Pieces();
        int expResult = 6;
        int result = instance.getNbAnimals(color, species);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getNbAnimals method, of class Pieces.
     */
    @Test
    public void testGetNbAnimals3() {
        System.out.println("getNbAnimals");
        Color color = Color.RED;
        Species species = Species.LION;
        Pieces instance = new Pieces();
        instance.getAnimals().remove(new Animal(species,color));
        int expResult = 0;
        int result = instance.getNbAnimals(color, species);
        assertEquals(expResult, result);
    }
    
}
