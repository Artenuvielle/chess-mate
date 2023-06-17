package de.martinclan.chessmate.pieces;

import de.martinclan.chessmate.data.Board;
import de.martinclan.chessmate.data.CapturePerimeter;
import de.martinclan.chessmate.data.Piece;
import de.martinclan.chessmate.data.Vector;

/**
 * Represents a Pawn piece.
 */
public class Pawn extends Piece {
    /**
     * Constructs a Pawn object with the specified board.
     *
     * @param board The board on which the Pawn is placed
     */
    public Pawn(Board board) {
        super(board);
    }

    /**
     * Retrieves the capture perimeter of the Pawn. It can capture any diagonally adjacent field.
     *
     * @return The capture perimeter of the Pawn
     */
    @Override
    public CapturePerimeter getCapturePerimeter() {
        return new CapturePerimeter(
                new Vector(1, 1),
                new Vector(1, -1),
                new Vector(-1, 1),
                new Vector(-1, -1)
        );
    }
}
