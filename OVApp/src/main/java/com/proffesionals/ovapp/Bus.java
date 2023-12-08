package com.proffesionals.ovapp;

public class Bus extends Edge {
    private int distance;

    Bus(Point point1, Point point2, int distance, String busNumber, String busType){
        super(point1, point2, distance);
    }

    public float getPrice() {
        float priceRate = 0.15f;
        float priceConstant = 0.89f;
        float price = priceRate * distance + priceConstant;
        return price;
    }

    public float getTime() {
        float speed = 0.5f;
        return speed * distance;
    }

    
}