package de.martinclan.chessmate.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void containsPosition() {
        Board board = new Board(10, 1);
        assertTrue(board.containsPosition(new Vector(9, 0)));
        assertFalse(board.containsPosition(new Vector(9, 1)));
    }
}