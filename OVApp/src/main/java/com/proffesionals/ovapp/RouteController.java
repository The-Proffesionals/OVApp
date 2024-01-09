package com.proffesionals.ovapp;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class RouteController {
    public Label route;
    @FXML
    private VBox Journeys;
    @FXML
    private Button FavoriteButton;

    @FXML
    protected void initialize() {
        GraphManipulate graphManipulate = new GraphManipulate();
        List<Journey> journeys = graphManipulate.getRoute(RouteInformation.departureDestination, RouteInformation.arrivalDestination, OvApp.graph, LocalTime.of(RouteInformation.hours, RouteInformation.minutes), RouteInformation.date, true);
        for (Journey journey : journeys) {
            Journeys.getChildren().add(new Label(journey.getStart().getPoint().getName() + " -> " + journey.getEnd().getPoint().getName() + " " + journey.getStart().getTime().getHour() + ":"+ journey.getStart().getTime().getMinute() + " -> " + journey.getEnd().getTime().getHour() + ":" + journey.getEnd().getTime().getMinute()));
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