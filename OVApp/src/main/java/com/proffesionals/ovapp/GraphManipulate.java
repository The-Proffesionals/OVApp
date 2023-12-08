package com.proffesionals.ovapp;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.time.LocalDate;

public class GraphManipulate { // class for manipulating the graph

<<<<<<< HEAD
    public Map<Edge, LocalTime> getRoute(Point start, Point end, Graph graph, LocalTime time, Boolean startOrEndTime){ // returns a list of edges that form the route from start to end
        Map<Edge,LocalTime> returnMap = new LinkedHashMap<>();
        Map<Edge,LocalTime> invertedMap = new LinkedHashMap<>();
=======
    public Map<Edge, LocalTime> getRoute(String departureString, String arrivalString, Graph graph, LocalTime time, LocalDate Date, Boolean startOrEndTime){ // returns a list of edges that form the route from start to end
        Map<Edge,LocalTime> returnMap = new LinkedHashMap();
        Map<Edge,LocalTime> invertedMap = new LinkedHashMap();
>>>>>>> lucas
        List<Edge> route = new ArrayList<>();
        Point departure = getPoint(departureString, graph);
        Point arrival = getPoint(arrivalString, graph);
        Integer startIndex = getPointIndex(departure, graph);
        Integer endIndex = getPointIndex(arrival, graph);

        if(startIndex == null || endIndex == null){ // if start or end point is not in the graph
            return null;
        } else if (startIndex > endIndex){ // if start point is higher than end point
            for (int i = startIndex - 1; i > endIndex; i--) {
                route.add(graph.getEdgesDown().get(i)); // add edges to route
            }
        } else if (startIndex < endIndex){ // if start point is lower than end point
            for (int i = startIndex; i < endIndex; i++) {
                route.add(graph.getEdgesUp().get(i)); // add edges to route
            }
        }

        if(startOrEndTime){ // if start time is given
            for (Edge edge : route) {
                returnMap.put(edge, time); 
                time = addTime(time, edge); // set starttime to the time of arrival at the end point of the edge
            }
        } else { // if end time is given
            time = removeTime(time, route.get(route.size() - 1)); // set starttime to the time of arrival at the end point of the edge
            for (int i = route.size() - 1; i >= 0; i--) {
                invertedMap.put(route.get(i), time); 
                time = removeTime(time, route.get(i)); // set starttime to the time of arrival at the end point of the edge
            }
            returnMap = reverseMap(invertedMap); // reverse the map
        }
        return returnMap; // return route
    }

    private LocalTime addTime(LocalTime time, Edge edge){ // returns the time of arrival at the end point of an edge
        return time.plusMinutes(edge.getDistance());
    }
    private LocalTime removeTime(LocalTime time, Edge edge){ // returns the time of arrival at the start point of an edge
        return time.minusMinutes(edge.getDistance());
    }

    private Integer getPointIndex(Point point, Graph graph){ // returns the index of a point in the graph
        for (int i = 0; i < graph.getPoints().size(); i++) {
            if(graph.getPoints().get(i).equals(point)){
                return i;
            }
        }
        return null;
    }
    private static Map<Edge, LocalTime> reverseMap(Map<Edge, LocalTime> originalMap) {
        // Extract the map entries into a list
        ArrayList<Map.Entry<Edge, LocalTime>> entries = new ArrayList<>(originalMap.entrySet());
        
        // Reverse the list
        Collections.reverse(entries);
        
        // Create a new LinkedHashMap and populate it with the reversed entries
        LinkedHashMap<Edge, LocalTime> reversedMap = new LinkedHashMap<>();
        for (Map.Entry<Edge, LocalTime> entry : entries) {
            reversedMap.put(entry.getKey(), entry.getValue());
        }
        
        return reversedMap;
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