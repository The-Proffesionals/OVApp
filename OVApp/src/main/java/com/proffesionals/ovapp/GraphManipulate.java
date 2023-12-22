package com.proffesionals.ovapp;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.lang.reflect.Array;
import java.time.LocalDate;

public class GraphManipulate { // class for manipulating the graph

    public Map<Edge, LocalTime> getRoute(String departureString, String arrivalString, Graph graph, LocalTime time, LocalDate Date, Boolean startOrEndTime){ // returns a list of edges that form the route from start to end
        Point departurePoint = graph.getPointByName(departureString);
        Point arrivalPoint = graph.getPointByName(arrivalString);
        int departureIndex = graph.getIndex(departurePoint);
        int arrivalIndex = graph.getIndex(arrivalPoint);

        LocalTime currentTime = time;

        ArrayList<Edge> routeList = getRouteList(departureIndex, arrivalIndex, graph);
        Map<Edge, LocalTime> route = new LinkedHashMap<Edge, LocalTime>();

        if (startOrEndTime) {
            for (Edge edge : routeList) {
                route.put(edge, currentTime);
                currentTime = currentTime.plusMinutes((long) edge.getTime());
            }
        } else {
            for (Edge edge : routeList) {
                currentTime = currentTime.minusMinutes((long) edge.getTime());
                route.put(edge, currentTime);
            }
        }
        return route;
    }

    private ArrayList<Edge> getRouteList(int departureIndex, int arrivalIndex, Graph graph){ // returns a list of edges that form the route from start to end
        List<Edge> edges = graph.getEdges();
        ArrayList<Edge> route = new ArrayList<Edge>();        
        if (departureIndex > arrivalIndex) {
            for (int i = departureIndex; i > arrivalIndex; i--) {
                route.add(edges.get(i));
            }
        } else {
            for (int i = departureIndex; i < arrivalIndex; i++) {
                route.add(edges.get(i));
            }
        }
        return route;
    }

}
