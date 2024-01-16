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
            History.getChildren().add(new Label(LanguageManager.getText("noTravelHistory")));
        } else {
            int maxJourneysShown = 7;
            for (int i = 0; i < RouteInformation.journeyhistory.size() ; i++) {
                Journey journey = RouteInformation.journeyhistory.get(i);
                String trainOrBus = journey.getbusOrTrain() ? LanguageManager.getText("bus") : LanguageManager.getText("train");
                Button button = new Button(journey.getStart().getPoint().getName() + " -> " + journey.getEnd().getPoint().getName() + " " + journey.getStart().getTime() + " -> "+ journey.getEnd().getTime() + " " + trainOrBus);
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
        RouteInformation.departureDestination = journey.getStart().getPoint().getName();
        RouteInformation.arrivalDestination = journey.getEnd().getPoint().getName();
        RouteInformation.date = journey.getStart().getDate();
        RouteInformation.hours = journey.getStart().getTime().getHour();
        RouteInformation.minutes = journey.getStart().getTime().getMinute();
        SceneController sceneController = new SceneController(actionEvent);
        sceneController.setScene("routeInformation");
    }

    public void FillText() {
        travelHistory.setText(LanguageManager.getText("travelHistory"));
    }
}
