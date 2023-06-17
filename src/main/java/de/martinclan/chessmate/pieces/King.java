package de.martinclan.chessmate.pieces;

import de.martinclan.chessmate.data.Board;
import de.martinclan.chessmate.data.CapturePerimeter;
import de.martinclan.chessmate.data.Piece;
import de.martinclan.chessmate.data.Vector;

/**
 * Represents a King piece.
 */
public class King extends Piece {
    /**
     * Constructs a King object with the specified board.
     *
     * @param board The board on which the King is placed
     */
    public King(Board board) {
        super(board);
    }

    /**
     * Retrieves the capture perimeter of the King. It can capture any straight and diagonally adjacent field.
     *
     * @return The capture perimeter of the King
     */
    @Override
    public CapturePerimeter getCapturePerimeter() {
        return new CapturePerimeter(
                new Vector(1, 1),
                new Vector(1, 0),
                new Vector(1, -1),
                new Vector(0, 1),
                new Vector(0, -1),
                new Vector(-1, 1),
                new Vector(-1, 0),
                new Vector(-1, -1)
        );
    }
}
