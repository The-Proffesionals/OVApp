package com.proffesionals.ovapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        // intializeGraph();
        launch();
    }

    // public static void intializeGraph(){ // tet intializeGraph method
    //     ArrayList<Point> points = new ArrayList<>();
    //     ArrayList<Edge> edgesUp = new ArrayList<>();
    //     ArrayList<Edge> edgesDown = new ArrayList<>();

    //     points.add(new Point("Utrecht Centraal"));
    //     points.add(new Point("Amsterdam Centraal"));
    //     points.add(new Point("Rotterdam Centraal"));
    //     points.add(new Point("Den Haag Centraal"));
    //     points.add(new Point("Eindhoven Centraal"));
    //     points.add(new Point("Maastricht Centraal"));

    //     for (int i = 0; i < points.size() - 1; i++) {
    //         edgesUp.add(new Edge(points.get(i), points.get(i+1), 10));
    //     }
    //     for (int i = points.size() - 1; i > 0; i--) {
    //         edgesDown.add(new Edge(points.get(i), points.get(i-1), 10));
    //     }

    //     Graph graph = new Graph(edgesUp, edgesDown, points); // create new graph

    //     List<Edge> route = new GraphManipulate().getRoute(graph.getPointByName("Utrecht Centraal"), graph.getPointByName("Maastricht Centraal"), graph); // get route from Utrecht to Maastricht
    //     for (Edge edge : route) {
    //         System.out.format("van: %s / naar: %s afstand: %s km \n", edge.getPoint1().getName(), edge.getPoint2().getName(), edge.getDistance()); // print route
    //     }
    // }

}