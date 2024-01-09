package com.proffesionals.ovapp;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import java.io.IOException;

public class StartController {
    @FXML
    protected void onRouteSelect(ActionEvent actionEvent) throws IOException {
        SceneController sceneController = new SceneController(actionEvent);
        sceneController.setScene("RouteInformation");

    }

    @FXML
    protected void onFavorite(ActionEvent actionEvent) throws IOException {
        SceneController sceneController = new SceneController(actionEvent);
        sceneController.setScene("Favorite");
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