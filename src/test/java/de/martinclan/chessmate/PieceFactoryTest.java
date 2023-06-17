package de.martinclan.chessmate;

import de.martinclan.chessmate.data.Board;
import de.martinclan.chessmate.data.Piece;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceFactoryTest {

    @Test
    void createPiece() {
        PieceFactory pieceFactory = new PieceFactory(new Board(3, 3));
        Piece piece1 = pieceFactory.createPiece("Bishop");
        Piece piece2 = pieceFactory.createPiece("King");
        Piece piece3 = pieceFactory.createPiece("Knight");
        Piece piece4 = pieceFactory.createPiece("Pawn");
        Piece piece5 = pieceFactory.createPiece("Queen");
        Piece piece6 = pieceFactory.createPiece("Rook");
        assertNotNull(piece1);
        assertNotNull(piece2);
        assertNotNull(piece3);
        assertNotNull(piece4);
        assertNotNull(piece5);
        assertNotNull(piece6);
    }
}