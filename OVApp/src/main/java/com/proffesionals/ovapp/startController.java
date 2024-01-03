package com.proffesionals.ovapp;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import java.io.IOException;

public class startController {
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
    protected void onTravelHistory(){
        System.out.println("Travel history");
        
    }

    @FXML
    protected void onChangeLanguege(){
        System.out.println("Change languege");

    }


}