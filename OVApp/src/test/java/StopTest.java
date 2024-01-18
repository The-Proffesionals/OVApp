import com.proffesionals.ovapp.Point;
import com.proffesionals.ovapp.Stop;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

public class StopTest {

    @Test
    void testGetDate() {
        // Test the getDate method for Stop
        LocalDate date = LocalDate.of(2023, 1, 1);
        LocalTime time = LocalTime.of(10, 30);
        Point point = new Point("A");
        Stop stop = new Stop(point, time, date);
        assertEquals(date, stop.getDate());
    }

    @Test
    void testGetPoint() {
        // Test the getPoint method for Stop
        LocalDate date = LocalDate.of(2023, 1, 1);
        LocalTime time = LocalTime.of(10, 30);
        Point point = new Point("B"); // Using a different point
        Stop stop = new Stop(point, time, date);
        assertEquals(point, stop.getPoint());
    }

    @Test
    void testGetTime() {
        // Test the getTime method for Stop
        LocalDate date = LocalDate.of(2023, 1, 1);
        LocalTime time = LocalTime.of(15, 45); // Using a different time
        Point point = new Point("C");
        Stop stop = new Stop(point, time, date);
        assertEquals(time, stop.getTime());
    }
}
