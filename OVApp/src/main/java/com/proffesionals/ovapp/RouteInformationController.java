package com.proffesionals.ovapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Button;

import java.time.LocalDate;
import java.time.LocalTime;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class RouteInformationController implements Initializable {
    @FXML
    private Button Search;
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
    


    private boolean depOrArrTime = true;

    private ObservableList<String> allStations = FXCollections.observableArrayList("Den Helder C","Utrecht C","Amsterdam C","Den Bosch C","Eindhoven C","Roermond C","Maastricht C");
    private LocalTime currentTime = LocalTime.now();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrBox.setItems(allStations);
        DepBox.setItems(allStations);

        if (RouteInformation.departureDestination != null && RouteInformation.arrivalDestination != null) {
            ArrBox.setValue(RouteInformation.arrivalDestination);
            DepBox.setValue(RouteInformation.departureDestination);
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


        FillText();
        
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
        Aankomst.setStyle("-fx-text-fill: #808080;");
    }

    @FXML
    protected void onArrivalButtonClick() {
        depOrArrTime = false;
        Vertrek.setStyle("-fx-text-fill: #808080;");
        Aankomst.setStyle("-fx-text-fill: #0A1758;");
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
            RouteInformation.minutes = MinutesBox.getValue();
            RouteInformation.date = DatePicker.getValue();
            RouteInformation.departureorarrival = depOrArrTime;

            SceneController sceneController = new SceneController(actionEvent);
            sceneController.setScene("Routes");
        } else {
            highlightIfEmpty(DepBox);
            highlightIfEmpty(ArrBox);
        }
    }
    public void FillText() {
        Aankomst.setText(LanguageManager.getText("Aankomst"));
        Vertrek.setText(LanguageManager.getText("Vertrek"));
        DepBox.setPromptText(LanguageManager.getText("DepBox"));
        ArrBox.setPromptText(LanguageManager.getText("ArrBox"));
        Search.setText(LanguageManager.getText("Search"));
    }
    private void highlightIfEmpty(ComboBox<String> comboBox) {
        comboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && !newValue.isEmpty()) {
                // ComboBox is not empty, remove the highlighting
                comboBox.setStyle("");
            } else {
                // ComboBox is empty, apply the highlighting
                comboBox.setStyle("-fx-background-color: #FFD6CC;");
            }
        });
        if (comboBox.getValue() == null || comboBox.getValue().isEmpty()) {
            comboBox.setStyle("-fx-background-color: #FFD6CC;");
        }
    }
}

