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
     * Add 6 gazelles of each color in the stock of animals.
     */
    private void addGazelle() {
        final int NB_GAZELLE = 6;
        for (int i = 0; i < NB_GAZELLE; i++) {
            getAnimals().add(new Animal (Species.GAZELLE, Color.GREEN));
        }
        for (int i = 0; i < NB_GAZELLE; i++) {
            getAnimals().add(new Animal(Species.GAZELLE, Color.RED));
        }
    }

    /**
     * Add 1 lion of each color in the stock of animals.
     */
    private void addLion() {
        Animal lionGre = new Animal(Species.LION, Color.GREEN);
        Animal lionRed = new Animal(Species.LION, Color.RED);
        getAnimals().add(lionGre);
        getAnimals().add(lionRed);
    }

    /**
     * Add 1 elephant of each color in the stock of animals.
     */
    private void addElephant() {
        Animal elephantGre = new Animal(Species.ELEPHANT, Color.GREEN);
        Animal elephantRed = new Animal(Species.ELEPHANT, Color.RED);
        getAnimals().add(elephantGre);
        getAnimals().add(elephantRed);
    }

    /**
     * Add 5 zebras of each color in the stock of animals.
     */
    private void addZebra() {
        final int NB_ZEBRA = 5;
        for (int i = 0; i < NB_ZEBRA; i++) {
            getAnimals().add(new Animal(Species.ZEBRA, Color.GREEN));
        }
        for (int i = 0; i < NB_ZEBRA; i++) {
            getAnimals().add(new Animal(Species.ZEBRA, Color.RED));
        }
    }

    /**
     * Add 2 crocodiles of each color in the stock of animals.
     */
    private void addCrocodile() {
        final int NB_CROCODILE = 2;
        for (int i = 0; i < NB_CROCODILE; i++) {
            getAnimals().add(new Animal(Species.CROCODILE, Color.GREEN));
        }
        for (int i = 0; i < NB_CROCODILE; i++) {
            getAnimals().add(new Animal(Species.CROCODILE, Color.RED));
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
        Animal animal = new Animal (species, color);
        animals.remove(animal);
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

    /**
     * Put an animal back in the stock of Pieces.
     *
     * @param animal the animal to be put back in the stock
     */
    public void putBackAnimal(Animal animal) {
        animals.add(animal);
    }
    
    /**
     * Check if there is an animal (of the given color) left in the stock.
     * 
     * @param color the color associated to the animals.
     * @return true if there is still an animal of the given color, false otherwise.
     */
    public boolean hasAvailable(Color color) {
        int i = 0;
        while (i<animals.size() && animals.get(i).getColor()!=color) {
            i++;
        }
        return i<animals.size();
    }

}
