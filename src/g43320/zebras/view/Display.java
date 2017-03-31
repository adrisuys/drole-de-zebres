package g43320.zebras.view;

import g43320.zebras.model.Animal;
import g43320.zebras.model.Color;
import g43320.zebras.model.Coordinates;
import g43320.zebras.model.ImpalaJones;
import g43320.zebras.model.Pieces;
import g43320.zebras.model.Reserve;
import g43320.zebras.model.Species;
import java.util.Scanner;

/**
 * Handle all the displays for the game.
 * @author s_u_y_s_a
 */
public class Display {
    public static void displayStock (Pieces pieces, Color color) {
        System.out.println("-----STOCK-----");
        System.out.println("GAZELLES     " + pieces.getNbAnimals(color, Species.GAZELLE));
        System.out.println("ZEBRAS       " + pieces.getNbAnimals(color, Species.ZEBRA));
        System.out.println("ELEPHANT     " + pieces.getNbAnimals(color, Species.ELEPHANT));
        System.out.println("LION         " + pieces.getNbAnimals(color, Species.LION));
        System.out.println("CROCODILES   " + pieces.getNbAnimals(color, Species.CROCODILE));
    }
    
    public static void displayReserve (Reserve reserve, ImpalaJones impala) {
        //ligne 0
        String aString = "      1 2 3 4 5 6    " + "\n";
        
        //ligne 1
        String [] impalaUp = new String [] {".",".",".",".",".","."};
        if (impala.isUp()) {
            impalaUp[impala.getPosition()]="I";
        }
        aString = aString + "     ";
        for (String s : impalaUp) {
            aString = aString + " "+s;
        }
        aString = aString + "    " + "\n";
        
        //ligne 2
        aString = aString + "      = = = = = =    " + "\n";
        
        //ligne 3 à 7
        for (int j=0; j<5;j++) {    
            aString = aString + (1+j)+" ";
            if (impala.getPosition()==21-j) {
                aString = aString + "I | ";
            } else {
                aString = aString + ". | ";
            }
            for (int i=0;i<6;i++) {
                if (reserve.getAnimals()[j][i]==null) {
                    aString = aString + "."+" ";
                } else {
                    aString = aString + reserve.getAnimals()[j][i]+" ";
                }
            }
            if (impala.getPosition()==7+j) {
                aString = aString + "| I" + "\n";
            } else {
                aString = aString + "| ." + "\n";
            }
        }
        
        //ligne 8
        aString = aString + "      = = = = = =    " + "\n";
        
        //ligne 9
        String [] impalaDown = new String [] {".",".",".",".",".","."};
        if (impala.isDown()) {
            impalaUp[impala.getPosition()]="I";
        }
        aString = aString + "     ";
        for (String s : impalaDown) {
            aString = aString + " "+s;
        }
        aString = aString + "    " + "\n";
 
        //display
        System.out.println(aString);
    }

    public static int askDistance () {
        Scanner clavier = new Scanner(System.in);
        int distance;
        System.out.println("Give the distance you want Impala Jones to walk, must be a 1, 2 or 3");
        distance = clavier.nextInt();
        return distance;
    }
    
    public static Animal chooseAnimalFromStock () {
        Color color;
        Species species;
        Animal animal;
        Scanner clavier = new  Scanner(System.in);
        System.out.println("Choose a color between 'RED' or 'GREEN'");
        String colorUser = clavier.next();
        while (!colorUser.equals("RED") || !colorUser.equals("GREEN")) {
            System.out.println("Choose a color between 'RED' or 'GREEN'");
            colorUser = clavier.next();
        }
        if (colorUser.equals("RED")) {
            color = Color.RED;
        } else {
            color = Color.GREEN;
        }
        
        System.out.println("Choose a animal between ELEPHANT, LION, ZEBRA, GAZELLE AND CROCODILE");
        String speciesUser = clavier.next();
        while (!speciesUser.equals("ZEBRA") || !speciesUser.equals("GAZELLE") || !speciesUser.equals("ELEPHANT") || !speciesUser.equals("CROCODILE") || !speciesUser.equals("LION")) {
            System.out.println("Choose a animal between ELEPHANT, LION, ZEBRA, GAZELLE AND CROCODILE");
            colorUser = clavier.next();
        }
        switch (colorUser) {
            case "GAZELLE" : species = Species.GAZELLE; break;
            case "ZEBRA" : species = Species.ZEBRA; break;
            case "ELEPHANT" : species = Species.ELEPHANT; break;
            case "LION" : species = Species.LION; break;
            default : species = Species.CROCODILE; break;
        }
        
        animal = new Animal(species,color);
        return animal;
        
    }

    public static Coordinates chooseCoordinates () {
        int row;
        int column;
        Scanner clavier = new  Scanner(System.in);
        Coordinates position;
        System.out.println("Choose a row");
        row = clavier.nextInt();
        while (row<0 || row>4) {
            System.out.println("Choose a row");
        row = clavier.nextInt();
        }
        System.out.println("Choose a column");
        column = clavier.nextInt();
        while (column<0 || column>4) {
            System.out.println("Choose a column");
        column = clavier.nextInt();
        }
        position = new Coordinates (row,column);
        return position;
    }
}
