package g43320.zebras;

import g43320.zebras.model.Animal;
import g43320.zebras.model.Color;
import g43320.zebras.model.Coordinates;
import g43320.zebras.model.Reserve;
import g43320.zebras.model.Species;

/**
 * Zebras is the main Class controlling the whole game.
 *
 * @author s_u_y_s_a
 */
public class Zebras {

    /**
     * Initialize a reserve, put a red gazelle on the position (2,4) and print
     * the result.
     *
     * @param args
     */
    public static void main(String[] args) {
        Reserve reserve = new Reserve();
        Coordinates pos = new Coordinates(2, 4);
        Animal animal = new Animal(Species.GAZELLE, Color.RED);
        reserve.putAnimal(animal, pos);
        System.out.println(reserve.toString());
    }

}
