package com.proffesionals.ovapp;

import java.util.List;

import java.time.Duration;
import java.util.ArrayList;


public class Journey {
    private List<Stop> stops;
    private boolean BusOrTrain;
    private boolean startOrEndTime;

    public Journey(boolean BusOrTrain, boolean startOrEndTime) {
        this.BusOrTrain = BusOrTrain;
        this.startOrEndTime = startOrEndTime;
        this.stops = new ArrayList<>();
    }

    public boolean getDepartureOrArival(){
        return startOrEndTime;
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
        Journey reverseJourney = new Journey(BusOrTrain, startOrEndTime);
        for (int i = stops.size() - 1; i >= 0; i--){
            Stop stop = new Stop(stops.get(stops.size() - 1 - i).getPoint(), stops.get(i).getTime(), stops.get(i).getDate());
            reverseJourney.addStop(stop);
        }
        return reverseJourney;
    }
}


