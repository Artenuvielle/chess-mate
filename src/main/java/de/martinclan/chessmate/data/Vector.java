package de.martinclan.chessmate.data;

/**
 * Represents a vector with x and y coordinates.
 * @param x The x coordinate
 * @param y The y coordinate
 */
public record Vector(int x, int y) {
    /**
     * Creates a new vector representing the sum of this and another given vector.
     *
     * @param other The vector to add
     * @return A new vector with the added coordinates
     */
    public Vector add(Vector other) {
        return new Vector(this.x + other.x, this.y + other.y);
    }

    /**
     * Checks if this vector is equal to another given vector.
     *
     * @param other The vector to compare this vector to
     * @return True if the vectors are equal, false otherwise
     */
    public boolean equals(Vector other) {
        return x == other.x && y == other.y;
    }

    /**
     * Checks if this vector is a zero vector (both coordinates are zero).
     *
     * @return True if the vector is zero, false otherwise
     */
    public boolean isZero() {
        return x == 0 && y == 0;
    }

    /**
     * Returns a string representation of the vector.
     *
     * @return A string representation of the vector in the format "(x, y)"
     */
    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
