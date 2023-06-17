package de.martinclan.chessmate.pieces;

import de.martinclan.chessmate.data.Board;
import de.martinclan.chessmate.data.CapturePerimeter;
import de.martinclan.chessmate.data.Piece;
import de.martinclan.chessmate.data.Vector;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Represents a Queen piece.
 */
public class Queen extends Piece {
    /**
     * Constructs a Queen object with the specified board.
     *
     * @param board The board on which the Queen is placed
     */
    public Queen(Board board) {
        super(board);
    }

    /**
     * Retrieves the capture perimeter of the Queen. It can capture diagonally or straight any
     * distance up to the boards edges.
     *
     * @return The capture perimeter of the Queen
     */
    @Override
    public CapturePerimeter getCapturePerimeter() {
        int fieldsInDiagonal = board.sizeX() < board.sizeY() ? board.sizeX() : board.sizeY();
        return new CapturePerimeter(Stream.of(
                IntStream.range(1, fieldsInDiagonal).mapToObj(i -> new Vector(i, i)),
                IntStream.range(1, fieldsInDiagonal).mapToObj(i -> new Vector(i, -i)),
                IntStream.range(1, fieldsInDiagonal).mapToObj(i -> new Vector(-i, i)),
                IntStream.range(1, fieldsInDiagonal).mapToObj(i -> new Vector(-i, -i)),
                IntStream.range(1, board.sizeX()).mapToObj(i -> new Vector(i, 0)),
                IntStream.range(1, board.sizeX()).mapToObj(i -> new Vector(-i, 0)),
                IntStream.range(1, board.sizeY()).mapToObj(i -> new Vector(0, i)),
                IntStream.range(1, board.sizeY()).mapToObj(i -> new Vector(0, -i))
        ).flatMap(e -> e));
    }
}
