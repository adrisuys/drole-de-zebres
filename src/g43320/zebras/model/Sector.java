package g43320.zebras.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author s_u_y_s_a
 */
public class Sector {
    
    private int number;
    private List <Coordinates> coordinates;
    private Reserve reserve;

    public Sector(int number, Reserve reserve, Coordinates... coordinates) {
        this.number = number;
        List <Coordinates> coord = Arrays.asList(coordinates);
        this.coordinates = coord;
        this.reserve = reserve;
    }

    public int getNumber() {
        return number;
    }
    
    public boolean contains (Coordinates position) {
        return coordinates.contains(position);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.number;
        hash = 97 * hash + Objects.hashCode(this.coordinates);
        return hash;
    }

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
    
    public boolean isFull() {
        int i = 0;
        while (i<coordinates.size() && reserve.getAnimal(coordinates.get(i)) != null) {
            i++;
        }
        return i==coordinates.size();
    }
    
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
    
    public int getScore () {
        if (!isFull()) {
            throw new IllegalArgumentException("The sector is not full, we can't calculate the score yet");
        }
        int score = 0;
        for (Coordinates pos : coordinates) {
            if (reserve.getAnimal(pos).getState()!=AnimalState.HIDDEN) {
                score = score + reserve.getAnimal(pos).getSpecies().getValue();
            } 
        }
        return score;
    }
    
    
}
