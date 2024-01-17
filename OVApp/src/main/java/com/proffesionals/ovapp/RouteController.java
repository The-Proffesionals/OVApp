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
    public Button Back4;
    public Button Home4;
    @FXML
    private Label route;
    @FXML
    private VBox Journeys;
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
                        goToEnd(event);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            route.setOnMouseClicked(event -> {
                RouteInformation.journeyhistory.add(journey);
                route.fireEvent(new ActionEvent());
            });
            Journeys.getChildren().add(route);
        }
    }

    @FXML
    protected void onAddToFavorite() {
        List<List<String>> favoritesList = RouteInformation.favorite;
        if (favoritesList.contains(List.of(RouteInformation.departureDestination, RouteInformation.arrivalDestination))) {
            FavoriteButton.getStyleClass().add("starklick-button");
            FavoriteButton.setDisable(true);
        } else {
            RouteInformation.favorite.add(List.of(RouteInformation.departureDestination, RouteInformation.arrivalDestination));
            FavoriteButton.getStyleClass().add("starklick-button");
            FavoriteButton.setDisable(true);
        }

    }

    @FXML
    protected void onBackButtonClick(ActionEvent actionEvent) throws IOException {
        getScene(actionEvent);
        Node Route_select = (Node) actionEvent.getSource();
        setScene(Route_select.getId());
    }

    @FXML
    protected void onHomeButtonClick(ActionEvent actionEvent) throws IOException {
        getScene(actionEvent);
        Node Home = (Node) actionEvent.getSource();
        setScene(Home.getId());
    }

    private void goToEnd(ActionEvent actionEvent) throws IOException {
        getScene(actionEvent);
        Node Journeys = (Node) actionEvent.getSource();
        setScene(Journeys.getId());
    }
}