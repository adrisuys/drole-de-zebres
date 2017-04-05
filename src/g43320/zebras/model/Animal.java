package g43320.zebras.model;

import static g43320.zebras.model.Color.RED;
import java.util.Objects;

/**
 * An animal is a part of a game, it has its own color and its own species.
 *
 * @author s_u_y_s_a
 */
public class Animal {

    private final Species species;
    private final Color color;
    private AnimalState state;

    /**
     * Creates an animal based on a specie and on a color.
     *
     * @param species the specie of an animal.
     * @param color the color of an animal.
     */
    public Animal(Species species, Color color) {
        if (species == null) {
            throw new IllegalArgumentException("The species must be either gazelle, zebra, crocodile, elephant or lion");
        }
        if (color == null) {
            throw new IllegalArgumentException("The color must be either red or green");
        }
        this.species = species;
        this.color = color;
    }

    /**
     * Get the specie of an animal.
     *
     * @return the specie of an animal
     */
    public Species getSpecies() {
        return species;
    }

    /**
     * Get the color of an animal (red or green).
     *
     * @return the color of an animal
     */
    public Color getColor() {
        return color;
    }

    /**
     * Turn an object 'Animal' into a String.
     *
     * @return a string describing the specie of the animal.
     */
    @Override
    public String toString() {
        String animal;
        animal = getSpecies().name().substring(0, 1);
        if (getState() == AnimalState.HIDDEN) {
            animal = "X";
        }
        if (getColor() == RED) {
            return "\u001B[31m" + animal + "\u001B[0m";
        } else {
            return "\u001B[32m" + animal + "\u001B[0m";
        }

    }

    /**
     * Returns the hash code of a non-null argument and 0 for a null argument.
     *
     * @return the hash code of a non-null argument and 0 for a null argument.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.species);
        hash = 73 * hash + Objects.hashCode(this.color);
        return hash;
    }

    /**
     * Returns true if a Animal is equal to the argument and false otherwise.
     *
     * @param obj any object to be compared to the list.
     * @return true if a Animal is equal to the arguments and false otherwise
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
        final Animal other = (Animal) obj;
        if (this.species != other.species) {
            return false;
        }
        if (this.color != other.color) {
            return false;
        }
        return true;
    }

    /**
     * Get the state of an animal (HIDDEN, REST or RUN).
     *
     * @return the state of an animal (HIDDEN, REST or RUN).
     */
    public AnimalState getState() {
        return state;
    }

    /**
     * Sets the state.
     *
     * @param state the state to be set.
     */
    public void setState(AnimalState state) {
        this.state = state;
    }

    /**
     * Determine what happens when two animals are put next to each other.
     *
     * @param other an animal that may changes its state as he's put next to
     * another one.
     */
    public void action(Animal other) {
        if (this.species == Species.LION && other.species == Species.GAZELLE) {
            other.state = AnimalState.RUN;
        }
        if (this.species == Species.LION && other.species == Species.ZEBRA) {
            other.state = AnimalState.HIDDEN;
        }
        if (this.species == Species.ZEBRA && other.species == Species.LION) {
            this.state = AnimalState.HIDDEN;
        }
        /*if (this.species == Species.GAZELLE && other.species == Species.LION) {
            this.state = AnimalState.RUN;
        }*/
        
    }

}
