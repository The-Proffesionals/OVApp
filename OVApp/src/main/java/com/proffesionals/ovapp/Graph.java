package com.proffesionals.ovapp;

import java.util.ArrayList;

public class Graph {
    private ArrayList<Edge> edgesUp;
    private ArrayList<Edge> edgesDown;
    private ArrayList<Point> points;
    
    Graph(ArrayList<Edge> edgesUp, ArrayList<Edge> edgesDown, ArrayList<Point> points){
        this.edgesDown = edgesDown;
        this.edgesUp = edgesUp;
        this.points = points;
    }

    public ArrayList<Edge> getEdgesUp() {
        return edgesUp;
    }

    public ArrayList<Edge> getEdgesDown() {
        return edgesDown;
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
