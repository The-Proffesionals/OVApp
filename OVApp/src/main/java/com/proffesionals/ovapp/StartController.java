package com.proffesionals.ovapp;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import static com.proffesionals.ovapp.RouteInformationController.journeyHistoryListView;

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
    protected void onTravelHistory(){
        ObservableList<String> displayTexts = FXCollections.observableArrayList(Journey.getJourneyHistoryDisplayTexts());
        journeyHistoryListView.setItems(displayTexts);
    }

    @FXML
    protected void onChangeLanguege(){
        System.out.println("Change languege");

    }
}