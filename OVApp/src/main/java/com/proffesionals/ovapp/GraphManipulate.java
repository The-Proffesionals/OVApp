package com.proffesionals.ovapp;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class GraphManipulate { // class for manipulating the graph
    public List<Journey> getRoute(String departureString, String arrivalString, Graph graph, LocalTime time, LocalDate Date, Boolean startOrEndTime){ // returns a list of edges that form the route from start to end
        Point departure = getPoint(departureString, graph);
        Point arrival = getPoint(arrivalString, graph);
        List<Journey> returnJourneys = new ArrayList<>();

        for ( int i = 0; i < 2; i++){
            Journey trainJourney = makeJourney(departure, arrival, time.plusMinutes(5 + i * 15) , startOrEndTime, graph, true);
            returnJourneys.add(trainJourney);
            Journey busJourney = makeJourney(departure, arrival, time.plusMinutes(5 + i * 15), startOrEndTime, graph, false);
            returnJourneys.add(busJourney);

        }

        return returnJourneys;
    }

    private Journey makeJourney(Point departure, Point arrival, LocalTime currentTime, Boolean startOrEndTime, Graph graph, Boolean BusOrTrain){
        Journey journey = new Journey(BusOrTrain);
        Integer startIndex = getPointIndex(departure, graph);
        Integer endIndex = getPointIndex(arrival, graph);
        LocalTime newTime = currentTime;
        if (startIndex < endIndex) {
            for (int i = startIndex; i < endIndex; i++) {
                Edge edge = graph.getEdges().get(i);
                journey.addStop(new Stop(edge.getPoint1(), newTime));
                if (BusOrTrain){
                    
                    Bus bus = new Bus(edge);
                    newTime = newTime.plusMinutes(bus.getTime());
                } else {
                    Train train = new Train(edge);
                    newTime = newTime.plusMinutes(train.getTime());
                }
            }
        } else {
            for (int i = startIndex; i > endIndex; i--) {
                Edge edge = graph.getEdges().get(i);
                journey.addStop(new Stop(edge.getPoint1(), newTime));
                if (BusOrTrain){
                    Bus bus = new Bus(edge);
                    newTime = newTime.minusMinutes(bus.getTime());
                } else {
                    Train train = new Train(edge);
                    newTime = newTime.minusMinutes(train.getTime());
                }
            }
        }

        return journey;
    }


    private Integer getPointIndex(Point point, Graph graph){ // returns the index of a point in the graph
        for (int i = 0; i < graph.getPoints().size(); i++) {
            if(graph.getPoints().get(i).equals(point)){
                return i;
            }
        }
        return null;
    }

    private Point getPoint(String name, Graph graph){ // returns the point with the given name
        for (Point point : graph.getPoints()) {
            if(point.getName().equals(name)){
                return point;
            }
        }
        return null;
    }

}
