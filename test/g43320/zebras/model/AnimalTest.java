/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g43320.zebras.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author s_u_y_s_a
 */
public class AnimalTest {
    
    /**
     * Test of action method, of class Animal.
     */
    @Test
    public void testAction1() {
        System.out.println("action");
        Animal other = new Animal(Species.GAZELLE, Color.RED);
        Animal instance = new Animal (Species.LION, Color.GREEN);
        instance.action(other);
        boolean result = other.getState()==AnimalState.RUN;
        boolean expResult = true;
        assertEquals(result, expResult);
    }
    
    /**
     * Test of action method, of class Animal.
     */
    @Test
    public void testAction2() {
        System.out.println("action");
        Animal other = new Animal(Species.ZEBRA, Color.RED);
        Animal instance = new Animal (Species.LION, Color.GREEN);
        instance.action(other);
        boolean result = other.getState()==AnimalState.HIDDEN;
        boolean expResult = true;
        assertEquals(result, expResult);
    }
    
    /**
     * Test of action method, of class Animal.
     */
    @Test
    public void testAction3() {
        System.out.println("action");
        Animal other = new Animal(Species.LION, Color.RED);
        Animal instance = new Animal (Species.ZEBRA, Color.GREEN);
        instance.action(other);
        boolean result = instance.getState()==AnimalState.HIDDEN;
        boolean expResult = true;
        assertEquals(result, expResult);
    }
    
    /**
     * Test of action method, of class Animal.
     */
    @Test
    public void testAction4() {
        System.out.println("action");
        Animal other = new Animal(Species.LION, Color.RED);
        Animal instance = new Animal (Species.ELEPHANT, Color.GREEN);
        instance.action(other);
        boolean result = instance.getState()==AnimalState.HIDDEN;
        boolean expResult = false;
        assertEquals(result, expResult);
    }
    
}
