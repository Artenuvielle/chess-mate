package de.martinclan.chessmate;

import de.martinclan.chessmate.data.Board;
import de.martinclan.chessmate.data.Piece;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnalysisTest {

    @Test
    void calculateResults() {
        Board board = new Board(3, 3);

        PieceFactory pieceFactory = new PieceFactory(board);
        Piece piece1 = pieceFactory.createPiece("Knight");
        Piece piece2 = pieceFactory.createPiece("Knight");
        Piece piece3 = pieceFactory.createPiece("Queen");
        Piece piece4 = pieceFactory.createPiece("Bishop");

        Analysis analysis1 = new Analysis(board, piece1, piece2);
        List<Analysis.Result> results1 = analysis1.calculateResults();
        assertEquals(16, results1.size());

        Analysis analysis2 = new Analysis(board, piece1, piece3);
        List<Analysis.Result> results2 = analysis2.calculateResults();
        assertEquals(0, results2.size());

        Analysis analysis3 = new Analysis(board, piece3, piece4);
        List<Analysis.Result> results3 = analysis3.calculateResults();
        assertEquals(20, results3.size());
    }
}