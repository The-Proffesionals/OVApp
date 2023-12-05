package com.proffesionals.ovapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onTerugButtonClick() {
        System.out.println("TerugButtonClick");
    }
    @FXML
    protected void onHomeButtonClick() {
        System.out.println("HomeButtonClick");

    }
    @FXML
    protected void onVertrekButtonClick() {
        System.out.println("VertrekButtonClickk");

    }
    @FXML
    protected void onAankomstButtonClick() {
        System.out.println("AankomstButtonClick");
    }
    @FXML
    protected void onPlanJeReisButtonClick() {
        System.out.println("Plan je reis");
    }





}