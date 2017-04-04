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
        String aString; 
        if (color == Color.RED) {
            aString = "\u001B[31m" + "-----STOCK-----" + "\n" + "\u001B[0m";
            aString = aString + "\u001B[31m" + "GAZELLES     " + pieces.getNbAnimals(color, Species.GAZELLE) + "\n" + "\u001B[0m";
            aString = aString + "\u001B[31m" + "ZEBRAS       " + pieces.getNbAnimals(color, Species.ZEBRA) + "\n"+ "\u001B[0m";
            aString = aString + "\u001B[31m" + "ELEPHANT     " + pieces.getNbAnimals(color, Species.ELEPHANT) + "\n"+ "\u001B[0m";
            aString = aString + "\u001B[31m" + "LION         " + pieces.getNbAnimals(color, Species.LION) + "\n"+ "\u001B[0m";
            aString = aString + "\u001B[31m" + "CROCODILES   " + pieces.getNbAnimals(color, Species.CROCODILE) + "\u001B[0m";
        } else {
            aString = "\u001B[32m" + "-----STOCK-----" + "\n"+ "\u001B[0m";
            aString = aString + "\u001B[32m" +"GAZELLES     " + pieces.getNbAnimals(color, Species.GAZELLE) + "\n"+ "\u001B[0m";
            aString = aString + "\u001B[32m" +"ZEBRAS       " + pieces.getNbAnimals(color, Species.ZEBRA) + "\n"+ "\u001B[0m";
            aString = aString + "\u001B[32m" +"ELEPHANT     " + pieces.getNbAnimals(color, Species.ELEPHANT) + "\n"+ "\u001B[0m";
            aString = aString + "\u001B[32m" +"LION         " + pieces.getNbAnimals(color, Species.LION) + "\n"+ "\u001B[0m";
            aString = aString + "\u001B[32m" +"CROCODILES   " + pieces.getNbAnimals(color, Species.CROCODILE) + "\u001B[0m";
        }
        System.out.println(aString);

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
            for (Animal animal : reserve.getAnimals()[j]) {
                if (animal == null) {
                    aString = aString + "." + " ";
                } else {
                    aString = aString + animal + " ";
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
        aString = aString + "Board legend : X for hidden animal "+"\n";
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

    public static Species chooseAnimalFromStock() {
        Species species = null;
        Scanner clavier = new Scanner(System.in);
        System.out.println("It is time to choose an animal to be placed");
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

        return species;

    }

    public static Coordinates chooseCoordinates() {
        int row;
        int column;
        Scanner clavier = new Scanner(System.in);
        System.out.println("It is time to choose a coordinates for an animal");
        Coordinates position = null;
        boolean invalid = true;
        while (invalid) {
            invalid = false;
            System.out.println("Choose a row");
            row = clavier.nextInt()-1;
            System.out.println("Choose a column");
            column = clavier.nextInt()-1;
            try {
                position = new Coordinates(row, column);
            } catch (Exception e) {
                invalid = true;
            }
        }
        return position;
    }

    public static int initImpala() {
        Scanner clavier = new Scanner(System.in);
        int position;
        do{
            System.out.println("Put Impala Jones to its first position. Give a position between 0 and 21");
            position = clavier.nextInt();
        } while (position < 0 && position > 21);
        
        return position;
    }
    
    public static void displayPlayer (Player currentPlayer) {
        System.out.println("It is time for "+currentPlayer+" to play");
       
    }
}
