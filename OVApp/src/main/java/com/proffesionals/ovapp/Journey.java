package com.proffesionals.ovapp;

import java.util.List;

import java.time.Duration;
import java.util.ArrayList;


public class Journey {
    private List<JourneyStop> journeyStops;
    private boolean BusOrTrain;
    private boolean startOrEndTime;

    public Journey(boolean BusOrTrain, boolean startOrEndTime) {
        this.BusOrTrain = BusOrTrain;
        this.startOrEndTime = startOrEndTime;
        this.journeyStops = new ArrayList<>();
    }

    public boolean getDepartureOrArival(){
        return startOrEndTime;
    }

    public void addStop(JourneyStop stop) {
        journeyStops.add(stop);
    }

    public List<JourneyStop> getJourneyStops() {
        return journeyStops;
    }

    public JourneyStop getStart() {
        return journeyStops.get(0);
    }

    public JourneyStop getEnd() {
        return journeyStops.get(journeyStops.size() - 1);
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
        for (int i = journeyStops.size() - 1; i >= 0; i--){
            JourneyStop stop = new JourneyStop(journeyStops.get(journeyStops.size() - 1 - i).getPoint(), journeyStops.get(i).getTime(), journeyStops.get(i).getDate());
            reverseJourney.addStop(stop);
        }
        return reverseJourney;
    }
}


