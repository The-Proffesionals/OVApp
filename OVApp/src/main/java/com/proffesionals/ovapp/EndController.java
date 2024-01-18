package com.proffesionals.ovapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import java.io.IOException;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

public class EndController extends SceneController {

    @FXML
    private Label date, duration, departureTime, arrivalTime, spoor, spoor2, travelInformation, intermediateStops, money, departureDestination, arrivalDestination;

    @FXML
    protected void initialize() {
        FillText();
    }

    @FXML
    protected void goToNewScene(ActionEvent actionEvent) throws IOException {
        getScene(actionEvent);
        Node Search = (Node) actionEvent.getSource();
        setScene(Search.getId());
    }

    public void FillText() {
        date.setText(DateTimeFormatter.ofPattern("dd-MM-yy").format(RouteInformation.date));
        Duration durations = Duration.between(RouteInformation.currentJourney.getStart().getTime(), RouteInformation.currentJourney.getEnd().getTime());
        duration.setText(String.format("%02d:%02d " + LanguageManager.getText("hour"),  durations.toHours(), durations.toMinutes() % 60));

        departureTime.setText(RouteInformation.currentJourney.getStart().getTime().toString());
        arrivalTime.setText(RouteInformation.currentJourney.getEnd().getTime().toString());

        travelInformation.setText(RouteInformation.currentJourney.getbusOrTrain() ? "Bus 69" : "Intercity");
        intermediateStops.setText(String.valueOf(RouteInformation.currentJourney.getStops().size() - 2) + " " + LanguageManager.getText("intermediateStops"));
        money.setText("€ " + RouteInformation.currentJourney.getPrice());
        departureDestination.setText(RouteInformation.currentJourney.getStart().getPoint().getName());
        arrivalDestination.setText(RouteInformation.currentJourney.getEnd().getPoint().getName());

        if (RouteInformation.currentJourney.getbusOrTrain() == true){
            spoor.setText(LanguageManager.getText("stop"));
            spoor2.setText(LanguageManager.getText("stop"));
        }
        else{
            spoor.setText(LanguageManager.getText("spoor"));
            spoor2.setText(LanguageManager.getText("spoor"));
        }
    }
}
