package g43320.zebras.model;

/**
 * Impala Jones is a ranger who wanders around the reserve and determine the row
 * or the column on which the players have to play.
 *
 * @author s_u_y_s_a
 */
public class ImpalaJones {

    private int position;
    private final static int POSITION_MAX = 21;

    /**
     * Creates the piece "Impala Jones", his position is represented by a number
     * between 0 and 21, at first, he is set at the position -1.
     */
    public ImpalaJones() {
        this.position = -1;
    }

    /**
     * Get the position of Impala Jones (between 0 and 21).
     *
     * @return the position of Impala Jones.
     */
    public int getPosition() {
        return position;
    }

    /**
     * Put Impala Jones on his initial position.
     *
     * @param nb the position at which Impala Jones must be put at the beginning of the game
     * 
     * @throws IllegalArgumentException if the nb is greater than 21
     */
    public void init(int nb) {
        if (nb > POSITION_MAX) {
            throw new IllegalArgumentException("Position not valid");
        }
        position = nb;
    }

    /**
     * Move Impala Jones on his path.
     *
     * @param distance the number of step Impala Jones has to make around the
     * reserve
     */
    public void move(int distance) {

        position = (position+distance) % (POSITION_MAX + 1);
        

    }

    /**
     * Determine if Impala Jones is on the upper side of the reserve.
     *
     * @return true if he is on the upper side of the reserve, false otherwise.
     */
    public boolean isUp() {
        return (position >= 0 && position < Reserve.COL);
    }

    /**
     * Determine if Impala Jones is on the down side of the reserve.
     *
     * @return true if he is on the down side of the reserve, false otherwise.
     */
    public boolean isDown() {
        return (position >= Reserve.COL + Reserve.LG && position < Reserve.COL + Reserve.COL + Reserve.LG);
    }

    /**
     * Determine if Impala Jones is on the left side of the reserve.
     *
     * @return true if he is on the left side of the reserve, false otherwise.
     */
    public boolean isLeft() {
        return (position >= Reserve.COL + Reserve.COL + Reserve.LG && position < Reserve.COL + Reserve.COL + Reserve.LG + Reserve.LG);
    }

    /**
     * Determine if Impala Jones is on the right side of the reserve.
     *
     * @return true if he is on the right side of the reserve, false otherwise.
     */
    public boolean isRight() {
        return (position >= Reserve.COL && position < Reserve.COL + Reserve.LG);
    }

    /**
     * Get the column on which the players can play regarding Impala Jones'
     * position.
     *
     * @return the column on which the players can play regarding Impala Jones'
     * position or -1 if there is no corresponding column.
     */
    public int getColumn() {
        int column = -1;
        if (isUp()) {
            column = position;
        }
        if (isDown()) {
            column = Math.abs(position - (Reserve.COL + Reserve.LG + Reserve.COL - 1));
        }
        return column;
    }

    /**
     * Get the row on which the players can play regarding Impala Jones'
     * position.
     *
     * @return the row on which the players can play regarding Impala Jones'
     * position or -1 if there is no corresponding row.
     */
    public int getRow() {
        int row = -1;
        if (isRight()) {
            row = (position % Reserve.COL);
        }
        if (isLeft()) {
            row = Math.abs(position - (Reserve.COL + Reserve.LG + Reserve.COL + Reserve.LG - 1));
        }
        return row;
    }

    /**
     * Check if a move is valid or not.
     *
     * @param reserve the board of the game.
     * @param distance the distance Impala Jones is supposed to be moved.
     * @return true if the move is valid, false if it is not.
     */
    public boolean checkMove(Reserve reserve, int distance) {
        position = position + distance;
        boolean moveChecked = false;
        int row = getRow();
        int column = getColumn();
        if (isUp() || isDown()) {
            moveChecked = !reserve.isFullColumn(column);
        }
        if (isLeft() || isRight()){
            moveChecked = !reserve.isFullRow(row);
        }
        position = position - distance;
        return moveChecked;
    }

    /**
     * Determine if a player can play on a given coordinate (on the reserve)
     * regarding Impala Jones' position.
     *
     * @param pos the coordinate of the case a player want to play on.
     * @return true if a player can play on a given coordinate (on the reserve)
     * regarding Impala Jones' position, false otherwise.
     */
    public boolean valid(Coordinates pos) {
        int tailleLn = Reserve.COL;
        int tailleCol = Reserve.LG;
        boolean positionOkay = false;
        if (isUp()) {
            positionOkay = (position == pos.getColumn());
        }
        if (isRight()) {
            positionOkay = (position % Reserve.COL == pos.getRow());
        }
        if (isDown()) {
            positionOkay = (pos.getColumn() == Math.abs(position - (tailleLn + tailleCol + tailleLn - 1)));
        }
        if (isLeft()) {
            positionOkay = (pos.getRow() == Math.abs(position - (tailleLn + tailleCol + tailleLn + tailleCol - 1)));
        }
        return positionOkay;
    }

    /**
     * Get the first position Impala Jones can take, knowing that the row or
     * column corresponding can not be full of pieces.
     *
     * @param reserve the reserve on which the player put the animals.
     * @return the first position Impala Jones can take, knowing that the row or
     * column corresponding can not be full of pieces.
     */
    public int findFirst(Reserve reserve) {
        int distance = 1;
        while (!checkMove(reserve, distance)) {
            distance++;
        }
        return distance;
    }

}
