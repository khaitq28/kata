package manhattanDistance;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ManhattanTest {

    @ParameterizedTest
    @MethodSource("manhattanDistanceTestSource")
    public void manhattanDistanceTest(int p1x, int p1y, int p2x, int p2y, int result) {
        Point point1 = new Point(p1x, p1y);
        Point point2 = new Point(p2x, p2y);
        assertEquals(result, Manhattan.manhattanDistance(point1, point2));
    }

    private static Stream<Arguments> manhattanDistanceTestSource() {
        return Stream.of(
                Arguments.of(0, 0, 0, 0, 0),
                Arguments.of(0, 0, 0, 1, 1),
                Arguments.of(0, 0, 2, 2, 4),
                Arguments.of(5, 4, 3, 2, 4)
        );
    }

    @Test
    public void manhattanDistanceTestNull() {
        Point point1 = new Point(0, 0);
        assertThrows(IllegalArgumentException.class, () -> Manhattan.manhattanDistance(point1, null));

        try {
            Manhattan.manhattanDistance(point1, null);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Point cannot be null", e.getMessage());
        }
    }

}