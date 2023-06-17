package de.martinclan.chessmate.data;

/**
 * Represents a piece on a board
 */
public abstract class Piece {
    protected final Board board;

    /**
     * Constructs a Piece object with the specified board. The board information is
     * used for pieces which can move in a direction up to the end of the board.
     *
     * @param board The board on which the piece is placed
     */
    protected Piece(Board board) {
        this.board = board;
    }

    /**
     * Retrieves the capture perimeter of the piece containing all vectors a piece of
     * this type can move when capturing another piece.
     *
     * @return The capture perimeter of this piece
     */
    public abstract CapturePerimeter getCapturePerimeter();
}
