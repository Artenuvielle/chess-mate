package de.martinclan.chessmate.data;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CapturePerimeterTest {

    @Test
    void at() {
        CapturePerimeter perimeter = new CapturePerimeter(
                new Vector(1, 0), new Vector(0, 1)
        );
        List<Vector> perimeterAt = perimeter.at(new Vector(10, 10));
        assertEquals(2, perimeterAt.size());
        assertTrue(perimeterAt.stream().anyMatch(v -> v.equals(new Vector(11, 10))));
        assertTrue(perimeterAt.stream().anyMatch(v -> v.equals(new Vector(10, 11))));
    }

    @Test
    void intersect() {
        CapturePerimeter perimeter1 = new CapturePerimeter(
                new Vector(1, 0), new Vector(1, 1)
        );
        CapturePerimeter perimeter2 = new CapturePerimeter(
                new Vector(1, 0), new Vector(-1, -1)
        );
        CapturePerimeter perimeterIntersect = perimeter1.intersect(perimeter2);
        List<Vector> perimeterIntersectAt = perimeterIntersect.at(new Vector(0, 0));
        assertEquals(1, perimeterIntersectAt.size());
        assertTrue(perimeterIntersectAt.get(0).equals(new Vector(1, 1)));
    }
}