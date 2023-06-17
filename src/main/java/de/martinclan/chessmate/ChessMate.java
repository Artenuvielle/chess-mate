package de.martinclan.chessmate;

import de.martinclan.chessmate.data.Board;
import de.martinclan.chessmate.data.Piece;

import java.util.List;

public class ChessMate {
    public static void main(String[] args) {
        Board board = new Board(8, 8);

        PieceFactory pieceFactory = new PieceFactory(board);
        Piece piece1 = pieceFactory.createPiece("Knight");
        Piece piece2 = pieceFactory.createPiece("Knight");

        Analysis analysis = new Analysis(board, piece1, piece2);
        List<Analysis.Result> results = analysis.calculateResults();

        results.forEach(result -> {
            System.out.println(result.toString());
            System.out.println(result.drawBoard());
        });
        System.out.println("Found " + results.size() + " results");
    }
}
