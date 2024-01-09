package com.proffesionals.ovapp;


import javafx.scene.layout.VBox;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.scene.control.Label;

public class TravelHistoryController {
    @FXML
    private VBox History;

    @FXML
    protected void initialize() {
        if (RouteInformation.journeyhistory.isEmpty()) {
            History.getChildren().add(new Label("No history"));
        } else{ 
            for (Journey journey : RouteInformation.journeyhistory) {
                Button button = new Button(journey.getStart() + " -> " + journey.getStops());
                button.setOnAction(actionEvent -> {
                    try {
                        goToRouteInformation(actionEvent, journey);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                History.getChildren().add(button);
            }
        }
    }

    @FXML
    protected void onBackButtonClick(ActionEvent actionEvent) throws IOException{
        SceneController sceneController = new SceneController(actionEvent);
        sceneController.setScene("start");
    }

    private void goToRouteInformation(ActionEvent actionEvent, Journey journey) throws IOException {
        // RouteInformation.departureDestination = journey.getDeparture();
        // RouteInformation.arrivalDestination = journey.getArrival();
        // RouteInformation.date = journey.getDateTime().toLocalDate();
        // RouteInformation.hours = journey.getDateTime().getHour();
        // RouteInformation.minutes = journey.getDateTime().getMinute();
        SceneController sceneController = new SceneController(actionEvent);
        sceneController.setScene("routeInformation");
    }
}