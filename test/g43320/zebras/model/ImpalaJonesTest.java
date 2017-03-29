package g43320.zebras.model;

;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author s_u_y_s_a
 */
public class ImpalaJonesTest {
    
    public ImpalaJonesTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
    /**
     * Test of move method, of class ImpalaJones.
     */
    @Test
    public void testMove1() {
        System.out.println("move");
        int distance = 3;
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        instance.move(distance);
        int pos = instance.getPosition();
        assertEquals(3,pos);
    }
    
    /**
     * Test of move method, of class ImpalaJones.
     */
    @Test
    public void testMove2() {
        System.out.println("move");
        int distance = 20;
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        instance.move(distance);
        instance.move(4);
        int pos = instance.getPosition();
        assertEquals(2,pos);
    }

    /**
     * Test of isUp method, of class ImpalaJones.
     */
    @Test
    public void testIsUp1() {
        System.out.println("isUp");
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        instance.move(2);
        boolean expResult = true;
        boolean result = instance.isUp();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isUp method, of class ImpalaJones.
     */
    @Test
    public void testIsUp2() {
        System.out.println("isUp");
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        instance.move(8);
        boolean expResult = false;
        boolean result = instance.isUp();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isUp method, of class ImpalaJones.
     */
    @Test
    public void testIsUp3() {
        System.out.println("isUp");
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        instance.move(13);
        boolean expResult = false;
        boolean result = instance.isUp();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isUp method, of class ImpalaJones.
     */
    @Test
    public void testIsUp4() {
        System.out.println("isUp");
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        instance.move(19);
        boolean expResult = false;
        boolean result = instance.isUp();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isDown method, of class ImpalaJones.
     */
    @Test
    public void testIsDown1() {
        System.out.println("isDown");
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        instance.move(2);
        boolean expResult = false;
        boolean result = instance.isDown();
        assertEquals(expResult, result);
    }
    
     /**
     * Test of isDown method, of class ImpalaJones.
     */
    @Test
    public void testIsDown2() {
        System.out.println("isDown");
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        instance.move(8);
        boolean expResult = false;
        boolean result = instance.isDown();
        assertEquals(expResult, result);
    }
    
     /**
     * Test of isDown method, of class ImpalaJones.
     */
    @Test
    public void testIsDown3() {
        System.out.println("isDown");
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        instance.move(13);
        boolean expResult = true;
        boolean result = instance.isDown();
        assertEquals(expResult, result);
    }
    
     /**
     * Test of isDown method, of class ImpalaJones.
     */
    @Test
    public void testIsDown4() {
        System.out.println("isDown");
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        instance.move(19);
        boolean expResult = false;
        boolean result = instance.isDown();
        assertEquals(expResult, result);
    }

    /**
     * Test of isLeft method, of class ImpalaJones.
     */
    @Test
    public void testIsLeft1() {
        System.out.println("isLeft");
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        instance.move(2);
        boolean expResult = false;
        boolean result = instance.isLeft();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isLeft method, of class ImpalaJones.
     */
    @Test
    public void testIsLeft2() {
        System.out.println("isLeft");
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        instance.move(8);
        boolean expResult = false;
        boolean result = instance.isLeft();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isLeft method, of class ImpalaJones.
     */
    @Test
    public void testIsLeft3() {
        System.out.println("isLeft");
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        instance.move(13);
        boolean expResult = false;
        boolean result = instance.isLeft();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isLeft method, of class ImpalaJones.
     */
    @Test
    public void testIsLeft4() {
        System.out.println("isLeft");
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        instance.move(19);
        boolean expResult = true;
        boolean result = instance.isLeft();
        assertEquals(expResult, result);
    }

    /**
     * Test of isRight method, of class ImpalaJones.
     */
    @Test
    public void testIsRight1() {
        System.out.println("isRight");
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        instance.move(2);
        boolean expResult = false;
        boolean result = instance.isRight();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isRight method, of class ImpalaJones.
     */
    @Test
    public void testIsRight2() {
        System.out.println("isRight");
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        instance.move(8);
        boolean expResult = true;
        boolean result = instance.isRight();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isRight method, of class ImpalaJones.
     */
    @Test
    public void testIsRight3() {
        System.out.println("isRight");
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        instance.move(13);
        boolean expResult = false;
        boolean result = instance.isRight();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isRight method, of class ImpalaJones.
     */
    @Test
    public void testIsRight4() {
        System.out.println("isRight");
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        instance.move(19);
        boolean expResult = false;
        boolean result = instance.isRight();
        assertEquals(expResult, result);
    }

    /**
     * Test of getColumn method, of class ImpalaJones.
     */
    @Test
    public void testGetColumn1() {
        System.out.println("getColumn");
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        instance.move(2);
        int expResult = 2;
        int result = instance.getColumn();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getColumn method, of class ImpalaJones.
     */
    @Test
    public void testGetColumn2() {
        System.out.println("getColumn");
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        instance.move(8);
        int expResult = -1;
        int result = instance.getColumn();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getColumn method, of class ImpalaJones.
     */
    @Test
    public void testGetColumn3() {
        System.out.println("getColumn");
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        instance.move(13);
        int expResult = 3;
        int result = instance.getColumn();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getColumn method, of class ImpalaJones.
     */
    @Test
    public void testGetColumn4() {
        System.out.println("getColumn");
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        instance.move(19);
        int expResult = -1;
        int result = instance.getColumn();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRow method, of class ImpalaJones.
     */
    @Test
    public void testGetRow1() {
        System.out.println("getRow");
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        instance.move(2);
        int expResult = -1;
        int result = instance.getRow();
        assertEquals(expResult, result);
    }
    
     /**
     * Test of getRow method, of class ImpalaJones.
     */
    @Test
    public void testGetRow2() {
        System.out.println("getRow");
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        instance.move(8);
        int expResult = 2;
        int result = instance.getRow();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getRow method, of class ImpalaJones.
     */
    @Test
    public void testGetRow3() {
        System.out.println("getRow");
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        instance.move(13);
        int expResult = -1;
        int result = instance.getRow();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getRow method, of class ImpalaJones.
     */
    @Test
    public void testGetRow4() {
        System.out.println("getRow");
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        instance.move(19);
        int expResult = 2;
        int result = instance.getRow();
        assertEquals(expResult, result);
    }

    /**
     * Test of checkMove method, of class ImpalaJones.
     */
    @Test
    public void testCheckMove1() {
        System.out.println("checkMove");
        Reserve reserve = new Reserve();
        reserve.putAnimal(new Animal(Species.LION,Color.RED), new Coordinates(0,0));
        reserve.putAnimal(new Animal(Species.ZEBRA,Color.RED), new Coordinates(1,0));
        reserve.putAnimal(new Animal(Species.ELEPHANT,Color.RED), new Coordinates(2,0));
        reserve.putAnimal(new Animal(Species.ZEBRA,Color.RED), new Coordinates(3,0));
        reserve.putAnimal(new Animal(Species.GAZELLE,Color.RED), new Coordinates(4,0));
        int distance = 16;
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        boolean expResult = false;
        boolean result = instance.checkMove(reserve, distance);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of checkMove method, of class ImpalaJones.
     */
    @Test
    public void testCheckMove2() {
        System.out.println("checkMove");
        Reserve reserve = new Reserve();
        reserve.putAnimal(new Animal(Species.LION,Color.RED), new Coordinates(0,0));
        reserve.putAnimal(new Animal(Species.ZEBRA,Color.RED), new Coordinates(1,0));
        reserve.putAnimal(new Animal(Species.ELEPHANT,Color.RED), new Coordinates(2,0));
        reserve.putAnimal(new Animal(Species.ZEBRA,Color.RED), new Coordinates(3,0));
        reserve.putAnimal(new Animal(Species.GAZELLE,Color.RED), new Coordinates(4,0));
        int distance = 14;
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        boolean expResult = true;
        boolean result = instance.checkMove(reserve, distance);
        assertEquals(expResult, result);
    }

    /**
     * Test of valid method, of class ImpalaJones.
     */
    @Test
    public void testValid1() {
        System.out.println("valid");
        Coordinates pos = new Coordinates (2,1);
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        instance.move(1);
        boolean expResult = true;
        boolean result = instance.valid(pos);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of valid method, of class ImpalaJones.
     */
    @Test
    public void testValid2() {
        System.out.println("valid");
        Coordinates pos = new Coordinates (4,3);
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        instance.move(13);
        boolean expResult = true;
        boolean result = instance.valid(pos);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of valid method, of class ImpalaJones.
     */
    @Test
    public void testValid3() {
        System.out.println("valid");
        Coordinates pos = new Coordinates (4,2);
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        instance.move(19);
        boolean expResult = false;
        boolean result = instance.valid(pos);
        assertEquals(expResult, result);
    }
    
    /**
    * Test of valid method, of class ImpalaJones.
    */
    @Test
    public void testValid4() {
        System.out.println("valid");
        Coordinates pos = new Coordinates (0,0);
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        instance.move(1);
        boolean expResult = false;
        boolean result = instance.valid(pos);
        assertEquals(expResult, result);
    }

    /**
     * Test of findFirst method, of class ImpalaJones.
     */
    @Test
    public void testFindFirst1() {
        System.out.println("findFirst");
        Reserve reserve = new Reserve();
        reserve.putAnimal(new Animal(Species.LION,Color.RED), new Coordinates(0,1));
        reserve.putAnimal(new Animal(Species.ZEBRA,Color.RED), new Coordinates(1,1));
        reserve.putAnimal(new Animal(Species.ELEPHANT,Color.RED), new Coordinates(2,1));
        reserve.putAnimal(new Animal(Species.ZEBRA,Color.RED), new Coordinates(3,1));
        reserve.putAnimal(new Animal(Species.GAZELLE,Color.RED), new Coordinates(4,1));
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        int expResult = 2;
        int result = instance.findFirst(reserve);
        assertEquals(expResult, result);
    }

    /**
     * Test of findFirst method, of class ImpalaJones.
     */
    @Test
    public void testFindFirst2() {
        System.out.println("findFirst");
        Reserve reserve = new Reserve();
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        int expResult = 1;
        int result = instance.findFirst(reserve);
        assertEquals(expResult, result);
    }

    /**
     * Test of init method, of class ImpalaJones.
     */
    @Test
    public void testInit1() {
        System.out.println("init");
        int nb = 0;
        ImpalaJones instance = new ImpalaJones();
        instance.init(nb);
        int pos = instance.getPosition();
        assertEquals(0,pos);
    }
    
    /**
     * Test of init method, of class ImpalaJones.
     */
    @Test
    public void testInit2() {
        System.out.println("init");
        int nb = 5;
        ImpalaJones instance = new ImpalaJones();
        instance.init(nb);
        int pos = instance.getPosition();
        assertEquals(5,pos);
    }
    
    /**
     * Test of init method, of class ImpalaJones.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testInit3() {
        System.out.println("init");
        int nb = 24;
        ImpalaJones instance = new ImpalaJones();
        instance.init(nb);
        int pos = instance.getPosition();
        assertEquals(2,pos);
    }

    
}
