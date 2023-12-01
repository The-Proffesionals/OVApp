package com.proffesionals.ovapp;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

public class GraphManipulate { // class for manipulating the graph

    public Map<Edge, LocalTime> getRoute(Point start, Point end, Graph graph, LocalTime starttime){ // returns a list of edges that form the route from start to end
        Map<Edge,LocalTime> returnMap = new LinkedHashMap();
        List<Edge> route = new ArrayList<>();
       Integer startIndex = getPointIndex(start, graph);
        Integer endIndex = getPointIndex(end, graph);
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
        for (Edge edge : route) {
            returnMap.put(edge, getTime(starttime, edge)); 
            starttime = getTime(starttime, edge); // set starttime to the time of arrival at the end point of the edge
        }
        return returnMap; // return route
    }

    private LocalTime getTime(LocalTime time, Edge edge){ // returns the time of arrival at the end point of an edge
        return time.plusMinutes(edge.getDistance());
    }

    private Integer getPointIndex(Point point, Graph graph){ // returns the index of a point in the graph
        for (int i = 0; i < graph.getPoints().size(); i++) {
            if(graph.getPoints().get(i).equals(point)){
                return i;
            }
        }
        return null;
    }
}