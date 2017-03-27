package g43320.zebras.model;

/**
 * Impala Jones is a ranger who wanders around the reserve and determine the row
 * or the column on which the players have to play.
 *
 * @author s_u_y_s_a
 */
public class ImpalaJones {

    private int position;
    private final static int POSITIONMAX = 21;

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
     * @return
     */
    public int getPosition() {
        return position;
    }

    /**
     * Put Impala Jones on his initial position.
     *
     * @param nb
     */
    public void init(int nb) {
        if (nb>21) {
            throw new IllegalArgumentException ("Position not valid");
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
        position = (position + distance);
        if (position>21) {
            position = (position % POSITIONMAX)-1;
        }
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
        return (position >= Reserve.COL+Reserve.LG && position < Reserve.COL+Reserve.COL+Reserve.LG);
    }

    /**
     * Determine if Impala Jones is on the left side of the reserve.
     *
     * @return true if he is on the left side of the reserve, false otherwise.
     */
    public boolean isLeft() {
        return (position >= Reserve.COL+Reserve.COL+Reserve.LG && position < Reserve.COL+Reserve.COL+Reserve.LG+Reserve.LG);
    }

    /**
     * Determine if Impala Jones is on the right side of the reserve.
     *
     * @return true if he is on the right side of the reserve, false otherwise.
     */
    public boolean isRight() {
        return (position >= Reserve.COL && position < Reserve.COL+Reserve.LG);
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
        switch (position) {
            case 0:
            case 16:
                column = 0;
                break;
            case 1:
            case 15:
                column = 1;
                break;
            case 2:
            case 14:
                column = 2;
                break;
            case 3:
            case 13:
                column = 3;
                break;
            case 4:
            case 12:
                column = 4;
                break;
            case 5:
            case 11:
                column = 5;
                break;
            default: ;
                break;
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
        switch (position) {
            case 6:
            case 21:
                row = 0;
                break;
            case 7:
            case 20:
                row = 1;
                break;
            case 8:
            case 19:
                row = 2;
                break;
            case 9:
            case 18:
                row = 3;
                break;
            case 10:
            case 17:
                row = 4;
                break;
            default: ;
                break;
        }
        return row;
    }

    /**
     *
     * @param reserve
     * @param distance
     * @return
     */
    public boolean checkMove(Reserve reserve, int distance) {
        position = position + distance;
        boolean moveChecked;
        int row = getRow();
        int column = getColumn();
        if (row == -1) {
            moveChecked = !reserve.isFullColumn(column);
        } else {
            moveChecked = !reserve.isFullRow(row);
        }
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
        int cptPas = 0;
        while (!checkMove(reserve, distance)) {
            move(distance);
            cptPas++;
        }
        return cptPas;
    }

}
