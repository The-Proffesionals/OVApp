package com.proffesionals.ovapp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Journey {
    private String departure;
    private String arrival;
    private LocalDateTime dateTime;
    private static List<Journey> journeyHistory = new ArrayList<>();

    // Constructors
    public Journey() {
    }

    public Journey(String departure, String arrival, LocalDateTime dateTime) {
        this.departure = departure;
        this.arrival = arrival;
        this.dateTime = dateTime;
    }

    // Getters and setters
    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public static List<Journey> getJourneyHistory() {
        return journeyHistory;
    }
    public static List<String> getJourneyHistoryDisplayTexts() {
        List<String> displayTexts = new ArrayList<>();
        for (Journey journey : journeyHistory) {
            String displayText = journey.getDeparture() + " to " + journey.getArrival() + " on " + journey.getDateTime();
            displayTexts.add(displayText);
        }
        return displayTexts;
    }
}


