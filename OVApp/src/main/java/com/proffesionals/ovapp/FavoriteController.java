package com.proffesionals.ovapp;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

public class FavoriteController extends SceneController {
    public Button Home2;
    public Button Back2;
    @FXML
    private VBox Favorite;

    @FXML
    protected void initialize() {
        if (RouteInformation.favorite.isEmpty()) {
            Favorite.getChildren().add(new Label("Nog geen favorieten"));
        } else {
            for (List<String> favorite : RouteInformation.favorite) {
                HBox f = new HBox();
                Button button = new Button(favorite.get(0) + " -> " + favorite.get(1));
                Button remove = new Button();
                button.setId("GoToRouteInformation");
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
                        getScene(actionEvent);
                        Node Favorite_select = (Node) actionEvent.getSource();
                        setScene("GoToFavorite");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                remove.getStyleClass().add("starklick-button");
                f.getChildren().add(button);
                f.getChildren().add(remove);
                Favorite.getChildren().add(f);
            }
        }
    }

    @FXML
    protected void goToNewScene(ActionEvent actionEvent) throws IOException{
        getScene(actionEvent);
        Node Home = (Node) actionEvent.getSource();
        setScene(Home.getId());
    }


    private void goToRouteInformation(ActionEvent actionEvent, List<String> favorite) throws IOException {
        RouteInformation.departureDestination = favorite.get(0);
        RouteInformation.arrivalDestination = favorite.get(1);
        getScene(actionEvent);
        Node Favorite = (Node) actionEvent.getSource();
        setScene(Favorite.getId());
    }
}
