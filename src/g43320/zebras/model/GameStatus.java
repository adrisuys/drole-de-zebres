/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g43320.zebras.model;

/**
 * The class GameStatus can identify in which part of the game the players are.
 *
 * @author s_u_y_s_a
 */
public enum GameStatus {
    /**
     * The initialization of the game, the reserve and the different pieces are set.
     */
    INIT,
    
    /**
     * A player put an animal on the reserve.
     */
    ANIMAL,
    
    /**
     * A player move Impala Jones on its path.
     */
    IMPALA,
}
