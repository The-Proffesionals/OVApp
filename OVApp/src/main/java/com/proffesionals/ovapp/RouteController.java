package com.proffesionals.ovapp;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Map;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;


public class RouteController {
    @FXML
    private Label route;
    @FXML
    private Button FavoriteButton;

    @FXML
    protected void initialize() {
        GraphManipulate graphManipulate = new GraphManipulate();
        Map<Edge, LocalTime> routeInformation = graphManipulate.getRoute(RouteInformation.departureDestination, RouteInformation.arrivalDestination, OvApp.graph ,LocalTime.of(RouteInformation.hours, RouteInformation.minutes), RouteInformation.date, RouteInformation.departureorarrival);
        route.setText(RouteInformation.departureDestination + " -> " + RouteInformation.arrivalDestination + "\n");
    }

    @FXML
    protected void onAddToFavorite() {
        RouteInformation.favorite.add(List.of(RouteInformation.departureDestination, RouteInformation.arrivalDestination));
        FavoriteButton.setText("Added to favorite");
        FavoriteButton.setDisable(true);

    }

    @FXML
    protected void onBackButtonClick(ActionEvent actionEvent) throws IOException {
        SceneController sceneController = new SceneController(actionEvent);
        sceneController.setScene("RouteInformation");
    }

    @FXML
    protected void onHomeButtonClick(ActionEvent actionEvent) throws IOException {
        SceneController sceneController = new SceneController(actionEvent);
        sceneController.setScene("start");
    }

}