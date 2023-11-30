package com.proffesionals.ovapp;

import java.util.ArrayList;
import java.util.List;

public class GraphManipulate { // class for manipulating the graph

    public List<Edge> getRoute(Point start, Point end, Graph graph){ // returns a list of edges that form the route from start to end
        List<Edge> route = new ArrayList<>();
        Integer startIndex = getPointIndex(start, graph);
        Integer endIndex = getPointIndex(end, graph);
        if(startIndex == null || endIndex == null){ // if start or end point is not in the graph
            return null;
        } else if (startIndex > endIndex){ // if start point is higher than end point
            for (int i = startIndex; i > endIndex; i--) {
                route.add(graph.getEdgesDown().get(i)); // add edges to route
            }
        } else if (startIndex < endIndex){ // if start point is lower than end point
            for (int i = startIndex; i < endIndex; i++) {
                route.add(graph.getEdgesUp().get(i)); // add edges to route
            }
        }
        return route; // return route
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