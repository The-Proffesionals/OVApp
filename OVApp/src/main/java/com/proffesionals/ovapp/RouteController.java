package com.proffesionals.ovapp;

import java.time.LocalTime;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class RouteController {
    @FXML
    private Label route;

    @FXML
    protected void initialize() {
        GraphManipulate graphManipulate = new GraphManipulate();
        Map<Edge, LocalTime> routeInformation = graphManipulate.getRoute(RouteInformation.departureDestination, RouteInformation.arrivalDestination, HelloApplication.graph ,LocalTime.of(RouteInformation.hours, RouteInformation.minutes), RouteInformation.date, RouteInformation.departureorarrival);
        route.setText(routeInformation.toString());
    }

}