package com.proffesionals.ovapp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import java.io.IOException;
import java.util.Locale;
import static com.proffesionals.ovapp.LanguageManager.setLanguage;

public class StartController extends SceneController {
    public Button TravelHistory_select;
    public Button Favorite_select;
    public Button Route_select;

    public void initialize(){
        FillText();
        RouteInformation.clearCurrentJourney();
    }

    @FXML
    protected void onRouteSelect(ActionEvent actionEvent) throws IOException {
        getScene(actionEvent);
        Node Route_select = (Node) actionEvent.getSource();
        setScene(Route_select.getId());
    }

    @FXML
    protected void onFavorite(ActionEvent actionEvent) throws IOException {
        getScene(actionEvent);
        Node Favorite_select = (Node) actionEvent.getSource();
        setScene(Favorite_select.getId());
    }

    @FXML
    protected void onTravelHistory(ActionEvent actionEvent) throws IOException {
        getScene(actionEvent);
        Node TravelHistory_select = (Node) actionEvent.getSource();
        setScene(TravelHistory_select.getId());
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
        Route_select.setText(LanguageManager.getText("Route_select"));
        Favorite_select.setText(LanguageManager.getText("Favorite_select"));
        TravelHistory_select.setText(LanguageManager.getText("TravelHistory_select"));
    }
}