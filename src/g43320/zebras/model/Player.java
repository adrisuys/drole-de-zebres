package g43320.zebras.model;

import java.util.Objects;

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

    /**
     * Get the color associated to a Player
     * @return the color associated to a Player.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Returns the hash code of a non-null argument and 0 for a null argument.
     * @return the hash code of a non-null argument and 0 for a null argument.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.color);
        return hash;
    }

    /**
     * Returns true if a Player is equal to the argument and false otherwise.
     * @param obj any object to be compared to the list.
     * @return true if a Player is equal to the arguments and false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (this.color != other.color) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String player;
        if (getColor()==Color.GREEN){
            player = "player GREEN";
        } else {
            player = "player RED";
        }
        return player;
    }
    
    
    
    

}
