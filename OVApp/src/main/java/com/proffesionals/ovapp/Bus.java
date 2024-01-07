package com.proffesionals.ovapp;

public class Bus extends Edge{
    private int distance;

    float priceConstant = 1.25f;
    float priceVariable = 0.96f;
    float timeVariable = 0.15f;
    
    Bus(Point point1, Point point2, int distance){
        super(point1, point2, distance);
    }

    public float getPrice(){
        return priceConstant + priceVariable * distance;
    }
    public int getTime(){
        return (int) (distance / timeVariable);
    }
    
}
