package com.proffesionals.ovapp;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

public class RouteController extends SceneController {
    @FXML
    private Label bestOption;
    @FXML
    private VBox GoToEnd;
    @FXML
    private Button FavoriteButton;


    @FXML
    protected void initialize() {
        GraphManipulate graphManipulate = new GraphManipulate();
        List<Journey> journeys = graphManipulate.getRoute(RouteInformation.departureDestination, RouteInformation.arrivalDestination, OvApp.graph, LocalTime.of(RouteInformation.hours, RouteInformation.minutes), RouteInformation.date, RouteInformation.departureorarrival);
        for (Journey journey : journeys) {
            Label route = new Label(journey.getStart().getTime() + " -> " + journey.getEnd().getTime());
            route.getStyleClass().add("label-style-tijd");
            route.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event){
                    try {
                        RouteInformation.currentJourney = journey;
                        goToNewScene(event);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            route.setId("GoToEnd");
            route.setOnMouseClicked(event -> {
                RouteInformation.journeyhistory.add(journey);
                route.fireEvent(new ActionEvent());
            });
            GoToEnd.getChildren().add(route);
        }
        FillText();
    }

    @FXML
    protected void onAddToFavorite() {
        List<List<String>> favoritesList = RouteInformation.favorite;
        if (favoritesList.contains(List.of(RouteInformation.departureDestination, RouteInformation.arrivalDestination))) {
            FavoriteButton.getStyleClass().add("starklick-button");
            FavoriteButton.setDisable(false);
        } else {
            RouteInformation.favorite.add(List.of(RouteInformation.departureDestination, RouteInformation.arrivalDestination));
            FavoriteButton.getStyleClass().add("starklick-button");
            FavoriteButton.setDisable(false);
        }
    }

    @FXML
    protected void goToNewScene(ActionEvent actionEvent) throws IOException {
        getScene(actionEvent);
        Node newScene = (Node) actionEvent.getSource();
        setScene(newScene.getId());
    }

    public void FillText() {
        bestOption.setText(LanguageManager.getText("bestOption"));
    }

}