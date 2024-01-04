package com.proffesionals.ovapp;

import java.time.LocalDateTime;

public class Journey {
    private String departure;
    private String arrival;
    private LocalDateTime dateTime;

    public Journey(String departure, String arrival, LocalDateTime dateTime) {
        this.departure = departure;
        this.arrival = arrival;
        this.dateTime = dateTime;
    }

    // Getters and setters
    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}


