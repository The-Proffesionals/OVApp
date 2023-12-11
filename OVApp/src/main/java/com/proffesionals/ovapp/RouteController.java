package com.proffesionals.ovapp;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class RouteController {
    @FXML
    private Label route;

    @FXML
    protected void initialize() {
        GraphManipulate graphManipulate = new GraphManipulate();
        Map<Edge, LocalTime> routeInformation = graphManipulate.getRoute(RouteInformation.departureDestination, RouteInformation.arrivalDestination, OvApp.graph ,LocalTime.of(RouteInformation.hours, RouteInformation.minutes), RouteInformation.date, RouteInformation.departureorarrival);
        route.setText(RouteInformation.departureDestination + " -> " + RouteInformation.arrivalDestination + "\n");
    }

    @FXML
    protected void onBackButtonClick(ActionEvent actionEvent) throws IOException {
        SceneController sceneController = new SceneController(actionEvent);
        sceneController.setScene("RouteInformation");
    }

}