package g43320.zebras;

import g43320.zebras.model.Animal;
import g43320.zebras.model.Color;
import static g43320.zebras.model.Color.RED;
import g43320.zebras.model.Coordinates;
import g43320.zebras.model.ImpalaJones;
import g43320.zebras.model.Pieces;
import g43320.zebras.model.Reserve;
import g43320.zebras.model.Species;
import static g43320.zebras.model.Species.LION;

/**
 * Zebras is the main Class controlling the whole game.
 *
 * @author s_u_y_s_a
 */
public class Zebras {

    /**
     * Initialize a reserve, create a stock of pieces, take 2 pieces out of it
     * and put them on the reserve.
     *
     * @param args
     */
    public static void main(String[] args) {
        Reserve reserve = new Reserve();
        Pieces stock = new Pieces();
        Coordinates pos = new Coordinates(2, 4);
        Animal animal = stock.getAnimal(Color.GREEN, Species.GAZELLE);
        reserve.putAnimal(animal, pos);
        Coordinates pos2 = new Coordinates(1, 3);
        Animal animal2 = stock.getAnimal(Color.RED, Species.CROCODILE);
        reserve.putAnimal(animal2, pos2);
        //System.out.println(reserve.toString());
        
        reserve.putAnimal(new Animal(Species.ZEBRA,Color.GREEN), new Coordinates(0,2));
        reserve.putAnimal(new Animal(Species.ZEBRA,Color.GREEN), new Coordinates(1,2));
        reserve.putAnimal(new Animal(Species.ZEBRA,Color.GREEN), new Coordinates(2,2));
        reserve.putAnimal(new Animal(Species.ZEBRA,Color.GREEN), new Coordinates(3,2));
        reserve.putAnimal(new Animal(Species.ZEBRA,Color.GREEN), new Coordinates(4,2));
        
        System.out.println(reserve.toString());
        
        System.out.println(reserve.isFullColumn(2));
        
        ImpalaJones ij = new ImpalaJones();
        ij.init(0);
        System.out.println(ij.checkMove(reserve, 2));
        
        
    }

}
