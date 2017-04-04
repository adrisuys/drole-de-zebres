package g43320.zebras.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The reserve represent the board on which the game takes place.
 *
 * @author s_u_y_s_a
 */
public class Reserve {

    private final Animal[][] animals;
    final static int COL = 6;
    final static int LG = 5;

    /**
     * Creates a reserve, which is a 2D array of 5x6 of Animals.
     */
    public Reserve() {
        this.animals = new Animal[this.LG][this.COL];
    }

    /**
     * Get the array set as an attribute.
     *
     * @return the array set as an attribute.
     */
    public Animal[][] getAnimals() {
        return animals;
    }

    /**
     * Determine if a position on the reserve is free.
     *
     * @param pos a coordinate on the reserve.
     * @return a boolean indicating if the position is free.
     */
    public boolean isFree(Coordinates pos) {
        if (pos == null) {
            throw new IllegalArgumentException("Coordinates aren't valids");
        }
        return animals[pos.getRow()][pos.getColumn()] == null;
    }

    /**
     * Put an Animal on the Coordinates of the reserve indicated by the
     * parameter 'pos'.
     *
     * @param animal an Animal to be put on the reserve
     * @param pos the Coordinate where the Animal is to be put.
     */
    public void putAnimal(Animal animal, Coordinates pos) {
        if (pos == null) {
            throw new IllegalArgumentException("Coordinates aren't valids");
        }
        if (!isFree(pos)) {
            throw new IllegalArgumentException("There is already an animal at that position");
        }
        animals[pos.getRow()][pos.getColumn()] = animal;
    }

    /**
     * Get the specie and the color of the Animal at the Coordinate indicated by
     * 'pos'.
     *
     * @param pos a Coordinate on the reserve.
     * @return the animal at the Coordinate indicated by 'pos', null if the
     * coordinates is free.
     */
    public Animal getAnimal(Coordinates pos) {
        if (pos == null) {
            throw new IllegalArgumentException("Coordinates aren't valids");
        }
        return animals[pos.getRow()][pos.getColumn()];
    }

    /**
     * Turn a reserve into a String
     *
     * @return an array converted into a String.
     */
    @Override
    public String toString() {
        String aString = "";
        for (Animal[] animal : getAnimals()) {
            for (Animal animal1 : animal) {
                if (animal1 == null) {
                    aString = aString + " || " + "CASE  LIBRE  ";
                } else {
                    aString = aString + " || " + "  " + animal1 + " " ;
                }  
            }
            aString = aString + "\n" + "-------------------------------------------------------------------------------------------" + "\n";
        }
        return aString;
    }
    
    /**
     * Check if a column is full, if all its case are occupied by animals.
     * @param column a column of the reserve.
     * @return true if it is full, false otherwise.
     */
    public boolean isFullColumn (int column) {
        int i = 0;
        while (i<LG && this.getAnimals()[i][column]!=null) {
            i++;
        }
        return i == LG;
    }
    
    /**
     * Check if a row is full, if all its case are occupied by animals.
     * @param row a column of the reserve.
     * @return true if it is full, false otherwise.
     */
    public boolean isFullRow (int row) {
        int i = 0;
        while (i<COL && this.getAnimals()[row][i]!=null) {
            i++;
        }
        return i == COL;
    }
    
    /**
     * Return a list of all the adjacents coordinates of the one entered in argument.
     * @param position a coordinate on the reserve
     * @return a list of all the adjacents coordinates of the one entered in argument
     */
    public List<Coordinates> getAdjacents (Coordinates position) {
        List<Coordinates> list = new ArrayList<>();
        if (position.getRow() != 0) {
            list.add(new Coordinates(position.getRow() - 1, position.getColumn()));
        }
        if (position.getRow() != getAnimals().length - 1) {
            list.add(new Coordinates(position.getRow() + 1, position.getColumn()));
        }
        if (position.getColumn() != 0) {
            list.add(new Coordinates(position.getRow(), position.getColumn() - 1));
        }
        if (position.getColumn() != getAnimals()[position.getRow()].length - 1) {
            list.add(new Coordinates(position.getRow(), position.getColumn() + 1));
        }
        return list;
    }
    
    /**
     * Remove an animal from the reserve by setting its coordinate to null.
     * @param pos the coordinates from which an animal must be removed.
     */
    public void removeAnimal (Coordinates pos) {
        if (isFree(pos)) {
            throw new IllegalArgumentException("There is no animal to be removed");
        }
        getAnimals()[pos.getRow()][pos.getColumn()] = null;
    }

}
