import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RouteCalculatorTest extends TestCase {
    List<Station> route;
    RouteCalculator routeCalculator;
    StationIndex stationIndex;
    List<Station> connections;
    @Override
    protected void setUp() throws Exception {
        route = new ArrayList<>();
        stationIndex = new StationIndex();
        connections = new ArrayList<>();

        Line line1 = new Line(1, "Первая");
        Line line2 = new Line(2, "Вторая");
        Line line3 = new Line(3, "Третья");

        Station station1 = new Station("Петровская" ,line1);
        Station station2 = new Station("Арбузная" ,line1);
        Station station3 = new Station("Морковная" ,line1);
        Station station4 = new Station("Яблочная" ,line2);
        Station station5 = new Station("Ягодная" ,line2);
        Station station6 = new Station("Клубничная" ,line2);
        Station station7 = new Station("Виноградная" ,line3);
        Station station8 = new Station("Вишневая" ,line3);

        line1.addStation(station1);
        line1.addStation(station2);
        line1.addStation(station3);
        line2.addStation(station4);
        line2.addStation(station5);
        line2.addStation(station6);
        line3.addStation(station7);
        line3.addStation(station8);

        route.add(station1);
        route.add(station2);
        route.add(station3);
        route.add(station4);
        route.add(station5);
        route.add(station6);
        route.add(station7);
        route.add(station8);

        stationIndex.addStation(station1);
        stationIndex.addStation(station2);
        stationIndex.addStation(station3);
        stationIndex.addStation(station4);
        stationIndex.addStation(station5);
        stationIndex.addStation(station6);
        stationIndex.addStation(station7);
        stationIndex.addStation(station8);
        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);
        stationIndex.addConnection(Stream.of(station3, station4).collect(Collectors.toList()));
        stationIndex.addConnection(Stream.of(station6, station7).collect(Collectors.toList()));

        routeCalculator = new RouteCalculator(stationIndex);
        super.setUp();
    }

    public void testCalculateDuration()
    {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 19.5;
        assertEquals(expected, actual);
    }
    public void testGetRouteOnTheLine()
    {
        List<Station> actual = routeCalculator.getShortestRoute(route.get(0), route.get(2));
        List<Station> expected = List.of(route.get(0), route.get(1),route.get(2));
        assertEquals(expected, actual);
    }
    public void testGetRouteWithOneConnection()
    {
        List<Station> actual = routeCalculator.getShortestRoute(route.get(1), route.get(4));
        List<Station> expected = List.of(route.get(1), route.get(2), route.get(3), route.get(4));
        assertEquals(expected, actual);

    }
    public void testGetRouteWithTwoConnections()
    {
        List<Station> actual = routeCalculator.getShortestRoute(route.get(0), route.get(7));
        List<Station> expected = List.of(route.get(0),route.get(1),route.get(2), route.get(3),
                route.get(4), route.get(5), route.get(6), route.get(7));
        assertEquals(expected, actual);

    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
