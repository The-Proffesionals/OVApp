package com.proffesionals.ovapp;

import java.util.List;
import java.util.ArrayList;


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
}

