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
        sceneTitles.put("GoToRouteInformation", "RouteInformation");
        sceneTitles.put("GoToRoutes", "Routes");
        sceneTitles.put("GoToEnd", "End");
        sceneTitles.put("GoToStart", "Start");;
        sceneTitles.put("GoToFavorite", "Favorite");
        sceneTitles.put("GoToTravelHistory", "TravelHistory");
    }
}
