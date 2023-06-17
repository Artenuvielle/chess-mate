package de.martinclan.chessmate.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {

    @Test
    void add() {
        Vector v1 = new Vector(1, 2);
        Vector v2 = new Vector(3, 4);
        Vector v3 = v1.add(v2);
        assertEquals(new Vector(4, 6), v3);
    }

    @Test
    void testEquals() {
        Vector v1 = new Vector(1, 2);
        Vector v2 = new Vector(1, 2);
        assertTrue(v1.equals(v2));
    }

    @Test
    void isZero() {
        Vector v1 = new Vector(0, 0);
        Vector v2 = new Vector(1, 2);
        assertTrue(v1.isZero());
        assertFalse(v2.isZero());
    }
}