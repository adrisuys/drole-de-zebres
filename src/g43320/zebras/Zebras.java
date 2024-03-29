package g43320.zebras;

import g43320.zebras.model.Coordinates;
import g43320.zebras.model.Game;
import g43320.zebras.model.GameException;
import g43320.zebras.model.GameStatus;
import g43320.zebras.model.Model;
import g43320.zebras.view.Display;

/**
 * Zebras is the main Class controlling the whole game.
 *
 * @author s_u_y_s_a
 */
public class Zebras {

    /**
     * Interface of the game Drôles de Zèbres.
     *
     * @param args the arguments of the method.
     */
    public static void main(String[] args) {
        Model game = new Game();
        play(game);

    }

    /**
     * Simulate a game of Drôles de Zèbres.
     *
     * @param game the game of Drôles de Zèbres
     */
    public static void play(Model game) {
        initImpala(game);
        while (!game.isOver()) {
            Display.displayStock(game.getPieces(), game.getCurrentColor());
            Display.displayReserve(game.getReserve(), game.getImpalaJones());
            Display.displayPlayer(game.getCurrentPlayer());
            putAnimal(game);
            checkingInauguration(game);
            Display.displayReserve(game.getReserve(), game.getImpalaJones());
            if (!game.isOver()) {
                moveImpalaJones(game);
            }
        }
        Display.endOfGame();
        Display.getScore(game);
    }

    /**
     * Initialize the position of Impala Jones.
     *
     * @param game the game of Drôles de Zèbres
     */
    public static void initImpala(Model game) {
        boolean invalid = true;
        while (invalid) {
            invalid = false;
            try {
                Display.displayPlayer(game.getCurrentPlayer());
                game.setImpalaJonesFirstPosition(Display.initImpala());
            } catch (GameException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
                invalid = true;
            }
        }
    }

    /**
     * Put an animal on the board.
     *
     * @param game the game of Drôles de Zèbres
     */
    public static void putAnimal(Model game) {
        boolean invalid = true;
        while (invalid) {
            invalid = false;
            try {
                //Coordinates coord = Display.chooseCoordinates(game.getImpalaJones());
                game.putAnimal(Display.chooseCoordinates(game.getImpalaJones()), Display.chooseAnimalFromStock());
                //if (game.getStatus() == GameStatus.CROCODILE) {
                //    if (Display.askConfirmation().equals("YES")) {
                //        Coordinates posCroco = coord;
                //        Coordinates posGazelle = Display.confirmGazell(game.getReserve(), coord);
                //        game.swap(posCroco, posGazelle);
                //    }
                //}
                //game.setStatus(GameStatus.IMPALA);
            } catch (GameException ex) {
                System.out.println(ex.getMessage());
                invalid = true;
            }
        }
    }

    /**
     * Move Impala Jones on his path.
     *
     * @param game the game of Drôles de Zèbres
     */
    public static void moveImpalaJones(Model game) {
        boolean invalid = true;
        while (invalid) {
            invalid = false;
            try {
                if (game.getImpalaJones().findFirst(game.getReserve()) >= 1 && game.getImpalaJones().findFirst(game.getReserve()) <= 3) {
                    game.moveImpalaJones(Display.askDistance());
                } else {
                    Display.warningAutomaticMoveImpala();
                    game.moveImpalaJonesAutomatic();
                }
            } catch (GameException ex) {
                System.out.println(ex.getMessage());
                invalid = true;
            }
        }
    }

    /**
     * Check if the inauguration piece has been given to one of the player.
     * @param game the game of Drôles de Zèbres
     */
    public static void checkingInauguration(Model game) {
        if (game.getInaugurationWinner() == null) {
            game.checkInauguration();
            if (game.getInaugurationWinner() != null) {
                Display.displayInaugurationWinner(game.getCurrentPlayer());
            }
        }
    }

}
