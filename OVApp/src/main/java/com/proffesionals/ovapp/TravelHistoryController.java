package com.proffesionals.ovapp;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;



public class TravelHistoryController extends SceneController {
    public Button Back3;
    public Button Home3;
    @FXML
    private VBox History;

    @FXML
    protected void initialize() {
        if (RouteInformation.journeyhistory.isEmpty()) {
            History.getChildren().add(new Label("Geen reisgeschiedenis"));
        } else {
            int maxJourneysShown = 7;
            for (int i = 0; i < RouteInformation.journeyhistory.size() ; i++) {
                Journey journey = RouteInformation.journeyhistory.get(i);
                Button button = new Button(journey.getStart().getPoint().getName() + " -> " + journey.getEnd().getPoint().getName() + " " + journey.getStart().getTime() + " -> "+ journey.getEnd().getTime() + " " + (journey.getbusOrTrain()? "Bus" : "Train" ));
                button.getStyleClass().add("label-style-History");
                button.setId("GoToRouteInformation");
                button.setOnAction(actionEvent -> {
                    try {
                        goToRouteInformation(actionEvent, journey);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                if (i>= maxJourneysShown){
                    History.getChildren().remove(0);
                }
                History.getChildren().add(button);
            }
        }
    }

    @FXML
    protected void goToNewScene(ActionEvent actionEvent) throws IOException{
        getScene(actionEvent);
        Node Home = (Node) actionEvent.getSource();
        setScene(Home.getId());
    }
    
    private void goToRouteInformation(ActionEvent actionEvent, Journey journey) throws IOException {
        // RouteInformation.departureDestination = journey.getDeparture();
        // RouteInformation.arrivalDestination = journey.getArrival();
        // RouteInformation.date = journey.getDateTime().toLocalDate();
        // RouteInformation.hours = journey.getDateTime().getHour();
        // RouteInformation.minutes = journey.getDateTime().getMinute();
        getScene(actionEvent);
        Node Route_select = (Node) actionEvent.getSource();
        setScene(Route_select.getId());
    }
}
