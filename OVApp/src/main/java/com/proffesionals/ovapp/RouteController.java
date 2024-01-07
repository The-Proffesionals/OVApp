package com.proffesionals.ovapp;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class RouteController {
    @FXML
    private VBox journeys;
    @FXML
    private Button FavoriteButton;

    @FXML
    protected void initialize() {
        GraphManipulate graphManipulate = new GraphManipulate();
        List<Journey> routeInformation = graphManipulate.getRoute(RouteInformation.departureDestination, RouteInformation.arrivalDestination, OvApp.graph ,LocalTime.of(RouteInformation.hours, RouteInformation.minutes), RouteInformation.date, RouteInformation.departureorarrival);
        for (Journey journey : routeInformation) {
            Button button = new Button(journey.getStart().getPoint().getName() + " -> " + journey.getEnd().getPoint().getName() + journey.getStart().getTime().toString() + " -> " + journey.getEnd().getTime().toString());
            button.setOnAction(e -> {
                System.out.println("Button clicked = " + button.getText());
            });
            journeys.getChildren().add(button);
        }
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