package g43320.zebras.view;

import g43320.zebras.model.Animal;
import g43320.zebras.model.Color;
import g43320.zebras.model.ImpalaJones;
import g43320.zebras.model.Pieces;
import g43320.zebras.model.Reserve;
import g43320.zebras.model.Species;

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
}
