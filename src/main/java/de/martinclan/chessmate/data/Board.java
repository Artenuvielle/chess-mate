package de.martinclan.chessmate.data;

/**
 * The Board class represents a 2 dimensional chess board with a specified size.
 *
 * @param sizeX The size of the board in one direction
 * @param sizeY The size of the board in the other direction
 */
public record Board(int sizeX, int sizeY) {

    /**
     * Checks if a given position is within the bounds of the board.
     *
     * @param vector The position to check.
     * @return True if the position is within the bounds of the board, false otherwise.
     */
    public boolean containsPosition(Vector vector) {
        int x = vector.x();
        int y = vector.y();
        return x >= 0 && x <= sizeX - 1 && y >= 0 && y <= sizeY - 1;
    }
}
