package g43320.zebras.model;

/**
 * An animal is either on the reserve (REST), on the run (RUN) or hidden
 * (HIDDEN)
 *
 * @author s_u_y_s_a
 */
public enum AnimalState {

    /**
     * An animal can hide and lose all its point.
     */
    HIDDEN,
    /**
     * The normal state of an animal.
     */
    REST,
    /**
     * An animal can run from the reserve and return to the stock of pieces.
     */
    RUN;
}
