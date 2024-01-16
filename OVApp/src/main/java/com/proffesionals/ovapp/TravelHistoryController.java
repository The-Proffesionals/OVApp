package com.proffesionals.ovapp;


import javafx.scene.layout.VBox;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.scene.control.Label;



public class TravelHistoryController {
    @FXML
    private VBox History;
    @FXML
    private Label travelHistory;

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
    protected void onBackButtonClick(ActionEvent actionEvent) throws IOException{
        SceneController sceneController = new SceneController(actionEvent);
        sceneController.setScene("start");
    }
    @FXML
    protected void onHomeButtonClick(ActionEvent actionEvent) throws IOException {
        SceneController sceneController = new SceneController(actionEvent);
        sceneController.setScene("start");
    }

    private void goToRouteInformation(ActionEvent actionEvent, Journey journey) throws IOException {
        // RouteInformation.departureDestination = journey.getDeparture();
        // RouteInformation.arrivalDestination = journey.getArrival();
        // RouteInformation.date = journey.getDateTime().toLocalDate();
        // RouteInformation.hours = journey.getDateTime().getHour();
        // RouteInformation.minutes = journey.getDateTime().getMinute();
        SceneController sceneController = new SceneController(actionEvent);
        sceneController.setScene("routeInformation");
    }
    public void FillText() {
        travelHistory.setText(LanguageManager.getText("travelHistory"));
    }
}
