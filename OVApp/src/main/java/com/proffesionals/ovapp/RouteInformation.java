package com.proffesionals.ovapp;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class RouteInformation {
    public static String arrivalDestination;
    public static String departureDestination;
    public static int hours;
    public static int minutes;
    public static boolean departureorarrival;
    public static LocalDate date;
    public static List<List<String>> favorite = new ArrayList<>();
    public static List<Journey> journeyhistory = new ArrayList<>();
    public static Journey currentJourney;

    public static void clearCurrentJourney() {
        currentJourney = null;
        arrivalDestination = null;
        departureDestination = null;
        hours = -1;
        minutes = -1;
        departureorarrival = true;
        date = null;
    }
}
