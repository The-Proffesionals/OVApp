import com.proffesionals.ovapp.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static com.proffesionals.ovapp.GraphManipulate.getPrice;
import static org.junit.jupiter.api.Assertions.*;

public class GraphManipulateTest {
    private GraphManipulate graphManipulate;
    private Graph graph;

    @BeforeEach
    void setUp() {
        // Initialize GraphManipulate object and a sample Graph
        ArrayList<Edge> edges = new ArrayList<>();
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point("A"));
        points.add(new Point("B"));
        points.add(new Point("C"));
        edges.add(new Edge(new Point("A"), new Point("B"), 10));
        edges.add(new Edge(new Point("B"), new Point("C"), 10));
        graph = new Graph(edges, points);
        graphManipulate = new GraphManipulate();
        }
    @Test
    void testGetRouteNormal() {
        // Test getRoute under normal conditions
        LocalTime time = LocalTime.of(10, 0);
        LocalDate date = LocalDate.of(2023, 1, 1);
        ArrayList<Journey> route = (ArrayList<Journey>) graphManipulate.getRoute("A", "B", graph, time, date, true);
        assertFalse(route.isEmpty());
        route = (ArrayList<Journey>) graphManipulate.getRoute("B", "C", graph, time, date, true);
        assertFalse(route.isEmpty());
        route = (ArrayList<Journey>) graphManipulate.getRoute("A", "C", graph, time, date, true);
        assertFalse(route.isEmpty());
        // Additional checks can be added here based on the expected behavior
        }

    @Test
    void testGetRouteWithNullInputs() {
        // Test getRoute with null inputs
        assertThrows(NullPointerException.class, () -> {
            graphManipulate.getRoute(null, null, null, null, null, null);
        });
    }

    @Test
    void testGetRouteWithEmptyGraph() {
        // Test getRoute with an empty graph
        LocalTime time = LocalTime.of(10, 0);
        LocalDate date = LocalDate.of(2023, 1, 1);
        Graph emptyGraph = new Graph(new ArrayList<>(), new ArrayList<>());
        List<Journey> route = graphManipulate.getRoute("", "", emptyGraph, time, date, true);
        assertFalse(route.isEmpty());
    }
    @Test
    void testGetRouteOnDifferentDays() {
        // Test getRoute on different days
        LocalTime time = LocalTime.of(10, 0);
        List<Journey> todayRoute = graphManipulate.getRoute("A", "B", graph, time, LocalDate.now(), true);
        List<Journey> tomorrowRoute = graphManipulate.getRoute("A", "B", graph, time, LocalDate.now().plusDays(1), true);
        assertNotEquals(todayRoute, tomorrowRoute);
    }
    @Test
    void testGetRouteWithVariousTimesAndDates() {
        // Test case 1: Early morning time
        List<Journey> earlyMorningRoute = graphManipulate.getRoute("A", "B", graph, LocalTime.of(5, 0), LocalDate.now(), true);
        assertNotNull(earlyMorningRoute);

        // Test case 2: Late night time
        List<Journey> lateNightRoute = graphManipulate.getRoute("A", "B", graph, LocalTime.of(23, 0), LocalDate.now(), true);
        assertNotNull(lateNightRoute);

        // Test case 3: Different dates
        List<Journey> differentDateRoute = graphManipulate.getRoute("A", "B", graph, LocalTime.of(10, 0), LocalDate.now().plusDays(10), true);
        assertNotNull(differentDateRoute);
    }

    @Test
    void testGetPriceWithInvalidJourney() {
        // Test getPrice with an invalid journey
        Journey journey = null;
        assertThrows(NullPointerException.class, () -> {
            getPrice(journey);
        });
    }


}


