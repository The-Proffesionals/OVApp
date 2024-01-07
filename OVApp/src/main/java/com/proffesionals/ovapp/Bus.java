package com.proffesionals.ovapp;

public class Bus extends Edge{
    float priceConstant = 1.25f;
    float priceVariable = 0.96f;
    float timeVariable = 0.95f;
    
    Bus(Edge edge){
        super(edge.getPoint1(), edge.getPoint2(), edge.getDistance());
    }

    public float getPrice(){
        return priceConstant + priceVariable * getDistance();
    }
    public int getTime(){
        return (int) (getDistance() / timeVariable);
    }
    
}
