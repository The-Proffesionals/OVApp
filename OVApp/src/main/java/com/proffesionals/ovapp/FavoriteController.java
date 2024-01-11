package com.proffesionals.ovapp;


import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.List;
import javafx.event.ActionEvent;
import java.io.IOException;

public class FavoriteController {

    @FXML
    private VBox Favorite;

    @FXML
    protected void initialize() {
        if (RouteInformation.favorite.isEmpty()) {
            Favorite.getChildren().add(new Label("Nog geen favorieten"));
        } else {
            for (List<String> favorite : RouteInformation.favorite) {
                HBox f = new HBox();
                Button button = new Button(favorite.get(0) + " " + favorite.get(1));
                Button remove = new Button("X");
                button.setOnAction(actionEvent -> {
                    try {
                        goToRouteInformation(actionEvent, favorite);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                remove.setOnAction(actionEvent -> {
                    RouteInformation.favorite.remove(favorite);
                    try {
                        SceneController sceneController = new SceneController(actionEvent);
                        sceneController.setScene("favorite");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                f.getChildren().add(button);
                f.getChildren().add(remove);
                Favorite.getChildren().add(f);
            }
        }
    }

    @FXML
    protected void onBackButtonClick(ActionEvent actionEvent) throws IOException{
        SceneController sceneController = new SceneController(actionEvent);
        sceneController.setScene("start");
    }


    @FXML
    protected void onHomeButtonClick(ActionEvent actionEvent) throws IOException {
        SceneController sceneController = new SceneController(actionEvent);
        sceneController.setScene("start");
    }

    private void goToRouteInformation(ActionEvent actionEvent, List<String> favorite) throws IOException {
        RouteInformation.departureDestination = favorite.get(0);
        RouteInformation.arrivalDestination = favorite.get(1);
        SceneController sceneController = new SceneController(actionEvent);
        sceneController.setScene("routeInformation");
    }




}
