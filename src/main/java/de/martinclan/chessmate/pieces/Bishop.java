package de.martinclan.chessmate.pieces;

import de.martinclan.chessmate.data.Board;
import de.martinclan.chessmate.data.CapturePerimeter;
import de.martinclan.chessmate.data.Piece;
import de.martinclan.chessmate.data.Vector;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Represents a Bishop piece.
 */
public class Bishop extends Piece {
    /**
     * Constructs a Bishop object with the specified board.
     *
     * @param board The board on which the Bishop is placed
     */
    public Bishop(Board board) {
        super(board);
    }

    /**
     * Retrieves the capture perimeter of the Bishop. It can capture diagonally any distance up
     * to the boards edges.
     *
     * @return The capture perimeter of the Bishop
     */
    @Override
    public CapturePerimeter getCapturePerimeter() {
        int fieldsInDiagonal = board.sizeX() < board.sizeY() ? board.sizeX() : board.sizeY();
        return new CapturePerimeter(Stream.of(
                IntStream.range(1, fieldsInDiagonal).mapToObj(i -> new Vector(i, i)),
                IntStream.range(1, fieldsInDiagonal).mapToObj(i -> new Vector(i, -i)),
                IntStream.range(1, fieldsInDiagonal).mapToObj(i -> new Vector(-i, i)),
                IntStream.range(1, fieldsInDiagonal).mapToObj(i -> new Vector(-i, -i))
        ).flatMap(e -> e));
    }
}
