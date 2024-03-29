package com.proffesionals.ovapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Button;

import java.time.LocalDate;
import java.time.LocalTime;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class RouteInformationController extends SceneController implements Initializable {
    @FXML
    public Button GoToRoutes;
    @FXML
    private ComboBox<String> DepBox;
    @FXML
    private ComboBox<String> ArrBox;
    @FXML
    private ComboBox<String> MinutesBox;
    @FXML
    private ComboBox<Integer> HourBox;
    @FXML
    private DatePicker DatePicker;
    @FXML
    private Button Vertrek;
    @FXML
    private Button Aankomst;
    @FXML
    private ComboBox<String> DepartureOrArival;
    
    private ObservableList<String> allStations = FXCollections.observableArrayList("Den Helder C","Utrecht C","Amsterdam C","Den Bosch C","Eindhoven C","Roermond C","Maastricht C");
    private LocalTime currentTime = LocalTime.now();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrBox.setItems(allStations);
        DepBox.setItems(allStations);

        DepartureOrArival.getItems().add(LanguageManager.getText("Vertrek"));
        DepartureOrArival.getItems().add(LanguageManager.getText("Aankomst"));
        
        for (int hour = 0; hour < 24; hour++) {
            HourBox.getItems().add(hour);
        }
        HourBox.setValue(currentTime.getHour());
        for (int minutes = 0; minutes < 60; minutes += 5) {
            if (minutes < 10) {
                MinutesBox.getItems().add("0" + minutes); 
            } else{
                MinutesBox.getItems().add(String.valueOf(minutes));
            }
        }
        if (currentTime.getMinute() < 10) {
            MinutesBox.setValue("0" + currentTime.getMinute());
        } else {
            MinutesBox.setValue(String.valueOf(currentTime.getMinute()));
        }
        DatePicker.setValue(LocalDate.now());

        FillText();
        addCurrentJourney();
        
    }

    @FXML
    protected void goToNewScene(ActionEvent actionEvent) throws IOException {
        getScene(actionEvent);
        Node Home = (Node) actionEvent.getSource();
        setScene(Home.getId());
    }

    @FXML
    protected void onSwapButtonClick() {
        String temp = ArrBox.getValue();
        ArrBox.setValue(DepBox.getValue());
        DepBox.setValue(temp);
    }

    @FXML
    protected void onSearchButtonClick(ActionEvent actionEvent) throws IOException {
        if (DepBox.getValue() != null && ArrBox.getValue() != null && DepBox.getValue() != ArrBox.getValue()) {
            RouteInformation.arrivalDestination = ArrBox.getValue();
            RouteInformation.departureDestination = DepBox.getValue();
            RouteInformation.hours = HourBox.getValue();
            RouteInformation.minutes = Integer.parseInt(MinutesBox.getValue());
            RouteInformation.date = DatePicker.getValue();

            RouteInformation.departureorarrival = !DepartureOrArival.getValue().equals(LanguageManager.getText("Aankomst"));
            
            goToNewScene(actionEvent);
        } else {
            if (ArrBox.getValue() != null&& DepBox.getValue() != null && ArrBox.getValue().equals(DepBox.getValue())){
                ArrBox.setStyle("-fx-background-color: #FFD6CC;");
            }
            highlightIfEmpty(DepBox);
            highlightIfEmpty(ArrBox);
        }
    }
    public void FillText() {
        DepBox.setPromptText(LanguageManager.getText("DepBox"));
        ArrBox.setPromptText(LanguageManager.getText("ArrBox"));
        GoToRoutes.setText(LanguageManager.getText("Search"));
    }
    private void highlightIfEmpty(ComboBox<String> comboBox) {
        comboBox.valueProperty().removeListener((observable, oldValue, newValue) -> {});
        comboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            comboBox.setStyle(""); 
        });
        if (comboBox.getValue() == null || comboBox.getValue().isEmpty()) {
            comboBox.setStyle("-fx-background-color: #FFD6CC;");
        }
    }

    private void addCurrentJourney(){
        
        if (RouteInformation.departureDestination != null && RouteInformation.arrivalDestination != null) {
            ArrBox.setValue(RouteInformation.arrivalDestination);
            DepBox.setValue(RouteInformation.departureDestination);
        }
        if (RouteInformation.hours != -1 && RouteInformation.minutes != -1) {
            HourBox.setValue(RouteInformation.hours);
            if (RouteInformation.minutes < 10) {
                MinutesBox.setValue("0" + RouteInformation.minutes);
            } else {
                MinutesBox.setValue(String.valueOf(RouteInformation.minutes));
            }
        }
        if (RouteInformation.date != null) {
            DatePicker.setValue(RouteInformation.date);
        }
        if (RouteInformation.departureorarrival == false) {
            DepartureOrArival.setValue(LanguageManager.getText("Aankomst"));
        }
        if (!RouteInformation.departureorarrival) {
            DepartureOrArival.setValue(LanguageManager.getText("Aankomst"));
        } else {
            DepartureOrArival.setValue(LanguageManager.getText("Vertrek"));
        }

    }
}

