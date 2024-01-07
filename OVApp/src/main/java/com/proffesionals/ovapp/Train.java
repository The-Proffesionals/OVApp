package com.proffesionals.ovapp;

public class Train extends Edge{
    private int distance;

    float priceConstant = 0.96f;
    float priceVariable = 0.20f;
    float timeVariable = 1.4f;
    
    Train(Point point1, Point point2, int distance){
        super(point1, point2, distance);
    }

    public float getPrice(){
        return priceConstant + priceVariable * distance;
    }
    public int getTime(){
        return (int) (distance / timeVariable);
    }
    
}
