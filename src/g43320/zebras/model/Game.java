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
    
    private List<Player> players;
    private Reserve reserve;
    private ImpalaJones impala;
    private Pieces pieces;
    private GameStatus status;

    public Game() {
        players = new ArrayList<>();
        Player playerRed = new Player(Color.RED);
        Player playerGreen = new Player (Color.GREEN);
        players.add(playerRed);
        players.add(playerGreen);
        
        reserve = new Reserve();
        
        impala = new ImpalaJones();
    }
    
    
    
    @Override
    public void start() {
        
    }

    @Override
    public void setImpalaJonesFirstPosition(int position) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putAnimal(Coordinates position, Species species) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveImpalaJones(int distance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isOver() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GameStatus getStatus() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Color getCurrentColor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Player> getPlayers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reserve getReserve() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNb(Species species) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ImpalaJones getImpalaJones() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getScore(Color color) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
