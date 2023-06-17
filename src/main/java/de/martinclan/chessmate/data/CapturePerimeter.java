package de.martinclan.chessmate.data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Represents a capture perimeter of a piece on a chess board.
 */
public class CapturePerimeter {
    private final List<Vector> vectors;

    /**
     * Constructs a CapturePerimeter object with the given vectors.
     *
     * @param vectors The vectors that define the capture perimeter
     */
    public CapturePerimeter(Vector... vectors) {
        this.vectors = Arrays.stream(vectors).toList();
    }

    /**
     * Constructs a CapturePerimeter object with the vectors from the given stream.
     *
     * @param vectors The stream of vectors that define the capture perimeter
     */
    public CapturePerimeter(Stream<Vector> vectors) {
        this.vectors = vectors.toList();
    }

    /**
     * Returns a list of positions this perimeter includes when a piece it at a given position.
     *
     * @param position The position where a piece is located at
     * @return The list of positions the piece could capture other pieces at
     */
    public List<Vector> at(Vector position) {
        return vectors.stream().map(position::add).toList();
    }

    /**
     * Computes the intersection of this capture perimeter with another capture perimeter. This is
     * the subset of vectors of this perimeter from which another piece's capture perimeter includes
     * this pieces position so that they threaten each other.
     *
     * @param otherPerimeter The other piece's capture perimeter to intersect with
     * @return A new CapturePerimeter object representing subset
     */
    public CapturePerimeter intersect(CapturePerimeter otherPerimeter) {
        return new CapturePerimeter(vectors.stream().filter(vector1 ->
                otherPerimeter.vectors.stream().anyMatch(vector2 -> vector1.add(vector2).isZero())
        ));
    }
}
