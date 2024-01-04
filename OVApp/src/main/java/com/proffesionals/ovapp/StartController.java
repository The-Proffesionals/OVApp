package com.proffesionals.ovapp;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import java.io.IOException;

public class StartController {
    @FXML
    protected void onRouteSelect(ActionEvent actionEvent) throws IOException {
        SceneController sceneController = new SceneController(actionEvent);
        sceneController.setScene("routeInformation");

    }

    @FXML
    protected void onFavorite(ActionEvent actionEvent) throws IOException {
        SceneController sceneController = new SceneController(actionEvent);
        sceneController.setScene("favorite");
    }

    @FXML
    protected void onTravelHistory(ActionEvent actionEvent) throws IOException {
        SceneController sceneController = new SceneController(actionEvent);
        sceneController.setScene("TravelHistory");
    }

    @FXML
    protected void onChangeLanguege(){
        System.out.println("Change languege");

    }
}