package com.proffesionals.ovapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;



public class RouteInformationController implements Initializable {
    @FXML
    private ComboBox<String> DepBox;
    @FXML
    private ComboBox<String> ArrBox;
    @FXML
    private ComboBox<Integer> MinutesBox;
    @FXML
    private ComboBox<Integer> HourBox;
    @FXML
    private DatePicker DatePicker;
    @FXML
    private Button Vertrek;
    @FXML
    private Button Aankomst;
    @FXML
    static ListView<String> journeyHistoryListView;

    private boolean depOrArrTime = true;

    private ObservableList<String> allStations = FXCollections.observableArrayList("Amsterdam Centraal", "Utrecht Centraal", "Rotterdam Centraal", "Den Haag Centraal", "Eindhoven Centraal", "Maastricht Centraal");
    private LocalTime currentTime = LocalTime.now();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrBox.setItems(allStations);
        DepBox.setItems(allStations);

        if (RouteInformation.departureDestination != null && RouteInformation.arrivalDestination != null) {
            ArrBox.setValue(RouteInformation.arrivalDestination);
            DepBox.setValue(RouteInformation.departureDestination);
        } else {
            ArrBox.setValue("Arrival");
            DepBox.setValue("Departure");
        }

        for (int hour = 0; hour < 24; hour++) {
            HourBox.getItems().add(hour);
        }
        HourBox.setValue(currentTime.getHour());
        for (int minutes = 0; minutes <= 60; minutes += 5) {
            MinutesBox.getItems().add(minutes);
        }
        MinutesBox.setValue(currentTime.getMinute());
        DatePicker.setValue(LocalDate.now());

        Vertrek.setStyle("-fx-text-fill: #0A1758;");
    }

    @FXML
    protected void onBackButtonClick(ActionEvent actionEvent) throws IOException {
        SceneController sceneController = new SceneController(actionEvent);
        sceneController.setScene("start");
    }

    @FXML
    protected void onHomeButtonClick(ActionEvent actionEvent) throws IOException {
        SceneController sceneController = new SceneController(actionEvent);
        sceneController.setScene("start");
    }

    @FXML
    protected void onDepartureButtonClick() {
        depOrArrTime = true;
        Vertrek.setStyle("-fx-text-fill: #0A1758;");
        Aankomst.setStyle("-fx-text-fill: #gray;");
    }

    @FXML
    protected void onArrivalButtonClick() {
        depOrArrTime = false;
        Vertrek.setStyle("-fx-text-fill: #gray;");
        Aankomst.setStyle("-fx-text-fill: #0A1758;");
    }

    @FXML
    protected void onSwapButtonClick() {
        String Departure = DepBox.getValue();
        String Arrival = ArrBox.getValue();
        DepBox.setValue(Arrival);
        ArrBox.setValue(Departure);
    }

    @FXML
    protected void onSearchButtonClick(ActionEvent actionEvent) throws IOException {
        if (DepBox.getValue() != null && ArrBox.getValue() != null && DepBox.getValue() != "Departure" && ArrBox.getValue() != "Arrival" && HourBox.getValue() != null && MinutesBox.getValue() != null && DatePicker.getValue() != null) {
            RouteInformation.arrivalDestination = ArrBox.getValue();
            RouteInformation.departureDestination = DepBox.getValue();
            RouteInformation.hours = HourBox.getValue();
            RouteInformation.minutes = MinutesBox.getValue();
            RouteInformation.date = DatePicker.getValue();
            RouteInformation.departureorarrival = depOrArrTime;

            //ADD JOURNEY INFO TO TRAVEL HISTORY
      /*      Journey newJourney = new Journey(DepBox.getValue(), ArrBox.getValue(), LocalDateTime.of(RouteInformation.date, LocalTime.of(RouteInformation.hours, RouteInformation.minutes)));
            Journey.getJourneyHistory().add(newJourney);
            UpdateJourneyHistory();*/

            SceneController sceneController = new SceneController(actionEvent);
            sceneController.setScene("Routes");
        }

    }

    //UPDATE JOURNEY HISTORY IN GUI
    @FXML
    public void UpdateJourneyHistory() {

        List<String> displayTexts = Journey.getJourneyHistoryDisplayTexts();
        if (journeyHistoryListView != null) {
            journeyHistoryListView.setItems(FXCollections.observableArrayList(displayTexts));
        }
    //    journeyHistoryListView.setItems(FXCollections.observableArrayList(displayTexts));
    }


    public Map<Edge, LocalTime> getRoute(){
        GraphManipulate graphManipulate = new GraphManipulate();
        return graphManipulate.getRoute(DepBox.getValue(), ArrBox.getValue(), OvApp.graph, LocalTime.of(HourBox.getValue(), MinutesBox.getValue()), DatePicker.getValue(), depOrArrTime);
    }
}