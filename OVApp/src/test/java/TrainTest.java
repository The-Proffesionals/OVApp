import com.proffesionals.ovapp.Edge;
import com.proffesionals.ovapp.Point;
import com.proffesionals.ovapp.Train;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrainTest {

    @Test
    void testGetPrice() {
        // Test the getPrice method for Train
        Edge edge = new Edge(new Point("A"), new Point("B"), 10);
        Train train = new Train(edge);
        float expectedPrice = 0.12f * 10; // priceVariable * distance
        assertEquals(expectedPrice, train.getPrice(), 0.001); // Using delta for floating-point comparison
    }

    @Test
    void testGetTime() {
        // Test the getTime method for Train
        Edge edge = new Edge(new Point("A"), new Point("B"), 12); // Using a different distance
        Train train = new Train(edge);
        int expectedTime = (int) (12 / 1.2f); // distance / timeVariable
        assertEquals(expectedTime, train.getTime());
    }
}
