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

    public Sector(int number, Coordinates... coordinates) {
        this.number = number;
        List <Coordinates> coord = Arrays.asList(coordinates);
        this.coordinates = coord;
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
    
    
    
    
}
