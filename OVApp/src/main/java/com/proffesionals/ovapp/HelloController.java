package com.proffesionals.ovapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import java.time.LocalTime;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private ComboBox<String> ArrBox;
    @FXML
    private ComboBox<String> DepBox;
    @FXML
    private ComboBox<Integer> MinutesBox;
    @FXML
    private ComboBox<Integer> HourBox;
    private ObservableList<String> allStations = FXCollections.observableArrayList("Den Helder", "Amsterdam", "Utrecht");
    private LocalTime currentTime = LocalTime.now();

    @Override
    public void initialize(URL location, ResourceBundle resources){
        ArrBox.setItems(allStations);
        ArrBox.setValue("Arrival");
        DepBox.setItems(allStations);
        DepBox.setValue("departure");
        for (int hour = 0; hour < 24 ; hour++){
            HourBox.getItems().add(hour);
        }
        HourBox.setValue(currentTime.getHour());
        for (int minutes = 0; minutes <= 60 ; minutes += 5){
            MinutesBox.getItems().add(minutes);
        }
        MinutesBox.setValue(currentTime.getMinute());

        // Add listeners to both ComboBoxes
        DepBox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            updateOptions(newValue, ArrBox);
        });

        ArrBox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            updateOptions(newValue, DepBox);
        });
    }

    private void updateOptions(String selected, ComboBox<String> otherComboBox) {
        if (selected != null) {
            ObservableList<String> filteredStations = allStations.filtered(station -> !station.equals(selected));
            String otherSelected = otherComboBox.getSelectionModel().getSelectedItem();
            otherComboBox.setItems(filteredStations);
            if (otherSelected != null && !otherSelected.equals(selected)) {
                otherComboBox.getSelectionModel().select(otherSelected);
            }
        } else {
            otherComboBox.setItems(allStations);
        }
    }


    @FXML
    protected void onBackButtonClick() {
        System.out.println("TerugButtonClick");
    }
    @FXML
    protected void onHomeButtonClick() {
        System.out.println("HomeButtonClick");
    }
    @FXML
    protected void onDepartureButtonClick() {
        System.out.println("VertrekButtonClick");

    }
    @FXML
    protected void onArrivalButtonClick() {
        System.out.println("AankomstButtonClick");
    }
    @FXML
    protected void onSearchButtonClick() {
        System.out.println("Plan je reis");
    }





}