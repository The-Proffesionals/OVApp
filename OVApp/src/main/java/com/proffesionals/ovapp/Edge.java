package com.proffesionals.ovapp;


public class Edge {
    private Point point1;
    private Point point2;
    private int distance;
    
    public Edge(Point point1, Point point2, int distance){
        this.point1 = point1;
        this.point2 = point2;
        this.distance = distance;

    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }
    public float getPrice(){
        return 0;
    }
    public int getTime(){
        return 0;
    }
    public int getDistance() {
        return distance;
    }
}
