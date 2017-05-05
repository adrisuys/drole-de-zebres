package g43320.zebras.model;

/**
 * Species of animal that can be used in the game.
 *
 * @author s_u_y_s_a
 */
public enum Species {

    /**
     * animals that are gazelles.
     */
    GAZELLE(2),
    /**
     * animals that are zebras.
     */
    ZEBRA(6),
    /**
     * animals that are lions.
     */
    LION(1),
    /**
     * animals that are elephants.
     */
    ELEPHANT(5),
    /**
     * animals that are crocodiles.
     */
    CROCODILE(0);
    
    private final int value;

    private Species(int value) {
        this.value = value;
    }

    /**
     * Get the value of a Specie.
     * @return the value of a Specie
     */
    public int getValue() {
        return value;
    }

}
