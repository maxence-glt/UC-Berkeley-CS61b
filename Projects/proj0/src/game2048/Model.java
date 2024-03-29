package game2048;

import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;


/** The state of a game of 2048.
 *  @author P. N. Hilfinger + Josh Hug
 */
public class Model {
    /** Current contents of the board. */
    private final Board board;
    /** Current score. */
    private int score;
    /** Maximum score so far.  Updated when game ends. */
    private int maxScore;

    /* Coordinate System: column C, row R of the board (where row 0,
     * column 0 is the lower-left corner of the board) will correspond
     * to board.tile(c, r).  Be careful! It works like (x, y) coordinates.
     */

    /** Largest piece value. */
    public static final int MAX_PIECE = 2048;

    /** A new 2048 game on a board of size SIZE with no pieces
     *  and score 0. */
    public Model(int size) {
        board = new Board(size);
        score = maxScore = 0;
    }

    /** A new 2048 game where RAWVALUES contain the values of the tiles
     * (0 if null). VALUES is indexed by (row, col) with (0, 0) corresponding
     * to the bottom-left corner. Used for testing purposes. */
    public Model(int[][] rawValues, int score, int maxScore) {
        board = new Board(rawValues);
        this.score = score;
        this.maxScore = maxScore;
    }

    /** Return the current Tile at (COL, ROW), where 0 <= ROW < size(),
     *  0 <= COL < size(). Returns null if there is no tile there.
     *  Used for testing. */
    public Tile tile(int col, int row) {
        return board.tile(col, row);
    }

    /** Return the number of squares on one side of the board. */
    public int size() {
        return board.size();
    }

    /** Return the current score. */
    public int score() {
        return score;
    }

    /** Return the current maximum game score (updated at end of game). */
    public int maxScore() {
        return maxScore;
    }

    /** Clear the board to empty and reset the score. */
    public void clear() {
        score = 0;
        board.clear();
    }

    /** Add TILE to the board. There must be no Tile currently at the
     *  same position. */
    public void addTile(Tile tile) {
        board.addTile(tile);
        checkGameOver();
    }

    /** Return true iff the game is over (there are no moves, or
     *  there is a tile with value 2048 on the board). */
    public boolean gameOver() {
        return maxTileExists(board) || !atLeastOneMoveExists(board);
    }

    /** Checks if the game is over and sets the maxScore variable
     *  appropriately.
     */
    private void checkGameOver() {
        if (gameOver()) {
            maxScore = Math.max(score, maxScore);
        }
    }

    /** Returns true if at least one space on the Board is empty.
     *  Empty spaces are stored as null.
     * */

    public static boolean emptySpaceExists(Board b) {
        for (int r = 0; r < b.size(); r++){
            for (int c = 0; c < b.size(); c++){
                if (b.tile(c, r) == null) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns true if any tile is equal to the maximum valid value.
     * Maximum valid value is given by this.MAX_PIECE. Note that
     * given a Tile object t, we get its value with t.value().
     */
    public static boolean maxTileExists(Board b) {
        for (int r = 0; r < b.size(); r++){
            for (int c = 0; c < b.size(); c++){
                if (!(b.tile(c, r) == null) && (b.tile(c, r).value() == MAX_PIECE)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns true if there are any valid moves on the board.
     * There are two ways that there can be valid moves:
     * 1. There is at least one empty space on the board.
     * 2. There are two adjacent tiles with the same value.
     */

    public static boolean rightLeftSame(Board b) {
        for (int r = 0; r < b.size(); r++) {
            for (int c = 1; c < b.size(); c++){
                if (b.tile(c, r) == b.tile(c - 1, r)) {
                    return true;
                } if ((b.tile(c, r) != null && b.tile(c - 1, r) == null) || (b.tile(c, r) == null && b.tile(c - 1, r) != null)) {
                    continue;
                } if (b.tile(c, r).value() == b.tile(c - 1, r).value()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean upDownSame(Board b) {
        for (int r = 0; r < b.size() - 1; r++) {
            for (int c = 0; c < b.size(); c++){
                if (b.tile(c, r) == b.tile(c, r + 1)) {
                    return true;
                } if ((b.tile(c, r) != null && b.tile(c, r + 1) == null) || (b.tile(c, r) == null && b.tile(c, r + 1) != null)) {
                    continue;
                } if (b.tile(c, r).value() == b.tile(c, r + 1).value()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean atLeastOneMoveExists(Board b) {
        return (emptySpaceExists(b) || rightLeftSame(b) || upDownSame(b));
    }

    /** Tilt the board toward SIDE.
     *
     * 1. If two Tile objects are adjacent in the direction of motion and have
     *    the same value, they are merged into one Tile of twice the original
     *    value and that new value is added to the score instance variable
     * 2. A tile that is the result of a merge will not merge again on that
     *    tilt. So each move, every tile will only ever be part of at most one
     *    merge (perhaps zero).
     * 3. When three adjacent tiles in the direction of motion have the same
     *    value, then the leading two tiles in the direction of motion merge,
     *    and the trailing tile does not.
     * */


    public void columnHelper(int column) {
        int max_row = 3;

        for (int row = 2; row >= 0; row -= 1) {
            for (int max = max_row; max > row; max -= 1) {
                Tile t_max = board.tile(column, max);
                Tile t_curr = board.tile(column, row);

                if (t_curr == null) {
                    continue;

                } if (t_max == null) {
                    board.move(column, max_row, t_curr);
                    continue;

                } if (t_max.value() == t_curr.value()) {
                    score += t_max.value() * 2;
                    board.move(column, max_row, t_curr);
                    max_row -= 1;

                } else
                    max_row -= 1;
            }
        }
    }

    public void tilt(Side side) {
        System.out.println();
        boolean changed = false;
        board.setViewingPerspective(side);
//        System.out.println(board.);

        for (int c = 0; c < board.size(); c += 1) {
            columnHelper(c);

        }

        checkGameOver();
        board.setViewingPerspective(Side.NORTH);
    }


    @Override
    public String toString() {
        Formatter out = new Formatter();
        out.format("%n[%n");
        for (int row = size() - 1; row >= 0; row -= 1) {
            for (int col = 0; col < size(); col += 1) {
                if (tile(col, row) == null) {
                    out.format("|    ");
                } else {
                    out.format("|%4d", tile(col, row).value());
                }
            }
            out.format("|%n");
        }
        String over = gameOver() ? "over" : "not over";
        out.format("] %d (max: %d) (game is %s) %n", score(), maxScore(), over);
        return out.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (getClass() != o.getClass()) {
            return false;
        } else {
            return toString().equals(o.toString());
        }
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    public static void main(String[] args) {
        int[][] rawVals = new int[][] {
                {2, 4, 2, 4},
                {4, 8, 4, 2},
                {2, 16, 4, 8},
                {4, 8, 4, 2},
        };
        Board b = new Board(rawVals);

        System.out.println(upDownSame(b));
    }
}
