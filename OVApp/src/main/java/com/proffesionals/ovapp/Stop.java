package com.proffesionals.ovapp;

import java.time.LocalTime;

public class Stop {
    private Point point;
    private LocalTime time;

    public Stop(Point point, LocalTime time) {
        this.point = point;
        this.time = time;
    }

    public Point getPoint() {
        return point;
    }

    public LocalTime getTime() {
        return time;
    }
}
