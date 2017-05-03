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
    
    /**
     * A crocodile is put beside a gazelle, the player has to possibility to swap them
     */
    CROCODILE;
}
