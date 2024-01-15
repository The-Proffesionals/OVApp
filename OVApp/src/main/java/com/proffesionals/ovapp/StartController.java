package com.proffesionals.ovapp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.Locale;
import static com.proffesionals.ovapp.LanguageManager.setLanguage;

public class StartController {
    public Button TravelHistory_select;
    public Button Favorite_select;
    public Button Route_select;
    static boolean ENGLangButtonClicked = false; //is the language change button clicked?

    public void initialize(){
        FillText();
        
    }

    @FXML
    protected void onRouteSelect(ActionEvent actionEvent) throws IOException {
        SceneController sceneController = new SceneController(actionEvent);
        sceneController.setScene("RouteInformation");

    }

    @FXML
    protected void onFavorite(ActionEvent actionEvent) throws IOException {
        SceneController sceneController = new SceneController(actionEvent);
        sceneController.setScene("Favorite");
    }

    @FXML
    protected void onTravelHistory(ActionEvent actionEvent) throws IOException {
        SceneController sceneController = new SceneController(actionEvent);
        sceneController.setScene("TravelHistory");
    }

    @FXML
    protected void onChangeLanguagetoE(){
        setLanguage(new Locale("en"));
        FillText();
        setLangButtonClicked(true);
    }
    @FXML
    protected void onChangeLanguagetoD(){
        LanguageManager.setLanguage(new Locale("nl"));
        FillText();
    }
    public void FillText() {
        Route_select.setText(LanguageManager.getText("Route_select"));
        Favorite_select.setText(LanguageManager.getText("Favorite_select"));
        TravelHistory_select.setText(LanguageManager.getText("TravelHistory_select"));
    }

    public static boolean isLangButtonClicked() {
        return ENGLangButtonClicked;
    }

    public static void setLangButtonClicked(boolean clicked) {
        ENGLangButtonClicked = clicked;
    }
}