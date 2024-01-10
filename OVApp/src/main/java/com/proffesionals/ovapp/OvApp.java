package com.proffesionals.ovapp;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class OvApp extends Application {
    public static Graph graph;

    @Override
    public void start(Stage stage) throws IOException {
        new SceneController(stage);
    }

    public static void main(String[] args) {
        graph = initializeGraph();
        launch();
    }


    public static Graph initializeGraph(){
        ArrayList<Point> points = new ArrayList<>();
        ArrayList<Edge> edges = new ArrayList<>();

        points.add(new Point("Den Helder Centraal"));
        points.add(new Point("Utrecht Centraal"));
        points.add(new Point("Amsterdam Centraal"));
        points.add(new Point("s-Hertogenbosch Centraal"));
        points.add(new Point("Eindhoven Centraal"));
        points.add(new Point("Roermond Centraal"));
        points.add(new Point("Maastricht Centraal"));

        edges.add(new Edge(points.get(0), points.get(1), 65));
        edges.add(new Edge(points.get(1), points.get(2), 34));
        edges.add(new Edge(points.get(2), points.get(3), 46));
        edges.add(new Edge(points.get(3), points.get(4), 31));
        edges.add(new Edge(points.get(4), points.get(5), 45));
        edges.add(new Edge(points.get(5), points.get(6), 43));

        return new Graph(edges, points);
    }

}