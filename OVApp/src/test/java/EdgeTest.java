import com.proffesionals.ovapp.Edge;
import com.proffesionals.ovapp.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EdgeTest {
    private Point point1;
    private Point point2;

    @BeforeEach
    void setUp() {
        // You may initialize the points before each test if needed
        point1 = new Point("A");
        point2 = new Point("B");
    }

    @Test
    void testEdgeConstructor() {
        Edge edge = new Edge(point1, point2, 10);

        assertNotNull(edge, "Edge should not be null");
        assertEquals(point1, edge.getPoint1(), "Point1 should be equal to the initialized point");
        assertEquals(point2, edge.getPoint2(), "Point2 should be equal to the initialized point");
        assertEquals(10, edge.getDistance(), "Distance should be equal to the initialized value");
    }

    @Test
    void testGetPoint1() {
        Edge edge = new Edge(point1, point2, 10);
        assertEquals(point1, edge.getPoint1(), "getPoint1 should return the correct point");
    }

    @Test
    void testGetPoint2() {
        Edge edge = new Edge(point1, point2, 10);
        assertEquals(point2, edge.getPoint2(), "getPoint2 should return the correct point");
    }

    @Test
    void testGetDistance() {
        Edge edge = new Edge(point1, point2, 10);
        assertEquals(10, edge.getDistance(), "getDistance should return the correct distance");
    }

    @Test
    void testGetPrice() {
        Edge edge = new Edge(point1, point2, 10);
        assertEquals(0, edge.getPrice(), "getPrice should return 0");
    }

    @Test
    void testGetTime() {
        Edge edge = new Edge(point1, point2, 10);
        assertEquals(0, edge.getTime(), "getTime should return 0");
    }
}

