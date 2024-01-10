package com.proffesionals.ovapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class EndController {

    @FXML
    private Label dateLabel;
    @FXML
    private Label durationLabel;
    @FXML
    private Label departureTimeLabel;
    @FXML
    private Label arrivalTimeLabel;
    @FXML
    private Label spoorLabel;
    @FXML
    private Label spoor2Label;
    @FXML
    private Label travelInformationLabel;
    @FXML
    private Label intermediateStopsLabel;
    @FXML
    private Label moneyLabel;
    @FXML
    private Label departureDestinationLabel;
    @FXML
    private Label arrivalDestinationLabel;

    @FXML
    protected void initialize() {
        dateLabel.setText(RouteInformation.date.toString());
        durationLabel.setText(RouteInformation.currentJourney.getDuration().toString());
        departureTimeLabel.setText(RouteInformation.currentJourney.getStart().getTime().toString());
        arrivalTimeLabel.setText(RouteInformation.currentJourney.getEnd().getTime().toString());
        if (RouteInformation.currentJourney.getbusOrTrain() == true){
            spoorLabel.setText("Spoor: 1");
            spoor2Label.setText("Spoor: 1");        }
        else{
            spoorLabel.setText("Bus: 1");
            spoor2Label.setText("Bus: 1");
        }
        travelInformationLabel.setText(RouteInformation.currentJourney.getStart().getPoint().getName() + " -> " + RouteInformation.currentJourney.getEnd().getPoint().getName());
        
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
