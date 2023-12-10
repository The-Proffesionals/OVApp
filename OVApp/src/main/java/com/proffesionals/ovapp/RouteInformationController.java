package com.proffesionals.ovapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;
import java.time.LocalTime;
import java.io.IOException;
import java.net.URL;
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

    private boolean depOrArrTime = true;

    private ObservableList<String> allStations = FXCollections.observableArrayList("Amsterdam Centraal", "Utrecht Centraal", "Rotterdam Centraal", "Den Haag Centraal", "Eindhoven Centraal", "Maastricht Centraal");
    private LocalTime currentTime = LocalTime.now();


    @Override
    public void initialize(URL location, ResourceBundle resources){
        ArrBox.setItems(allStations);
        ArrBox.setValue("Arrival");
        DepBox.setItems(allStations);
        DepBox.setValue("Departure");
        for (int hour = 0; hour < 24 ; hour++){
            HourBox.getItems().add(hour);
        }
        HourBox.setValue(currentTime.getHour());
        for (int minutes = 0; minutes <= 60 ; minutes += 5){
            MinutesBox.getItems().add(minutes);
        }
        MinutesBox.setValue(currentTime.getMinute());
        DatePicker.setValue(LocalDate.now());
    }

    @FXML
    protected void onBackButtonClick() {
        // add your code here for the onBackButtonClick event
    }

    @FXML
    protected void onHomeButtonClick() {
        // add your code here for the onHomeButtonClick event
    }
    @FXML
    protected void onDepartureButtonClick() {
        depOrArrTime = true;
    }
    @FXML
    protected void onArrivalButtonClick() {
        depOrArrTime = false;
    }
    @FXML
    protected void onSearchButtonClick(ActionEvent actionEvent) throws IOException {
        SceneController sceneController = new SceneController(actionEvent);
        sceneController.setScene("routes");
    }

    @FXML
    protected void onSwapButtonClick() {
        String Departure = DepBox.getValue();
        String Arrival = ArrBox.getValue();
        DepBox.setValue(Arrival);
        ArrBox.setValue(Departure);
    }

    public Map<Edge, LocalTime> getRoute(){
        GraphManipulate graphManipulate = new GraphManipulate();
        return graphManipulate.getRoute(DepBox.getValue(), ArrBox.getValue(), HelloApplication.graph, LocalTime.of(HourBox.getValue(), MinutesBox.getValue()), DatePicker.getValue(), depOrArrTime);
    }
}