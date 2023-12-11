package com.proffesionals.ovapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class SceneController {

    HashMap<String, String> sceneTitles = new HashMap<String, String>();
    Scene main;
    Stage stage;

    SceneController(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(OvApp.class.getResource("RouteInformation.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setMaximized(true);
        primaryStage.setTitle("Route planner");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public SceneController(ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        main = node.getScene();
        stage = (Stage) main.getWindow();
    }

    public void setScene(String sceneName) throws IOException {
        main.setRoot(FXMLLoader.load(getClass().getResource(sceneName + ".fxml")));
        stage.show();
    }
}
