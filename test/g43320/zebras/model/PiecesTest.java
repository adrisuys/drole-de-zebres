package g43320.zebras.model;

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
    public void testHasAvailable_0args() {
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
    public void testHasAvailable2_0args() {
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

    /**
     * Test of putBackAnimal method, of class Pieces.
     */
    @Test
    public void testPutBackAnimal() {
        System.out.println("putBackAnimal");
        Animal animal = new Animal(Species.CROCODILE, Color.GREEN);
        Pieces instance = new Pieces();
        instance.getAnimal(Color.GREEN, Species.CROCODILE);
        instance.putBackAnimal(animal);
        int nbCrocodileGreenExpected = 2;
        int nbCrocodileGreen = instance.getNbAnimals(Color.GREEN, Species.CROCODILE);
        assertEquals(nbCrocodileGreenExpected,nbCrocodileGreen);
    }

    /**
     * Test of hasAvailable method, of class Pieces.
     */
    @Test
    public void testHasAvailable1_Color() {
        System.out.println("hasAvailable");
        Color color = Color.RED;
        Pieces instance = new Pieces();
        instance.getAnimals().clear();
        instance.getAnimals().add(new Animal(Species.CROCODILE, Color.GREEN));
        boolean expResult = false;
        boolean result = instance.hasAvailable(color);
        assertEquals(expResult, result);  
    }
    
    /**
     * Test of hasAvailable method, of class Pieces.
     */
    @Test
    public void testHasAvailable2_Color() {
        System.out.println("hasAvailable");
        Color color = Color.RED;
        Pieces instance = new Pieces();
        boolean expResult = true;
        boolean result = instance.hasAvailable(color);
        assertEquals(expResult, result);
    }
    
}
