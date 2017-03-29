package g43320.zebras.model;

/**
 * A player put the different pieces on the reserve and try to win the game by
 * earning more point than its opponent.
 *
 * @author s_u_y_s_a
 */
public class Player {

    private final Color color;

    /**
     * Creates a player by giving it a color (green or red).
     * @param color 
     */
    public Player(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
    
    

}
