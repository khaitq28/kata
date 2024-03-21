package manhattanDistance;

/**
 * @author Quang-Khai TRAN
 * @date 22/03/2024
 */


/*
    * This class represents a point in a 2D space.
    * It has two attributes x and y.
    * Class is immutable.
    * No setter methods, no getter methods, no public fields.
 */
public final class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distanceTo(Point point) {
        if (point == null)
            throw new IllegalArgumentException("Point cannot be null");

        return Math.abs(this.x - point.x) + Math.abs(this.y - point.y);
    }

}
