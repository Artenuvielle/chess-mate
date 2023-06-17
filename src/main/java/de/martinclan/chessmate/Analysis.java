package de.martinclan.chessmate;

import de.martinclan.chessmate.data.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Class for analyzing all positions (results) two given pieces can have on a chess board with
 * both threatening to capture each other.
 */
public class Analysis {
    private final Board board;
    private final Piece piece1;
    private final Piece piece2;

    private final CapturePerimeter intersectedPerimeter;

    /**
     * Represents a result of the analysis, including the positions and references of the pieces involved.
     *
     * @param piece1Position The position where the first piece is placed
     * @param piece2Position The position where the second piece is placed
     * @param piece1         The first placed piece
     * @param piece2         The second placed piece
     * @param board          The board where both pieces are on
     */
    public record Result(Vector piece1Position, Vector piece2Position, Piece piece1, Piece piece2, Board board) {
        /**
         * Returns a string representation of the result.
         *
         * @return A string representation of the result in the format "Result: Piece1 (x, y) - Piece2 (x, y)"
         */
        @Override
        public String toString() {
            String piece1Name = piece1.getClass().getSimpleName();
            String piece2Name = piece2.getClass().getSimpleName();
            if (piece1Name.equals(piece2Name)) {
                piece1Name += " 1";
                piece2Name += " 2";
            }
            return "Result: " +
                    piece1Name + " " + piece1Position.toString() + " - " +
                    piece2Name + " " + piece2Position.toString();
        }

        /**
         * Return a string containing ASCII symbols which form a visual representation of this result.
         *
         * @return A string representation of the result
         */
        public String drawBoard() {
            String boardRepresentation = "   " + IntStream.range(0, board.sizeY()).mapToObj(colIndex ->
                    colIndex + " "
            ).collect(Collectors.joining()) + "\n" + IntStream.range(0, board.sizeX()).mapToObj(rowIndex ->
                    rowIndex + " |" + IntStream.range(0, board.sizeY()).mapToObj(colIndex ->
                            " |"
                    ).collect(Collectors.joining()) + "\n"
            ).collect(Collectors.joining());
            int piece1StringPosition = (4 + 2 * board().sizeY()) * (piece1Position.x() + 1) +
                    3 + 2 * piece1Position.y();
            boardRepresentation = boardRepresentation.substring(0, piece1StringPosition) + "1" +
                    boardRepresentation.substring(piece1StringPosition + 1);
            int piece2StringPosition = (4 + 2 * board().sizeY()) * (piece2Position.x() + 1) +
                    3 + 2 * piece2Position.y();
            boardRepresentation = boardRepresentation.substring(0, piece2StringPosition) + "2" +
                    boardRepresentation.substring(piece2StringPosition + 1);
            return boardRepresentation;
        }
    }

    /**
     * Constructs an Analysis object with the given board and pieces.
     *
     * @param board   The board on which the analysis is performed
     * @param piece1  The first piece
     * @param piece2  The second piece
     */
    public Analysis(Board board, Piece piece1, Piece piece2) {
        this.board = board;
        this.piece1 = piece1;
        this.piece2 = piece2;
        // If the two given pieces are identical (or at least their capture perimeter) and the capture
        // perimeter is point symmetric, we could skip the calculation of the perimeter intersection and
        // only use the original capture perimeter instead.
        this.intersectedPerimeter = piece1.getCapturePerimeter().intersect(piece2.getCapturePerimeter());
    }

    /**
     * Calculates the results of the analysis.
     *
     * @return A list of Result objects representing the analysis results
     */
    public List<Result> calculateResults() {
        List<Result> results = new ArrayList<>();
        for (int x = board.sizeX() - 1; x >= 0; x--) {
            for (int y = board.sizeY() - 1; y >= 0; y--) {
                results.addAll(searchResultsWhenOneAt(new Vector(x, y)));
            }
        }
        return results;
    }

    private List<Result> searchResultsWhenOneAt(Vector piece1Position) {
        return intersectedPerimeter.at(piece1Position).stream().filter(board::containsPosition).map(
                possibleCapturePosition -> new Analysis.Result(
                        piece1Position, possibleCapturePosition, piece1, piece2, board
                )
        ).toList();
    }
}
