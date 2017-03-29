/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g43320.zebras.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the main class of the model, it organises the game itself.
 *
 * @author s_u_y_s_a
 */
public class Game implements Model {
    
    private final List<Player> players;
    private Reserve reserve;
    private ImpalaJones impala;
    private Pieces pieces;
    private GameStatus status;
    private Player currentPlayer;

    public Game() {
        players = new ArrayList<>();
        Player playerRed = new Player(Color.RED);
        Player playerGreen = new Player (Color.GREEN);
        players.add(playerRed);
        players.add(playerGreen);
        
        reserve = new Reserve();
        
        impala = new ImpalaJones();
        
        pieces = new Pieces();
        
        status = GameStatus.INIT;
        
        int random = (int) ((Math.random()*2));
        currentPlayer = players.get(random);
        
    }

    public ImpalaJones getImpala() {
        return impala;
    }

    public Pieces getPieces() {
        return pieces;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    
    @Override
    public void start() {
        Game game = new Game();
    }

    @Override
    public void setImpalaJonesFirstPosition(int position) {
        if (status!=GameStatus.INIT) {
            throw new GameException("It is time for the game to be initialize");
        }
        getImpalaJones().init(position);
    }

    @Override
    public void putAnimal(Coordinates position, Species species) {
        if (status!=GameStatus.ANIMAL) {
            throw new GameException("It is time for the animals to be put on the board");
        }
        Color color = getCurrentPlayer().getColor();
        Animal animal = getPieces().getAnimal(color, species);
        getReserve().putAnimal(animal, position);
    }

    @Override
    public void moveImpalaJones(int distance) {
        if (status!=GameStatus.IMPALA) {
            throw new GameException("It is time for Impala Jones to be moved");
        }
        if (distance>3) {
            throw new GameException("The distance must not be greater than 3");
        }
        if (!getImpalaJones().checkMove(reserve, distance)) {
            throw new GameException("The column or row indicated by Impala Jones is already full");
        }
        getImpalaJones().move(distance);
        
    }

    @Override
    public boolean isOver() {
        int i = 0;
        while (i<Reserve.LG && reserve.isFullRow(i)) {
            i++;
        }
        return i==Reserve.LG;
    }

    @Override
    public GameStatus getStatus() {
        return status;
    }

    @Override
    public Color getCurrentColor() {
        return getCurrentPlayer().getColor();
    }

    @Override
    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public Reserve getReserve() {
        return reserve;
    }

    @Override
    public int getNb(Species species) {
        Color color = getCurrentPlayer().getColor();
        int nbAnimals = getPieces().getNbAnimals(color, species);
        return nbAnimals;
    }

    @Override
    public ImpalaJones getImpalaJones() {
        return impala;
    }

    @Override
    public int getScore(Color color) {
        return 0;     
    }

}
