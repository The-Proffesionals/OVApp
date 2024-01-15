package com.proffesionals.ovapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.io.IOException;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

public class EndController {

    @FXML
    private Label date;
    @FXML
    private Label duration;
    @FXML
    private Label departureTime;
    @FXML
    private Label arrivalTime;
    @FXML
    private Label spoor;
    @FXML
    private Label spoor2;
    @FXML
    private Label travelInformation;
    @FXML
    private Label intermediateStops;
    @FXML
    private Label money;
    @FXML
    private Label departureDestination;
    @FXML
    private Label arrivalDestination;

    @FXML
    protected void initialize() {
        date.setText(DateTimeFormatter.ofPattern("dd-MM-yy").format(RouteInformation.date));
        Duration durations = Duration.between(RouteInformation.currentJourney.getStart().getTime(), RouteInformation.currentJourney.getEnd().getTime());
        long hours = durations.toHours();
        long minutes = durations.toMinutes() % 60;
        duration.setText(String.format("%02d:%02d uur", hours, minutes));
        departureTime.setText(RouteInformation.currentJourney.getStart().getTime().toString());
        arrivalTime.setText(RouteInformation.currentJourney.getEnd().getTime().toString());
        if (RouteInformation.currentJourney.getbusOrTrain() == true){
            spoor.setText("Halte: 1");
            spoor2.setText("Halte: 1");
        }
        else{
            spoor.setText("Spoor: 1");
            spoor2.setText("Spoor: 1");
        }
        travelInformation.setText(RouteInformation.currentJourney.getbusOrTrain() ? "Bus 69" : "Intercity");
        intermediateStops.setText(String.valueOf(RouteInformation.currentJourney.getStops().size() - 2) + " tussenstop(s)");
        money.setText("€ " + RouteInformation.currentJourney.getPrice());
        departureDestination.setText(RouteInformation.currentJourney.getStart().getPoint().getName());
        arrivalDestination.setText(RouteInformation.currentJourney.getEnd().getPoint().getName());
    }

    @FXML
    protected void onBackButtonClick(ActionEvent actionEvent) throws IOException {
        SceneController sceneController = new SceneController(actionEvent);
        sceneController.setScene("Routes");
    }
    @FXML
    protected void onHomeButtonClick(ActionEvent actionEvent) throws IOException {
        SceneController sceneController = new SceneController(actionEvent);
        sceneController.setScene("Start");
    }
}
