import com.proffesionals.ovapp.Bus;
import com.proffesionals.ovapp.Edge;
import com.proffesionals.ovapp.Point;
import com.proffesionals.ovapp.Train;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BusTest {
    private Point point1;
    private Point point2;
    private Edge edge;

    @BeforeEach
    public void setUp() {
        // You may initialize the points and edge before each test if needed
        point1 = new Point("A");
        point2 = new Point("B");
        edge = new Edge(point1, point2, 10);
    }

    @Test
    public void testGetPrice() {
        // Create a Bus based on the Edge
        Bus bus = new Bus(edge);

        // Calculate the expected price based on the distance and price variable
        float expectedPrice = (float) (0.10f * 10.0);

        // Assert that the actual price matches the expected price
        assertEquals(expectedPrice, bus.getPrice(), 0.01); // The third parameter is the delta for floating-point comparisons
    }

    @Test
    public void testGetTime() {
        // Create a Bus based on the Edge
        Bus bus = new Bus(edge);
        Train train = new Train(edge);

        // Calculate the expected time based on the distance and time variable
        int expectedTime = (int) (10.0 / 0.95f);

        // Assert that the actual time matches the expected time
        assertEquals(expectedTime, bus.getTime());
    }
    @Test
    void testBusConstructor() {
        Bus bus = new Bus(edge);

        assertNotNull(bus, "Bus should not be null");
        assertEquals(point1, bus.getPoint1(), "Point1 should be equal to the initialized point");
        assertEquals(point2, bus.getPoint2(), "Point2 should be equal to the initialized point");
        assertEquals(10, bus.getDistance(), "Distance should be equal to the initialized value");
    }

    @Test
    void testNullEdge() {
        assertThrows(NullPointerException.class, () -> {
            new Bus(null);
        }, "Null Edge should throw a NullPointerException");
    }
}

