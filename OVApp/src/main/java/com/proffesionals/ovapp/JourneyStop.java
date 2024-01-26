package com.proffesionals.ovapp;

import java.time.LocalDate;
import java.time.LocalTime;

public class JourneyStop {
    private Point point;
    private LocalTime time;
    private LocalDate date;

    public JourneyStop(Point point, LocalTime time, LocalDate date) {
        this.point = point;
        this.time = time;
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public Point getPoint() {
        return point;
    }

    public LocalTime getTime() {
        return time;
    }
}
