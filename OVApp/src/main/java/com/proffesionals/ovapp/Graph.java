package com.proffesionals.ovapp;

import java.util.ArrayList;

public class Graph {
    private ArrayList<Edge> edges;
    private ArrayList<Point> points;
    
    Graph(ArrayList<Edge> edges, ArrayList<Point> points){
        this.edges = edges;
        this.points = points;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public Point getPointByName(String name){
        for (Point point : points) {
            if(point.getName().equals(name)){
                return point;
            }
        }
        return null;
    }
}
