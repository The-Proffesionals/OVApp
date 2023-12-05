package com.proffesionals.ovapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

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

    @Override
    public void initialize(URL location, ResourceBundle resources){
        ArrBox.getItems().addAll("Den Helder", "Amsterdam", "Utrecht");
        DepBox.getItems().addAll("Den Helder", "Amsterdam", "Utrecht");
        for (int hour = 0; hour < 24 ; hour++){
            HourBox.getItems().add(hour);
        }
        for (int minutes = 0; minutes <= 60 ; minutes += 5){
            MinutesBox.getItems().add(minutes);
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