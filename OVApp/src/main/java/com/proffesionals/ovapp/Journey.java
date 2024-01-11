package com.proffesionals.ovapp;

import java.util.List;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;



public class Journey {
    private List<Stop> stops;
    private boolean BusOrTrain;

    public Journey(boolean BusOrTrain) {
        this.BusOrTrain = BusOrTrain;
        this.stops = new ArrayList<>();
    }

    public void addStop(Stop stop) {
        stops.add(stop);
    }

    public List<Stop> getStops() {
        return stops;
    }

    public Stop getStart() {
        return stops.get(0);
    }

    public Stop getEnd() {
        return stops.get(stops.size() - 1);
    }

    public boolean getbusOrTrain(){
        return BusOrTrain;
    }

    public Duration getDuration() {
        return Duration.between(getStart().getTime(), getEnd().getTime());
    }
    public String getPrice(){
        Float Price = GraphManipulate.getPrice(this);
        return String.format("%.2f", Price);
    }

    public Journey getReverseJourney(){
        Journey reverseJourney = new Journey(BusOrTrain);
        for (int i = stops.size() - 1; i >= 0; i--){
            reverseJourney.addStop(stops.get(i));
        }
        return reverseJourney;
    }
}


