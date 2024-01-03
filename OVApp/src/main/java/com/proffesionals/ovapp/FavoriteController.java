package com.proffesionals.ovapp;


import javafx.scene.layout.VBox;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.util.List;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.Map;

public class FavoriteController {
    @FXML
    private VBox Favorite;

    @FXML
    protected void initialize() {
        for (List<String> favorite : RouteInformation.favorite) {
            Button button = new Button(favorite.get(0) + " " + favorite.get(1));
            button.setOnAction(actionEvent -> {
                try {
                    goToRouteInformation(actionEvent, favorite);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            Favorite.getChildren().add(button);
        }
    }

    @FXML
    protected void onBackButtonClick(ActionEvent actionEvent) throws IOException{
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
