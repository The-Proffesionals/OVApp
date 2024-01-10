package com.proffesionals.ovapp;

public class Train extends Edge{
    float priceVariable = 0.20f;
    float timeVariable = 1.4f;

    Train(Edge edge){
        super(edge.getPoint1(), edge.getPoint2(), edge.getDistance());
    }

    public float getPrice(){
        return priceVariable * getDistance();
    }
    public int getTime(){
        return (int) (getDistance() / timeVariable);
    }
    
}
