package g43320.zebras.view;

import g43320.zebras.model.Animal;
import static g43320.zebras.model.AnimalState.HIDDEN;
import g43320.zebras.model.Color;
import static g43320.zebras.model.Color.GREEN;
import static g43320.zebras.model.Color.RED;
import g43320.zebras.model.Coordinates;
import g43320.zebras.model.ImpalaJones;
import g43320.zebras.model.Model;
import g43320.zebras.model.Pieces;
import g43320.zebras.model.Player;
import g43320.zebras.model.Reserve;
import g43320.zebras.model.Sector;
import g43320.zebras.model.Species;
import java.util.Scanner;

/**
 * Handle all the displays for the game.
 *
 * @author s_u_y_s_a
 */
public class Display {

    /**
     * Display the stock of pieces of the current player.
     *
     * @param pieces the stock of pieces
     * @param color corresponding to the current player
     */
    public static void displayStock(Pieces pieces, Color color) {
        String aString;
        if (color == Color.RED) {
            aString = "\u001B[31m" + "-----STOCK-----" + "\n" + "\u001B[0m";
            aString = aString + "\u001B[31m" + "GAZELLES     " + pieces.getNbAnimals(color, Species.GAZELLE) + "\n" + "\u001B[0m";
            aString = aString + "\u001B[31m" + "ZEBRAS       " + pieces.getNbAnimals(color, Species.ZEBRA) + "\n" + "\u001B[0m";
            aString = aString + "\u001B[31m" + "ELEPHANT     " + pieces.getNbAnimals(color, Species.ELEPHANT) + "\n" + "\u001B[0m";
            aString = aString + "\u001B[31m" + "LION         " + pieces.getNbAnimals(color, Species.LION) + "\n" + "\u001B[0m";
            aString = aString + "\u001B[31m" + "CROCODILES   " + pieces.getNbAnimals(color, Species.CROCODILE) + "\u001B[0m";
        } else {
            aString = "\u001B[32m" + "-----STOCK-----" + "\n" + "\u001B[0m";
            aString = aString + "\u001B[32m" + "GAZELLES     " + pieces.getNbAnimals(color, Species.GAZELLE) + "\n" + "\u001B[0m";
            aString = aString + "\u001B[32m" + "ZEBRAS       " + pieces.getNbAnimals(color, Species.ZEBRA) + "\n" + "\u001B[0m";
            aString = aString + "\u001B[32m" + "ELEPHANT     " + pieces.getNbAnimals(color, Species.ELEPHANT) + "\n" + "\u001B[0m";
            aString = aString + "\u001B[32m" + "LION         " + pieces.getNbAnimals(color, Species.LION) + "\n" + "\u001B[0m";
            aString = aString + "\u001B[32m" + "CROCODILES   " + pieces.getNbAnimals(color, Species.CROCODILE) + "\u001B[0m";
        }
        System.out.println("__________________________________________");
        System.out.println(aString);
        System.out.println("__________________________________________");

    }

    /**
     * Display the first 3 rows of the board : - the # of the columns; -
     * Impala's path; - and a separator between Impala's path and the reserve).
     *
     * @param impala Impala Jones
     * @return a string that represent the first 3 lines of the board
     */
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

    /**
     * Display the reserve (a "." when the there is no animal, the first capital
     * letter of the animal when it is put) and Impala's path (left or right
     * from the reserve).
     *
     * @param reserve the reserve where the animal are to be puts
     * @param impala Impala Jones
     * @return a string representing the reserve and Impala's path (left or
     * right from the reserve).
     */
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
            String string2;
            for (int k=0; k<reserve.getAnimals()[j].length; k++) {
                if (reserve.getAnimals()[j][k] == null) {
                    string2 = ".";
                } else {
                    String animalName = displayAnimal(reserve.getAnimals()[j][k]);
                    string2 = animalName;
                }
                string2 = coloringBoard(reserve,j,k,string2);
                aString = aString + string2 + " ";
            }
            if (impala.getPosition() == 6 + j) {
                aString = aString + "| I" + "\n";
            } else {
                aString = aString + "| ." + "\n";
            }
        }

        return aString;
    }
    
    /**
     * Display the first letter of the name of the animal (G for gazelle, for example).
     * @param animal the given animal
     * @return the first letter of the name (if the animal belongs to the red player, the color of the text is red).
     */
    public static String displayAnimal (Animal animal) {
        String animalStr;
        animalStr = animal.getSpecies().name().substring(0, 1);
        if (animal.getState() == HIDDEN) {
            if (animal.getColor()==RED) {
                animalStr = "X";
            } else {
                animalStr = "x";
            }
        }
        if (animal.getColor() == RED) {
            return animalStr;
        } else {
            return animalStr.toLowerCase();
        }
    }

    /**
     * Display the last 3 rows of the board : - and a separator between Impala's path and the reserve) ; -
     * Impala's path; - the # of the columns; - a graph legend. 
     * @param reserve the reserve where the animal are to be put.
     * @param impala Impala Jones.
     * @return a String representing the last 3 lines of the board.
     */
    public static String displayReserveFoot(Reserve reserve, ImpalaJones impala) {
        String aString = displayReserveBody(reserve, impala);
        //ligne 8
        aString = aString + "      = = = = = =    " + "\n";

        //ligne 9
        String[] impalaDown = new String[]{".", ".", ".", ".", ".", "."};
        aString = displayImpalaJonesPathUpandDown(aString, impalaDown, impala.isDown(), impala);
        aString = aString + "Board legend : X for hidden animal, Upper case for Red animals and lower case for Green ones" + "\n";
        return aString;
    }

    /**
     * Display the position of Impala when is either up or down the board ("I" when present, "." when not).
     * @param aString a String representing the lines that lays before Impala's path.
     * @param path an array of String that represent the position of Impala ("." or "I")
     * @param upOrDown a boolean indicating if Impala is up or down
     * @param impala Impala Jones
     * @return a String representing the path of Impala
     */
    public static String displayImpalaJonesPathUpandDown(String aString, String[] path, boolean upOrDown, ImpalaJones impala) {
        if (upOrDown) {
            path[impala.getColumn()] = "I";
        }
        aString = aString + "      ";
        for (String s : path) {
            aString = aString+ s + " " ;
        }
        aString = aString + "    " + "\n";
        return aString;
    }

    /**
     * Display the whole board.
     * @param reserve the reserve where the animal are to be put.
     * @param impala Impala Jones.
     */
    public static void displayReserve(Reserve reserve, ImpalaJones impala) {
        System.out.println("__________________________________________");
        System.out.println(displayReserveFoot(reserve, impala));
        System.out.println("__________________________________________");
    }

    /**
     * Ask the user the distance he/she wants Impala Jones to move.
     * @return a number beween 1 and 3 included.
     */
    public static int askDistance() {
        Scanner clavier = new Scanner(System.in);
        int distance;
        System.out.println("Give the distance you want Impala Jones to walk, must be a 1, 2 or 3");
        System.out.print("> ");
        distance = askNumber(clavier);
        while (distance < 1 || distance > 4) {
            System.out.println("The distance you entered is not valid, must be a 1, 2 or 3");
            System.out.print("> ");
            distance = askNumber(clavier);
        }
        return distance;
    }
    
    /**
     * Ask to a user the number of its choice.
     * @param clavier a Scanner that reads input from the player
     * @return the nb entered by the user. By default, it returns 23 (if a wrong character is entered).
     */
    public static int askNumber(Scanner clavier) {
        int nb;
        if (clavier.hasNextInt()) {
            nb = clavier.nextInt();
        } else {
            clavier.next();
            nb = 23;
        }
        return nb;
    }

    /**
     * Ask the user which animal (specie only, the color is his) he/she wants to put on the reserve.
     * @return the specie of the selected animal
     */
    public static Species chooseAnimalFromStock() {
        Species species;
        Scanner clavier = new Scanner(System.in);
        System.out.println("It is time to choose an animal to be placed");
        System.out.println("Choose a animal between ELEPHANT, LION, ZEBRA, GAZELLE and CROCODILE");
        System.out.print("> ");
        species = chooseAnimal(clavier);
        while (species == null) {
            System.out.println("You did not enter a correct name or set of character for the specified animal." + "\n" + "Choose a animal between ELEPHANT, LION, ZEBRA, GAZELLE and CROCODILE");
            System.out.print("> ");
            species = chooseAnimal(clavier);
        }
        return species;
    }
    
    /**
     * Ask a user to enter a specie of Animal.
     * @param clavier a Scanner that reads input from the player
     * @return the species of the animal chosen by the user.
     */
    public static Species chooseAnimal(Scanner clavier) {
        Species species;
        String speciesUser = clavier.next();
            String speciesUserUpperCase = speciesUser.toUpperCase();
            switch (speciesUserUpperCase) {
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
        return species;
    }
    

    /**
     * Ask the user on which case of the board he/she wants to put an animal.
     * @param impala its position force on the coordinates (column or row)
     * @return a Coordinates where the animal are to be put.
     */
    public static Coordinates chooseCoordinates(ImpalaJones impala) {
        int row;
        int column;
        System.out.println("It is time to choose a coordinates for an animal");
        Coordinates position = null;
        boolean invalid = true;
        while (invalid) {
            invalid = false;
            if (impala.isUp()||impala.isDown()) {
                row = chooseRow()-1;
                column = impala.getColumn();
            } else {
                row = impala.getRow();
                column = chooseColumn()-1;
            }
            
            try {
                position = new Coordinates(row, column);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                invalid = true;
            }
        }
        return position;
    }
    
    /**
     * Ask the player on which row he/she wants to put one of his/her animal.
     * @return the row the player wants to put the animal.
     */
    public static int chooseRow () {
        Scanner clavier = new Scanner(System.in);
        int row;
        System.out.println("Choose a row");
        System.out.print("> ");
        row = askNumber(clavier);
        while (row < 1 || row > 5) {
            System.out.println("The row you entered is not valid, please choose a correct row");
            System.out.print("> ");
            row = askNumber(clavier);
        }
        return row;
    }
    
    /**
     * Ask the player on which column he/she wants to put one of his/her animal.
     * @return the column the player wants to put the animal.
     */
    public static int chooseColumn () {
        Scanner clavier = new Scanner(System.in);
        int column;
        System.out.println("Choose a column");
        System.out.print("> ");
        column = askNumber(clavier);
        while (column < 1 || column > 6) {
            System.out.println("The column you entered is not valid, please choose a correct row");
            System.out.print("> ");
            column = askNumber(clavier);
        }
        return column;
    }

    /**
     * Ask the user the position on which Impala Jones must be initialize (at the beginning of the game).
     * @return the position on which Impala Jones must be initialize
     */
    public static int initImpala() {
        Scanner clavier = new Scanner(System.in);
        int position;
        System.out.println("Put Impala Jones to its first position. Give a position between 0 and 21");
        System.out.print("> ");
        position = askNumber(clavier);
        while (position < 0 || position > 21) {
            System.out.println("This is a wrong position for Impala Jones." + "\n" + "Please, put Impala Jones to its first position. Give a position between 0 and 21");
            System.out.print("> ");
            position = askNumber(clavier);
        }
        return position;
    }

    /**
     * Display "it is time for the player X to play".
     * @param currentPlayer the current player.
     */
    public static void displayPlayer(Player currentPlayer) {
        String aString;
        String playerName = displayPlayerName(currentPlayer);
        if (currentPlayer.getColor()==Color.RED) {
            aString = "\u001B[31m"+"It is "+playerName+"'s turn"+"\u001B[0m";
        } else {
            aString = "\u001B[32m"+"It is "+playerName+"'s turn"+"\u001B[0m";
        }
        System.out.println(aString);

    }
    
    /**
     * Display the name of the player.
     * @param player one of the player
     * @return return the name of the player
     */
    public static String displayPlayerName (Player player) {
        String playerName;
        if (player.getColor()==Color.GREEN){
            playerName = "player GREEN";
        } else {
            playerName = "player RED";
        }
        return playerName;
    }

    /**
     * Display a warning when Impala Jones is moved automocally (by the system and not one of the player).
     */
    public static void warningAutomaticMoveImpala () {
        System.out.println("\u001B[35m"+"!!! You have no choice, Impala Jones will automatically reach its best position !!!"+"\u001B[0m");
    }
    
    /**
     * Display a little message at the end of the game.
     */
    public static void endOfGame() {
        System.out.println("The game is over! Congratz to the two of you! May the best wins");
    }
    
    /**
     * Color the background of a String on a case of the board depending on the sector the case belong to.
     * @param reserve the reserve containing the cases
     * @param row the row of the case
     * @param col the column ot the case
     * @param aString a String 
     * @return a colored String.
     */
    public static String coloringBoard (Reserve reserve, int row, int col, String aString) {
        Coordinates pos = new Coordinates (row,col);
        Sector sector = reserve.getSector(pos);
        String newString;
        switch (sector.getNumber()) {
            case 1 : newString = "\u001B[43;1m" + aString + "\u001B[0m"; break;
            case 2 : newString = "\u001B[47;1m" + aString + "\u001B[0m"; break;
            case 3 : newString = "\u001B[46;1m" + aString + "\u001B[0m"; break;
            case 4 : newString = "\u001B[43;1m" + aString + "\u001B[0m"; break;
            case 5 : newString = "\u001B[47;1m" + aString + "\u001B[0m"; break;
            default : newString = "\u001B[46;1m" + aString + "\u001B[0m"; break;
        }
        return newString;
    }
    
    /**
     * Gets the score of each player and displays it.
     * @param game the game of Drôles de Zèbres.
     */
    public static void getScore(Model game) {
        System.out.println("The red player has a grand total of " +game.getScore(RED)+" points.");
        System.out.println("The green player has a grand total of "+game.getScore(GREEN)+" points.");
        if (game.getScore(RED)>game.getScore(GREEN)) {
            System.out.println("Therefore, the red player wins! Congratz!");
        } else if (game.getScore(GREEN)>game.getScore(RED)) {
            System.out.println("Therefore, the green player wins! Congratz!");
        } else {
            System.out.println("It is a tied game! Congratz to the both of you!");
        }
    }
    
    /**
     * Display a message announcing that a player has won the inauguration piece.
     * @param player the winning player.
     */
    public static void displayInaugurationWinner (Player player) {
        System.out.println("\u001B[35m"+displayPlayerName(player) + " has complete, the first, a sector. He earns 5 points"+"\u001B[0m");
    }
    
    /**
     * Ask yes or no to the user
     * @param clavier a Scanner
     * @return YES or NO or null if the user has entered none of the 2 words.
     */
    public static String yesOrNo (Scanner clavier) {
        String confirmUser;
        String confirm;
        confirmUser = clavier.next();
        switch (confirmUser.toUpperCase()) {
            case "YES" : confirm = "YES"; break;
            case "NO" : confirm = "NO"; break;
            default : confirm = null; break;
        }
        return confirm;
    }
    
    /**
     * Ask confirmation to a player before a swap between 2 animals
     * @return Yes or No.
     */
    public static String askConfirmation() {
        String confirmation;
        Scanner clavier = new Scanner(System.in);
        System.out.println("You just put a crocodile beside a gazelle, you may swap them. Do you want to do it? YES or NO");
        System.out.print("> ");
        confirmation = yesOrNo(clavier);
        while (confirmation == null) {
            System.out.println("You did not enter a correct answer between YES or NO.");
            System.out.print("> ");
            confirmation = yesOrNo(clavier);
        }
        return confirmation;
    }
    
    /**
     * Ask the user to confirm the position of the gazelle he wants to swap with a crocodile.
     * @param reserve the reserve on which the animals are put 
     * @param position the position of the crocodile
     * @return the position of the gazelle he wants to swap with the crocodile
     */
    public static Coordinates confirmGazelle(Reserve reserve, Coordinates position) {
        System.out.println("There is(are) "+reserve.countGazelleNearby(position)+" gazelle(s) around the crocodile");
        System.out.println("Please confirm the coordinates of the gazelle you want to swap with your crocodile");
        Coordinates chosenCoord;
        do {
            int row = chooseRow();
            int col = chooseColumn();
            chosenCoord = new Coordinates (row, col);
        } while (reserve.getAnimal(chosenCoord).getSpecies() != Species.GAZELLE);
        return chosenCoord;
    }
    
    public static Coordinates confirmPosition(Reserve reserve) {
        System.out.println("Please confirm the coordinates of the crocodile you just put");
        Coordinates chosenCoord;
        do {
            int row = chooseRow();
            int col = chooseColumn();
            chosenCoord = new Coordinates (row, col);
        } while (reserve.getAnimal(chosenCoord).getSpecies() != Species.CROCODILE);
        return chosenCoord;
    }
    
    /**
     * Ask the user with which version of the game he wants to play.
     * @return 1 if he wants to play with the normal version, 2 with the other.
     */
    public static int chooseGame() {
        Scanner clavier = new Scanner (System.in);
        System.out.println("There is two versions of this game.");
        System.out.println("Press 1 if you want to play with the normal reserve");
        System.out.println("Press 2 if you want to play with the President's reserve");
        int nb;
        nb = askNumber(clavier);
        while (nb<1 || nb>2) {
            System.out.println("You did not enter either 1 or 2! Re-try!");
            nb = askNumber(clavier);
        }
        return nb;
    }
    
    
}
