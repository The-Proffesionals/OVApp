import com.proffesionals.ovapp.Point;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PointTest {

    @Test
    void testGetName() {
        // Test the getName method for Point
        String pointName = "A";
        Point point = new Point(pointName);
        assertEquals(pointName, point.getName());
    }

    @Test
    void testGetNameWithDifferentPoint() {
        // Test the getName method for Point with a different point
        String pointName = "B";
        Point point = new Point(pointName);
        assertEquals(pointName, point.getName());
    }
}
