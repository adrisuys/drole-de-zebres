package g43320.zebras.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The class represent the pieces used in the game, they represent 15 red
 * animals and 15 green (6 gazelles, 5 zebras, 1 lion, 1 elephant and 2
 * crocodiles for each color).
 *
 * @author s_u_y_s_a
 */
public class Pieces {

    private List<Animal> animals;

    /**
     * Creates a stock of pieces.
     */
    public Pieces() {
        this.animals = new ArrayList<>();
        addCrocodile();
        addElephant();
        addGazelle();
        addLion();
        addZebra();
    }

    /**
     * Get the list composed of all the animals of the game.
     *
     * @return a list of animals
     */
    public List<Animal> getAnimals() {
        return animals;
    }

    /**
     * Add 6 gazelles in the stock of animals.
     */
    private void addGazelle() {
        final int nbGazelle = 6;
        Animal gazelleGre = new Animal(Species.GAZELLE, Color.GREEN);
        Animal gazelleRed = new Animal(Species.GAZELLE, Color.RED);
        for (int i = 0; i < nbGazelle; i++) {
            getAnimals().add(i, gazelleGre);
        }
        for (int i = 0; i < 6; i++) {
            getAnimals().add(i, gazelleRed);
        }
    }

    /**
     * Add 1 lion in the stock of animals.
     */
    private void addLion() {
        Animal lionGre = new Animal(Species.LION, Color.GREEN);
        Animal lionRed = new Animal(Species.LION, Color.RED);
        getAnimals().add(lionGre);
        getAnimals().add(lionRed);
    }

    /**
     * Add 1 elephant in the stock of animals.
     */
    private void addElephant() {
        Animal elephantGre = new Animal(Species.ELEPHANT, Color.GREEN);
        Animal elephantRed = new Animal(Species.ELEPHANT, Color.RED);
        getAnimals().add(elephantGre);
        getAnimals().add(elephantRed);
    }

    /**
     * Add 5 zebras in the stock of animals.
     */
    private void addZebra() {
        final int nbZebra = 5;
        Animal zebraGre = new Animal(Species.ZEBRA, Color.GREEN);
        Animal zebraRed = new Animal(Species.ZEBRA, Color.RED);
        for (int i = 0; i < nbZebra; i++) {
            getAnimals().add(i, zebraGre);
        }
        for (int i = 0; i < nbZebra; i++) {
            getAnimals().add(i, zebraRed);
        }
    }

    /**
     * Add 2 crocodiles in the stock of animals.
     */
    private void addCrocodile() {
        final int nbCrocodile = 2;
        Animal crocoGre = new Animal(Species.CROCODILE, Color.GREEN);
        Animal crocoRed = new Animal(Species.CROCODILE, Color.RED);
        for (int i = 0; i < nbCrocodile; i++) {
            getAnimals().add(i, crocoGre);
        }
        for (int i = 0; i < nbCrocodile; i++) {
            getAnimals().add(i, crocoRed);
        }
    }

    /**
     * Get an animal corresponding to the color and the specie given out of the
     * stock.
     *
     * @param color the color of the wanted animal
     * @param species the specie of the wanted animal.
     * @return an animal corresponding to the color and the specie given or
     * throw a exception if no animal matches the parameters.
     */
    public Animal getAnimal(Color color, Species species) {
        int i = 0;
        Animal animal = null;
        while (i < getAnimals().size() && (getAnimals().get(i).getColor()!=color || getAnimals().get(i).getSpecies()!=species)) {
            i++;
        }
        if (getAnimals().size() == i) {
            throw new ArrayIndexOutOfBoundsException("The animal is not in the list");
        } else {
            animal = getAnimals().get(i);
        }
        
        getAnimals().remove(i);
        return animal;
    }

    /**
     * Determine if the stock of animals is empty.
     *
     * @return true if the stock is empty, false otherwise.
     */
    public boolean hasAvailable() {
        return !getAnimals().isEmpty();
    }

    /**
     * Get the number of animals in the stock that matches the given parameters.
     *
     * @param color the color of the wanted animals.
     * @param species the species of the wanted animals.
     * @return the number of animals in the stock that matches the given
     * parameters.
     */
    public int getNbAnimals(Color color, Species species) {
        int nbAnimals = 0;
        Animal animal = new Animal(species, color);
        for (Animal a : getAnimals()) {
            if (a.equals(animal)) {
                nbAnimals++;
            }
        }
        return nbAnimals;
    }

    
    

}
