package de.martinclan.chessmate.pieces;

import de.martinclan.chessmate.data.Board;
import de.martinclan.chessmate.data.CapturePerimeter;
import de.martinclan.chessmate.data.Piece;
import de.martinclan.chessmate.data.Vector;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Represents a Rook piece.
 */
public class Rook extends Piece {
    /**
     * Constructs a Rook object with the specified board.
     *
     * @param board The board on which the Rook is placed
     */
    public Rook(Board board) {
        super(board);
    }

    /**
     * Retrieves the capture perimeter of the Rook. It can capture straight any distance up
     * to the boards edges.
     *
     * @return The capture perimeter of the Rook
     */
    @Override
    public CapturePerimeter getCapturePerimeter() {
        return new CapturePerimeter(Stream.of(
                IntStream.range(1, board.sizeX()).mapToObj(i -> new Vector(i, 0)),
                IntStream.range(1, board.sizeX()).mapToObj(i -> new Vector(-i, 0)),
                IntStream.range(1, board.sizeY()).mapToObj(i -> new Vector(0, i)),
                IntStream.range(1, board.sizeY()).mapToObj(i -> new Vector(0, -i))
        ).flatMap(e -> e));
    }
}
