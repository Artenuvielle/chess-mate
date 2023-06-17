package de.martinclan.chessmate.pieces;

import de.martinclan.chessmate.data.Board;
import de.martinclan.chessmate.data.CapturePerimeter;
import de.martinclan.chessmate.data.Piece;
import de.martinclan.chessmate.data.Vector;

/**
 * Represents a Knight piece.
 */
public class Knight extends Piece {
    /**
     * Constructs a Knight object with the specified board.
     *
     * @param board The board on which the Knight is placed
     */
    public Knight(Board board) {
        super(board);
    }

    /**
     * Retrieves the capture perimeter of the Knight. It can capture any field which
     * has both:
     *  - a distance of 2 along one axis and
     *  - a distance of 1 along the other axis.
     *
     * @return The capture perimeter of the Knight
     */
    @Override
    public CapturePerimeter getCapturePerimeter() {
        return new CapturePerimeter(
                new Vector(2, 1),
                new Vector(2, -1),
                new Vector(1, 2),
                new Vector(1, -2),
                new Vector(-1, 2),
                new Vector(-1, -2),
                new Vector(-2, 1),
                new Vector(-2, -1)
        );
    }
}
