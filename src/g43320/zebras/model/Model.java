package g43320.zebras.model;

import java.util.List;

/**
 * Facade of Funny Zebras.
 * @link https://en.wikipedia.org/wiki/Facade_pattern
 * @link https://fr.wikipedia.org/wiki/Fa%C3%A7ade_(patron_de_conception)
 * @author esiProf
 */
public interface Model {

    /**
     * Start a match and reset attributes.
     */
    void start();

    /**
     * Set Impala Jones first position.
     *
     * @param position of Impala Jones at the beginning of game
     * @throws GameException if game's status isn't GameStatus.INIT.
     */
    void setImpalaJonesFirstPosition(int position) throws GameException;

    /**
     * Put an animal in the Board. Put an animal of the given species for the
     * current player.
     *
     * @param position position on the board
     * @param species species of an animal
     * @throws GameException if
     * <ul>
     * <li>game's status isn't Status.ANIMAL</li>
     * <li>or Impala Jones isn't on the the same row or column</li>
     * <li>or that position is not free</li>
     * <li>or the current player doesn't have that a tile of that species to
     * play anymore</li>
     * </ul>
     */
    void putAnimal(Coordinates position, Species species) throws GameException;

    /**
     * Move Impala Jones some steps forward.
     *
     * @param distance number of step
     * @throws GameException if
     * <ul>
     * <li>game's status isn't Status.IMPALA</li>
     * <li>or ImpalaJones will arrive on a full row or column</li>
     * <li>or the distance is too large</li>
     * </ul>
     */
    void moveImpalaJones(int distance) throws GameException;

    /**
     * Return true if the game is over.
     *
     * @return true if the game is over
     */
    boolean isOver();

    /**
     * Return the state of the game.
     *
     * @return the state of the game
     */
    GameStatus getStatus();

    /**
     * Return the current player color.
     *
     * @return the current player color
     */
    Color getCurrentColor();

    /**
     * Return the list of all player.
     *
     * @return the list of all player
     */
    List<Player> getPlayers();

    /**
     * Return the reserve.
     *
     * @return the reserve.
     */
    Reserve getReserve();

    /**
     * Return the amount of animals of the specified species that the curent
     * player can put in the reserve.
     *
     * @param species of the animal searched
     * @return the amount of animals of the specified species for the current
     * player, left in the stock.
     */
    int getNb(Species species);

    /**
     * Return Impala Jones.
     *
     * @return Impala Jones
     */
    ImpalaJones getImpalaJones();

    /**
     * Get the score of the player of the given color.
     *
     * @param color the color of the player
     * @return the score of the player of the given color.
     */
    int getScore(Color color);

    /**
     * Return the stock of Pieces.
     *
     * @return the stock of Pieces.
     */
    Pieces getPieces();

    /**
     * Return the current player
     *
     * @return the current player.
     */
    Player getCurrentPlayer();

    /**
     * After a player is done playing, changes the current player.
     */
    void changePlayer();
    
    /**
     * Check if a player has no other choice to put an animal on a position (which means it is the only free case of the row/column)
     * @param reserve the reserve where the animals are to be put
     * @param impala Impala Jones
     * @return true if the player has no choice to put an animal on a position, false otherwise
     */
    boolean hasNoChoice (Reserve reserve, ImpalaJones impala);
    
    /**
     * Check if there is a lion in the adjacents cases of a given position.
     * @param pos the given position 
     * @return a boolean indicating if there is a lion next to the given position.
     */
    boolean isLionNext (Coordinates pos);
    
    /**
     * Check if an animal can run away from the board when another is put (if a
     * gazelle sits next to a lion, it must flee unless it is the only free
     * position on the row/column).
     *
     * @param animal the animal put on the board
     * @param position the position where the animal is put on the board
     */
    void verifyActionsAnimal (Animal animal, Coordinates position);
    
    void moveImpalaJonesAutomatic () throws GameException;
}
