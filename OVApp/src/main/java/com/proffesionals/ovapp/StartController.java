package com.proffesionals.ovapp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.Locale;
import static com.proffesionals.ovapp.LanguageManager.setLanguage;

public class StartController extends SceneController {
    public Button GoToTravelHistory;
    public Button GoToFavorite;
    public Button GoToRouteInformation;

    public void initialize(){
        FillText();
        RouteInformation.clearCurrentJourney();
    }

    @FXML
    protected void goToNewScene(ActionEvent actionEvent) throws IOException {
        getScene(actionEvent);
        Node newScene = (Node) actionEvent.getSource();
        setScene(newScene.getId());
    }

    @FXML
    protected void onChangeLanguagetoE(){
        setLanguage(new Locale("en"));
        FillText();
    }

    @FXML
    protected void onChangeLanguagetoD(){
        LanguageManager.setLanguage(new Locale("nl"));
        FillText();
    }

    public void FillText() {
        GoToRouteInformation.setText(LanguageManager.getText("Route_select"));
        GoToFavorite.setText(LanguageManager.getText("Favorite_select"));
        GoToTravelHistory.setText(LanguageManager.getText("TravelHistory_select"));
    }
}