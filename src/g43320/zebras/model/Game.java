package g43320.zebras.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This is the main class of the model, it organizes the game itself.
 *
 * @author s_u_y_s_a
 */
public class Game implements Model {

    private final List<Player> players;
    private final Reserve reserve;
    private final ImpalaJones impala;
    private final Pieces pieces;
    private GameStatus status;
    private Player currentPlayer;
    private Player inaugurationWinner;
    final static int MAX_MOVE = 3;
    final static int POINT_INAUGURATION = 5;
    final static int NB_PLAYER = 2;

    /**
     * Creates a new instance of a Game.
     */
    public Game() {
        players = new ArrayList<>();
        Player playerRed = new Player(Color.RED);
        Player playerGreen = new Player(Color.GREEN);
        players.add(playerRed);
        players.add(playerGreen);

        reserve = new Reserve();

        impala = new ImpalaJones();

        pieces = new Pieces();

        status = GameStatus.INIT;

        Random r = new Random();
        int random = r.nextInt(NB_PLAYER);
        currentPlayer = players.get(random);

        inaugurationWinner = null;

    }

//    public Game(Reserve reserve) {
//        this.reserve = reserve;
//        players = new ArrayList<>();
//        Player playerRed = new Player(Color.RED);
//        Player playerGreen = new Player(Color.GREEN);
//        players.add(playerRed);
//        players.add(playerGreen);
//
//
//        impala = new ImpalaJones();
//
//        pieces = new Pieces();
//
//        status = GameStatus.INIT;
//
//        Random r = new Random();
//        int random = r.nextInt(NB_PLAYER);
//        currentPlayer = players.get(random);
//
//        inaugurationWinner = null;
//    }
    
    

    /**
     * Return the stock of Pieces.
     *
     * @return the stock of Pieces.
     */
    @Override
    public Pieces getPieces() {
        return pieces;
    }

    /**
     * Return the current player
     *
     * @return the current player.
     */
    @Override
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Start a match and reset attributes, everything is done by the constructor
     * so it is useless.
     */
    @Override
    public void start() {

    }

    /**
     * Set Impala Jones first position.
     *
     * @param position of Impala Jones at the beginning of game
     * @throws GameException if game's status isn't GameStatus.INIT.
     */
    @Override
    public void setImpalaJonesFirstPosition(int position) throws GameException {
        if (status != GameStatus.INIT) {
            throw new GameException("It is time for the game to be initialize");
        }
        getImpalaJones().init(position);
        changePlayer();
        status = GameStatus.ANIMAL;
    }

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
     * <li>or if a gazelle sits next to a lion</li>
     * </ul>
     */
    @Override
    public void putAnimal(Coordinates position, Species species) throws GameException {
        if (status != GameStatus.ANIMAL) {
            throw new GameException("It is time for the animals to be put on the board");
        }
        if (impala.getRow() != position.getRow() && impala.getColumn() != position.getColumn()) {
            throw new GameException("This is not a coordinate that fits with Impala Jones's position");
        }
        if (!reserve.isFree(position)) {
            throw new GameException("There is already an animal on this position");
        }
        if (getNb(species) == 0) {
            throw new GameException("You don't have that piece anymore");
        }
        Color color = getCurrentPlayer().getColor();
        Animal animal = getPieces().getAnimal(color, species);
        reserve.putAnimal(animal, position);
        List<Coordinates> adjacents = reserve.getAdjacents(position);
        for (Coordinates posAdj : adjacents) {
            if (!reserve.isFree(posAdj)) {
                animal.action(reserve.getAnimal(posAdj));
                if (reserve.getAnimal(posAdj).getState() == AnimalState.RUN) {
                    reserve.getAnimal(posAdj).setState(AnimalState.REST);
                    pieces.putBackAnimal(reserve.getAnimal(posAdj));
                    reserve.removeAnimal(posAdj);
                }
                if (animal.getSpecies() == Species.CROCODILE && reserve.getAnimal(posAdj).getSpecies() == Species.GAZELLE && (!reserve.getSector(position).equals(reserve.getSector(posAdj)))) {
                    status = GameStatus.CROCODILE;
                }
            }  
        }
        status = GameStatus.IMPALA;
    }

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
    @Override
    public void moveImpalaJones(int distance) throws GameException {
        if (status != GameStatus.IMPALA) {
            throw new GameException("It is time for Impala Jones to be moved");
        }
        if (distance > MAX_MOVE) {
            throw new GameException("The distance must not be greater than 3");
        }
        if (!getImpalaJones().checkMove(reserve, distance)) {
            throw new GameException("The column or row indicated by Impala Jones is already full");
        }
        getImpalaJones().move(distance);
        changePlayer();
        if (!getPieces().hasAvailable(getCurrentColor())) {
            changePlayer();
        }
        status = GameStatus.ANIMAL;

    }

    /**
     * Return true if the game is over.
     *
     * @return true if the game is over
     */
    @Override
    public boolean isOver() {
        return !getPieces().hasAvailable();
    }

    /**
     * Return the state of the game.
     *
     * @return the state of the game
     */
    @Override
    public GameStatus getStatus() {
        return status;
    }

    /**
     * Return the current player color.
     *
     * @return the current player color
     */
    @Override
    public Color getCurrentColor() {
        return getCurrentPlayer().getColor();
    }

    /**
     * Return the list of all player.
     *
     * @return the list of all player
     */
    @Override
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * Return the reserve.
     *
     * @return the reserve.
     */
    @Override
    public Reserve getReserve() {
        return reserve;
    }

    /**
     * Return the amount of animals of the specified species that the curent
     * player can put in the reserve.
     *
     * @param species of the animal searched
     * @return the amount of animals of the specified species for the current
     * player, left in the stock.
     */
    @Override
    public int getNb(Species species) {
        Color color = getCurrentPlayer().getColor();
        int nbAnimals = getPieces().getNbAnimals(color, species);
        return nbAnimals;
    }

    /**
     * Return Impala Jones.
     *
     * @return Impala Jones
     */
    @Override
    public ImpalaJones getImpalaJones() {
        return impala;
    }

    /**
     * Get the score of the player of the given color.
     *
     * @param color the color of the player
     * @return the score of the player of the given color.
     */
    @Override
    public int getScore(Color color) {
        int score = 0;
        for (Sector sect : getReserve().getSectors()) {
            if (sect.hasMajority(color)) {
                score = score + sect.getScore();
            }
        }
        if (getInaugurationWinner().getColor() == color) {
            score = score + POINT_INAUGURATION;
        }
        return score;
    }

    /**
     * After a player is done playing, changes the current player.
     */
    @Override
    public void changePlayer() {
        if (currentPlayer.equals(players.get(0))) {
            currentPlayer = players.get(1);
        } else {
            currentPlayer = players.get(0);
        }

    }

    /**
     * Move Impala Jones automatically when the next 3 lines or columns are
     * full.
     *
     * @throws GameException if the game status has not been put to IMPALA.
     */
    @Override
    public void moveImpalaJonesAutomatic() throws GameException {
        if (getStatus() != GameStatus.IMPALA) {
            throw new GameException("It is time for Impala Jones to be moved");
        }
        int distanceSafety = getImpalaJones().findFirst(reserve);
        getImpalaJones().move(distanceSafety);
        changePlayer();
        if (!getPieces().hasAvailable(getCurrentColor())) {
            changePlayer();
        }
        status = GameStatus.ANIMAL;

    }

    /**
     * Get the player who gets the Inauguration piece
     * @return the player who gets the Inauguration piece
     */
    @Override
    public Player getInaugurationWinner() {
        return inaugurationWinner;
    }

    /**
     * Check if a player has complete, the first a sector, and give the Inauguration piece to that player
     */
    @Override
    public void checkInauguration() {
        int i = 0;
        while (i < reserve.getSectors().size() && !reserve.isFullSector(i)) {
            i++;
        }
        if (i<reserve.getSectors().size()) {
            setInaugurationWinner(getCurrentPlayer());
        }
    }

    /**
     * Set the inauguration Winner with the attribute of a player.
     * @param inaugurationWinner the winner of the inauguration piece
     */
    public void setInaugurationWinner(Player inaugurationWinner) {
        this.inaugurationWinner = inaugurationWinner;
    }

    /**
     * Set the the status of the game to a defined status.
     * @param status the status of the game
     */
    @Override
    public void setStatus(GameStatus status) {
        this.status = status;
    }
    
    /**
     * Swap a animal put on pos1 with another put on pos2
     * @param pos1 a position on the board
     * @param pos2 a position on the board
     */
    @Override
    public void swap (Coordinates pos1, Coordinates pos2) {
        Animal temp ;
        temp = reserve.getAnimal(pos1);
        reserve.putAnimal(reserve.getAnimal(pos2), pos1);
        reserve.putAnimal(temp, pos2);
    }

}
