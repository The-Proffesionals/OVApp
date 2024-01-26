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
            if (startOrEndTime){
                Journey trainJourney = makeJourney(departure, arrival, time.plusMinutes(5 + i * 15) , startOrEndTime, graph, false);
                returnJourneys.add(trainJourney);
                Journey busJourney = makeJourney(departure, arrival, time.plusMinutes(5 + i * 15), startOrEndTime, graph, true);
                returnJourneys.add(busJourney);
            } else {
                Journey trainJourney = makeJourney(departure, arrival, time.minusMinutes(20 - i * 5) , startOrEndTime, graph, false);
                returnJourneys.add(trainJourney);
                Journey busJourney = makeJourney(departure, arrival, time.minusMinutes(20 - i * 5), startOrEndTime, graph, true);
                returnJourneys.add(busJourney);
            }
        }

        return returnJourneys;
    }

    private Journey makeJourney(Point departure, Point arrival, LocalTime currentTime, Boolean startOrEndTime, Graph graph, Boolean BusOrTrain){
        Journey journey = new Journey(BusOrTrain, startOrEndTime);
        Integer startIndex = getPointIndex(departure, graph);
        Integer endIndex = getPointIndex(arrival, graph);
        LocalTime newTime = currentTime;
        if (startOrEndTime){
            if (startIndex < endIndex) {
                Edge edge = graph.getEdges().get(startIndex);
                journey.addStop(new JourneyStop(edge.getPoint1(), newTime, RouteInformation.date));
                for (int i = startIndex; i < endIndex; i++) {
                    if (BusOrTrain){
                        Bus bus = new Bus(edge);
                        newTime = newTime.plusMinutes(bus.getTime());
                    } else {
                        Train train = new Train(edge);
                        newTime = newTime.plusMinutes(train.getTime());
                    }
                    edge = graph.getEdges().get(i);
                    journey.addStop(new JourneyStop(edge.getPoint2(), newTime, RouteInformation.date));
                }

            } else {
                for (int i = startIndex - 1; i > endIndex - 1; i--) {
                    Edge edge = graph.getEdges().get(i);
                    journey.addStop(new JourneyStop(edge.getPoint2(), newTime, RouteInformation.date));
                    if (BusOrTrain){
                        Bus bus = new Bus(edge);
                        newTime = newTime.plusMinutes(bus.getTime());
                    } else {
                        Train train = new Train(edge);
                        newTime = newTime.plusMinutes(train.getTime());
                    }
                }
                Edge edge = graph.getEdges().get(endIndex);
                journey.addStop(new JourneyStop(edge.getPoint1(), newTime, RouteInformation.date));
            }
        } else {
            if (startIndex < endIndex) {
                Edge edge = graph.getEdges().get(startIndex);
                journey.addStop(new JourneyStop(edge.getPoint1(), newTime, RouteInformation.date));
                for (int i = startIndex; i < endIndex; i++) {
                    if (BusOrTrain){
                        Bus bus = new Bus(edge);
                        newTime = newTime.minusMinutes(bus.getTime());
                    } else {
                        Train train = new Train(edge);
                        newTime = newTime.minusMinutes(train.getTime());
                    }
                    edge = graph.getEdges().get(i);
                    journey.addStop(new JourneyStop(edge.getPoint2(), newTime, RouteInformation.date));
                }

            } else {
                for (int i = startIndex - 1; i > endIndex - 1; i--) {
                    Edge edge = graph.getEdges().get(i);
                    journey.addStop(new JourneyStop(edge.getPoint2(), newTime, RouteInformation.date));
                    if (BusOrTrain){
                        Bus bus = new Bus(edge);
                        newTime = newTime.minusMinutes(bus.getTime());
                    } else {
                        Train train = new Train(edge);
                        newTime = newTime.minusMinutes(train.getTime());
                    }
                }
                Edge edge = graph.getEdges().get(endIndex);
                journey.addStop(new JourneyStop(edge.getPoint1(), newTime, RouteInformation.date));
            }
            journey = journey.getReverseJourney();
        }
        return journey;
    }


    private static Integer getPointIndex(Point point, Graph graph){ // returns the index of a point in the graph
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

    public static float getPrice(Journey journey){
        Graph graph = OvApp.graph;
        float price = 0;
        Integer startIndex = getPointIndex(journey.getStart().getPoint(), graph);
        Integer endIndex = getPointIndex(journey.getEnd().getPoint(), graph);
        if (startIndex < endIndex) {
            Edge edge = graph.getEdges().get(startIndex);
            for (int i = startIndex; i < endIndex; i++) {
                if (journey.getbusOrTrain()){
                    Bus bus = new Bus(edge);
                    price += bus.getPrice();
                } else {
                    Train train = new Train(edge);
                    price += train.getPrice();
                }
                edge = graph.getEdges().get(i);
            }
            if (journey.getbusOrTrain()) {
                price += 1.25f;
            } else {
                price += 0.96f;
            }
        } else {
            for (int i = startIndex - 1; i > endIndex - 1; i--) {
                Edge edge = graph.getEdges().get(i);
                if (journey.getbusOrTrain()){
                    Bus bus = new Bus(edge);
                    price += bus.getPrice();
                } else {
                    Train train = new Train(edge);
                    price += train.getPrice();
                }
            }
            if (journey.getbusOrTrain()) {
                price += 1.25f;
            } else {
                price += 0.96f;
            }
        }
        return price;
    }
}
