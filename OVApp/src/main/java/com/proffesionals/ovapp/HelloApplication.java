package com.proffesionals.ovapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    public static Graph graph; // create new graph

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setMaximized(true);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        graph = intializeGraph();
        launch();
    }

    
    public static Graph intializeGraph(){ // tet intializeGraph method
        ArrayList<Point> points = new ArrayList<>();
        ArrayList<Edge> edgesUp = new ArrayList<>();
        ArrayList<Edge> edgesDown = new ArrayList<>();

        points.add(new Point("Utrecht Centraal"));
        points.add(new Point("Amsterdam Centraal"));
        points.add(new Point("Rotterdam Centraal"));
        points.add(new Point("Den Haag Centraal"));
        points.add(new Point("Eindhoven Centraal"));
        points.add(new Point("Maastricht Centraal"));

        for (int i = 0; i < points.size() - 1; i++) {
            edgesUp.add(new Edge(points.get(i), points.get(i+1), 15));
        }
        for (int i = 0; i < points.size() - 1; i++) {
            edgesDown.add(new Edge(points.get(i+1), points.get(i), 15));
        }

        return new Graph(edgesUp, edgesDown, points); // create new graph

    }

}