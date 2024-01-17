import com.proffesionals.ovapp.Bus;
import com.proffesionals.ovapp.Edge;
import com.proffesionals.ovapp.Point;
import com.proffesionals.ovapp.Train;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BusTest {

    @Test
    public void testGetPrice() {
        // Create an Edge with a specific distance
        Edge edge = new Edge(new Point(""), new Point(""), 10);

        // Create a Bus based on the Edge
        Bus bus = new Bus(edge);

        // Calculate the expected price based on the distance and price variable
        float expectedPrice = (float) (0.10f * 10.0);

        // Assert that the actual price matches the expected price
        assertEquals(expectedPrice, bus.getPrice(), 0.01); // The third parameter is the delta for floating-point comparisons
    }

    @Test
    public void testGetTime() {
        // Create an Edge with a specific distance
        Edge edge = new Edge(new Point(""), new Point(""), 10);

        // Create a Bus based on the Edge
        Bus bus = new Bus(edge);
        Train train = new Train(edge);

        // Calculate the expected time based on the distance and time variable
        int expectedTime = (int) (10.0 / 0.95f);

        // Assert that the actual time matches the expected time
        assertEquals(expectedTime, bus.getTime());
    }
}
