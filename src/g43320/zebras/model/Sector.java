package g43320.zebras.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * a Sector is formed by 3, 5 or 7 cases of the board. It is useful in the attribution of the points to the player.
 * @author s_u_y_s_a
 */
public class Sector {
    
    private final int number;
    private final List <Coordinates> coordinates;
    private final Reserve reserve;

    /**
     * Creates a new instance of a Sector.
     * @param number the number by which the sector is defined
     * @param reserve the reserve that contains the sector
     * @param coordinates the coordinates of all the cases that the sector contains
     */
    public Sector(int number, Reserve reserve, Coordinates... coordinates) {
        this.number = number;
        List <Coordinates> coord = Arrays.asList(coordinates);
        this.coordinates = coord;
        this.reserve = reserve;
    }

    /**
     * Get the number of the sector.
     * @return Get the number of the sector. 
     */
    public int getNumber() {
        return number;
    }
    
    /**
     * Check if a sector contains a coordinates.
     * @param position a given coordinate
     * @return true if the sector contains the coordinates, false otherwise
     */
    public boolean contains (Coordinates position) {
        return coordinates.contains(position);
    }

    /**
     * Returns the hash code of a non-null argument and 0 for a null argument.
     *
     * @return the hash code of a non-null argument and 0 for a null argument.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.number;
        hash = 97 * hash + Objects.hashCode(this.coordinates);
        return hash;
    }

    /**
     * Returns true if a Sector is equal to the argument and false
     * otherwise.
     *
     * @param obj any object to be compared to the list.
     * @return true if a Sector is equal to the arguments and false
     * otherwise
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
        final Sector other = (Sector) obj;
        if (this.number != other.number) {
            return false;
        }
        if (!Objects.equals(this.coordinates, other.coordinates)) {
            return false;
        }
        return true;
    }
    
    /**
     * Check if the sector is full.
     * @return  true if it is full, false otherwise.
     */
    public boolean isFull() {
        int i = 0;
        while (i<coordinates.size() && reserve.getAnimal(coordinates.get(i)) != null) {
            i++;
        }
        return i==coordinates.size();
    }
    
    /**
     * Check if a player (given by its color) has a majority of pieces on the sector.
     * @param color a given color attributed to a player
     * @return true if a player (given by its color) has a majority of pieces on the sector, false otherwise.
     */
    public boolean hasMajority(Color color) {
        if (!isFull()) {
            throw new IllegalArgumentException("The sector is not full, no one has a majority yet");
        }
        int cptRed = 0;
        int cptGreen = 0;
        for (Coordinates pos : coordinates) {
            if (reserve.getAnimal(pos).getColor()==Color.RED) {
                cptRed ++;
            } else {
                cptGreen ++;
            }
        }
        return ((color == Color.GREEN && cptGreen>cptRed)||(color == Color.RED && cptRed>cptGreen));
    }
    
    /**
     * Count the score of a sector by adding all the value of the animals on the sector.
     * @return the total score of the sector.
     */
    public int getScore () {
        if (!isFull()) {
            throw new IllegalArgumentException("The sector is not full, we can't calculate the score yet");
        }
        int score = 0;
        for (Coordinates pos : coordinates) {
            score = score + reserve.getAnimal(pos).getValue();
        }
        return score;
    }
    
    
}
