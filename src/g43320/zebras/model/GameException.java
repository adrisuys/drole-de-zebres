package g43320.zebras.model;

/**
 * Creats an exception for the game of Drôles de Zèbres.
 *
 * @author s_u_y_s_a
 */
public class GameException extends Exception {

    /**
     * Creates a new instance of <code>GameException</code> without detail
     * message.
     */
    public GameException() {
    }

    /**
     * Constructs an instance of <code>GameException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public GameException(String msg) {
        super(msg);
    }
}
