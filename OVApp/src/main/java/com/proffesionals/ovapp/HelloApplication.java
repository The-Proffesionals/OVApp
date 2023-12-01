package com.proffesionals.ovapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;

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
        intializeGraph();
        launch();
    }

    public static void intializeGraph(){ // tet intializeGraph method
        GraphManipulate graphManipulate = new GraphManipulate();
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

        Graph graph = new Graph(edgesUp, edgesDown, points); // create new graph

        Map<Edge, LocalTime> route = graphManipulate.getRoute(graph.getPointByName("Amsterdam Centraal"), graph.getPointByName("Maastricht Centraal"), graph, LocalTime.now()); // get route from Utrecht to Maastricht
        for (Map.Entry<Edge, LocalTime> entry : route.entrySet()) {
            String formattedTime = entry.getValue().format(DateTimeFormatter.ofPattern("HH:mm")); // format time
            System.out.format("van: %s / naar: %s om: %s\n", entry.getKey().getPoint1().getName(), entry.getKey().getPoint2().getName(), formattedTime); // print route
        }
    }

}