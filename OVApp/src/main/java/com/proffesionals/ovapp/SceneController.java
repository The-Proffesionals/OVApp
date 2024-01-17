package com.proffesionals.ovapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class SceneController {

    private HashMap<String, String> sceneTitles = new HashMap<String, String>();

    private Scene main;
    private Stage stage;

    public SceneController(){
        loadHashMap();
    }

    SceneController(Stage mainStage) throws IOException {
        this.stage = mainStage;
        FXMLLoader fxmlLoader = new FXMLLoader(OvApp.class.getResource("Start.fxml"));
        main = new Scene(fxmlLoader.load(), 1920, 1080);
        mainStage.setMaximized(true);
        mainStage.setTitle("Route planner");
        mainStage.setScene(main);

        mainStage.setResizable(false);
        mainStage.setFullScreen(true);

        mainStage.show();
    }

    public void getScene(ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        main = node.getScene();
        stage = (Stage) main.getWindow();
    }



    public void setScene(String btnID) throws IOException {
        main.setRoot(FXMLLoader.load(getClass().getResource( sceneTitles.get(btnID) + ".fxml")));
      //  stage.show();
    }

    private void loadHashMap(){
        sceneTitles.put("Route_select", "RouteInformation");
        sceneTitles.put("Search", "Routes");
        sceneTitles.put("route", "End");
        sceneTitles.put("Home", "Start");
        sceneTitles.put("Home2", "Start");
        sceneTitles.put("Home3", "Start");
        sceneTitles.put("Home4", "Start");
        sceneTitles.put("Home5", "Start");
        sceneTitles.put("Back1", "Start");
        sceneTitles.put("Back2", "Start");
        sceneTitles.put("Back3", "Start");
        sceneTitles.put("Back4", "RouteInformation");
        sceneTitles.put("Back5", "Routes");
        sceneTitles.put("Favorite_select", "Favorite");
        sceneTitles.put("TravelHistory_select", "TravelHistory");
        sceneTitles.put("Journeys","End");
        sceneTitles.put("Favorite","RouteInformation");
    }
}
