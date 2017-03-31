package g43320.zebras.view;

import g43320.zebras.model.Animal;
import g43320.zebras.model.Color;
import g43320.zebras.model.Coordinates;
import g43320.zebras.model.ImpalaJones;
import g43320.zebras.model.Pieces;
import g43320.zebras.model.Player;
import g43320.zebras.model.Reserve;
import g43320.zebras.model.Species;
import java.util.Scanner;

/**
 * Handle all the displays for the game.
 *
 * @author s_u_y_s_a
 */
public class Display {

    public static void displayStock(Pieces pieces, Color color) {
        System.out.println("-----STOCK-----");
        System.out.println("GAZELLES     " + pieces.getNbAnimals(color, Species.GAZELLE));
        System.out.println("ZEBRAS       " + pieces.getNbAnimals(color, Species.ZEBRA));
        System.out.println("ELEPHANT     " + pieces.getNbAnimals(color, Species.ELEPHANT));
        System.out.println("LION         " + pieces.getNbAnimals(color, Species.LION));
        System.out.println("CROCODILES   " + pieces.getNbAnimals(color, Species.CROCODILE));
    }

    public static String displayReserveHead(ImpalaJones impala) {
        //ligne 0
        String aString = "      1 2 3 4 5 6    " + "\n";

        //ligne 1
        String[] impalaUp = new String[]{".", ".", ".", ".", ".", "."};
        aString = displayImpalaJonesPathUpandDown(aString, impalaUp, impala.isUp(), impala);
        
        //ligne 2
         aString = aString + "      = = = = = =    " + "\n";

        return aString;
    }
    
    public static String displayReserveBody(Reserve reserve, ImpalaJones impala) {
        String aString = displayReserveHead(impala);

        //ligne 3 à 7
        for (int j = 0; j < reserve.getAnimals().length; j++) {
            aString = aString + (1 + j) + " ";
            if (impala.getPosition() == 21 - j) {
                aString = aString + "I | ";
            } else {
                aString = aString + ". | ";
            }
            for (int i = 0; i < reserve.getAnimals()[j].length; i++) {
                if (reserve.getAnimals()[j][i] == null) {
                    aString = aString + "." + " ";
                } else {
                    aString = aString + reserve.getAnimals()[j][i] + " ";
                }
            }
            if (impala.getPosition() == 6 + j) {
                aString = aString + "| I" + "\n";
            } else {
                aString = aString + "| ." + "\n";
            }
        }

        return aString;
    }

    public static String displayReserveFoot(Reserve reserve, ImpalaJones impala) {
        String aString = displayReserveBody(reserve, impala);
        //ligne 8
        aString = aString + "      = = = = = =    " + "\n";

        //ligne 9
        String[] impalaDown = new String[]{".", ".", ".", ".", ".", "."};
        aString = displayImpalaJonesPathUpandDown(aString, impalaDown, impala.isDown(), impala);
        return aString;
    }
    
    public static String displayImpalaJonesPathUpandDown (String aString, String [] path, boolean upOrDown, ImpalaJones impala) {
        if (upOrDown) {
            path[impala.getColumn()] = "I";
        }
        aString = aString + "     ";
        for (String s : path) {
            aString = aString + " " + s;
        }
        aString = aString + "    " + "\n";
        return aString;
    }

    public static void displayReserve(Reserve reserve, ImpalaJones impala) {

        System.out.println(displayReserveFoot(reserve, impala));
    }

    public static int askDistance() {
        Scanner clavier = new Scanner(System.in);
        int distance;
        System.out.println("Give the distance you want Impala Jones to walk, must be a 1, 2 or 3");
        distance = clavier.nextInt();
        while (distance < 1 || distance > 4) {
            System.out.println("The distance you entered is not valid, must be a 1, 2 or 3");
            distance = clavier.nextInt();
        }
        return distance;
    }

    public static Animal chooseAnimalFromStock(Color color) {
        Species species = null;
        Scanner clavier = new Scanner(System.in);

        do {
            System.out.println("Choose a animal between ELEPHANT, LION, ZEBRA, GAZELLE AND CROCODILE");
            String speciesUser = clavier.next();
            switch (speciesUser) {
                case "GAZELLE":
                    species = Species.GAZELLE;
                    break;
                case "ZEBRA":
                    species = Species.ZEBRA;
                    break;
                case "ELEPHANT":
                    species = Species.ELEPHANT;
                    break;
                case "LION":
                    species = Species.LION;
                    break;
                case "CROCODILE":
                    species = Species.CROCODILE;
                    break;
                default:
                    species = null;
            }
        } while (species == null);

        return new Animal(species, color);

    }

    public static Coordinates chooseCoordinates() {
        int row;
        int column;
        Scanner clavier = new Scanner(System.in);
        Coordinates position = null;
        boolean invalid = true;
        while (invalid) {
            invalid = false;
            System.out.println("Choose a row");
            row = clavier.nextInt();
            System.out.println("Choose a column");
            column = clavier.nextInt();
            position = new Coordinates(row, column);
            try {
                position = new Coordinates(row, column);
            } catch (Exception e) {
                invalid = true;
            }
        }
        return position;
    }
}
