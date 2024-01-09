package com.proffesionals.ovapp;

public class Train extends Edge{
    float priceConstant = 0.96f;
    float priceVariable = 0.20f;
    float timeVariable = 1.4f;

    Train(Edge edge){
        super(edge.getPoint1(), edge.getPoint2(), edge.getDistance());
    }

    public float getPrice(){
        return priceConstant + priceVariable * getDistance();
    }
    public int getTime(){
        return (int) (getDistance() / timeVariable);
    }
    
}
