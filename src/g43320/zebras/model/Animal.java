package g43320.zebras.model;

/**
 * An animal is a part of a game, it has its own color and its own species.
 * @author s_u_y_s_a
 */
public class Animal {
    private final Species species;
    private final Color color;

    /**
     * Creates an animal based on a specie and on a color.
     * @param species the specie of an animal.
     * @param color the color of an animal.
     */
    public Animal(Species species, Color color) {
        if (species==null) {
            throw new IllegalArgumentException("The species must be either gazelle, zebra, crocodile, elephant or lion");
        }
        if (color==null) {
            throw new IllegalArgumentException("The color must be either red or green");
        }this.species = species;
        this.color = color;
    }

    /**
     * Get the specie of an animal.
     * @return the specie of an animal
     */
    public Species getSpecies() {
        return species;
    }

    /**
     * Get the color of an animal (red or green).
     * @return the color of an animal
     */
    public Color getColor() {
        return color;
    }

    /**
     * Turn an object 'Animal' into a String.
     * @return a string describing the specie of the animal.
     */
    @Override
    public String toString() {
        String animal;
        String color;
        animal = getSpecies().name();
        color = getColor().name();
        return animal+" "+color;
    }
    
    
    
}
