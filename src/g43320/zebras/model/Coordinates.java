package g43320.zebras.model;

/**
 * A Coordinate is a position on a board game stated by a number from 0 to 4 for the line and 0 to 5 for the column.
 * @author s_u_y_s_a
 */
public class Coordinates {
    private final int row;
    private final int column;

    /**
     * Creates a new coordinates (made of 2 int).
     * @param row the row of a 2D array.
     * @param column the column of a 2D array. 
     */
    public Coordinates(int row, int column) {
        if (row < 0 && row > Reserve.LG-1) {
            throw new IllegalArgumentException("The row must be included between 0 and 4");
        }
        if (column < 0 && column > Reserve.COL-1) {
            throw new IllegalArgumentException("The column must be included between 0 and 5");
        }
        this.row = row;
        this.column = column;
    }

    /**
     * Get the value of the row of Coordinates.
     * @return the value of row.
     */
    public int getRow() {
        return row;
    }

    /**
     * Get the value of the column of Coordinates.
     * @return the value of column.
     */
    public int getColumn() {
        return column;
    }

    /**
     * Returns the hash code of a non-null argument and 0 for a null argument.
     * @return the hash code of a non-null argument and 0 for a null argument.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.row;
        hash = 17 * hash + this.column;
        return hash;
    }

    /**
     * Returns true if a Coordinate is equal to the argument and false otherwise.
     * @param obj any object to be compared to the list.
     * @return true if a Coordinate is equal to the arguments and false otherwise
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
        final Coordinates other = (Coordinates) obj;
        if (this.row != other.row) {
            return false;
        }
        return this.column == other.column;
    }

    /**
     * Turn a Coordinate into a String.
     * @return a string made from the Coordinate.
     */
    @Override
    public String toString() {
        return "(" + row + "," + column + ")";
    }
    
    
}
