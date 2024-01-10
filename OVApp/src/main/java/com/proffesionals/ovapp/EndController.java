package com.proffesionals.ovapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class EndController {




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


    //lables:
    @FXML
    protected void date() {
    }
    @FXML
    protected void duration(){

    }
    @FXML
    protected void departureTime(){

    }
    @FXML
    protected void arrivalTime(){

    }
    @FXML
    protected void spoor(){

    }
    @FXML
    protected void spoor2(){

    }
    @FXML
    protected void travelInformation(){

    }
    @FXML
    protected void intermediateStops(){

    }
    @FXML
    protected void money(){

    }
    @FXML
    protected void departureDestination(){

    }
    @FXML
    protected void arrivalDestination(){

    }


}
