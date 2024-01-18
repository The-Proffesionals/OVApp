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
    private Label travelHistory;

    @FXML
    protected void initialize() {
        if (RouteInformation.journeyhistory.isEmpty()) {
            History.getChildren().add(new Label(LanguageManager.getText("noTravelHistory")));
        } else {
            int maxJourneysShown = 7;
            for (int i = 0; i < RouteInformation.journeyhistory.size() ; i++) {
                Journey journey = RouteInformation.journeyhistory.get(i);
                String trainOrBus = journey.getbusOrTrain() ? LanguageManager.getText("bus") : LanguageManager.getText("train");
                Button button = new Button(journey.getStart().getPoint().getName() + " -> " + journey.getEnd().getPoint().getName() + " " + journey.getStart().getTime() + " -> "+ journey.getEnd().getTime() + " " + trainOrBus);
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
        FillText();
    }

    @FXML
    protected void goToNewScene(ActionEvent actionEvent) throws IOException{
        getScene(actionEvent);
        Node Home = (Node) actionEvent.getSource();
        setScene(Home.getId());
    }
    
    private void goToRouteInformation(ActionEvent actionEvent, Journey journey) throws IOException {
        RouteInformation.departureDestination = journey.getStart().getPoint().getName();
        RouteInformation.arrivalDestination = journey.getEnd().getPoint().getName();
        RouteInformation.date = journey.getStart().getDate();
        RouteInformation.hours = journey.getStart().getTime().getHour();
        RouteInformation.minutes = journey.getStart().getTime().getMinute();
        RouteInformation.departureorarrival = journey.getDepartureOrArival();

        getScene(actionEvent);
        Node Route_select = (Node) actionEvent.getSource();
        setScene(Route_select.getId());
    }

    public void FillText() {
        travelHistory.setText(LanguageManager.getText("travelHistory"));
    }
}
