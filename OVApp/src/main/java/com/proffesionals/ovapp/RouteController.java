package com.proffesionals.ovapp;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.event.EventHandler;


public class RouteController {
    @FXML
    private Label route;
    public Label bestOption;

    @FXML
    private VBox Journeys;
    @FXML
    private Button FavoriteButton;


    @FXML
    protected void initialize() {
        GraphManipulate graphManipulate = new GraphManipulate();
        List<Journey> journeys = graphManipulate.getRoute(RouteInformation.departureDestination, RouteInformation.arrivalDestination, OvApp.graph, LocalTime.of(RouteInformation.hours, RouteInformation.minutes), RouteInformation.date, RouteInformation.departureorarrival);
        for (Journey journey : journeys) {
            Label label = new Label(journey.getStart().getTime() + " -> " + journey.getEnd().getTime());
            label.getStyleClass().add("label-style-tijd");
            label.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event){
                    try {
                        RouteInformation.currentJourney = journey;
                        goToEnd(event);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            label.setOnMouseClicked(event -> {
                RouteInformation.journeyhistory.add(journey);
                label.fireEvent(new ActionEvent());
            });
            Journeys.getChildren().add(label);
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
    protected void onBackButtonClick(ActionEvent actionEvent) throws IOException {
        SceneController sceneController = new SceneController(actionEvent);
        sceneController.setScene("RouteInformation");
    }

    @FXML
    protected void onHomeButtonClick(ActionEvent actionEvent) throws IOException {
        SceneController sceneController = new SceneController(actionEvent);
        sceneController.setScene("start");
    }

    private void goToEnd(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController(event);
        sceneController.setScene("End");
    }
    public void FillText() {
        bestOption.setText(LanguageManager.getText("bestOption"));
//        Favorite_select.setText(LanguageManager.getText("Favorite_select"));
//        TravelHistory_select.setText(LanguageManager.getText("TravelHistory_select"));
    }
}