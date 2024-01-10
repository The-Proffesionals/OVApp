package com.proffesionals.ovapp;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

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

        points.add(new Point("Den Helder C"));
        points.add(new Point("Utrecht C"));
        points.add(new Point("Amsterdam C"));
        points.add(new Point("Den Bosch C"));
        points.add(new Point("Eindhoven C"));
        points.add(new Point("Roermond C"));
        points.add(new Point("Maastricht C"));

        edges.add(new Edge(points.get(0), points.get(1), 65));
        edges.add(new Edge(points.get(1), points.get(2), 34));
        edges.add(new Edge(points.get(2), points.get(3), 46));
        edges.add(new Edge(points.get(3), points.get(4), 31));
        edges.add(new Edge(points.get(4), points.get(5), 45));
        edges.add(new Edge(points.get(5), points.get(6), 43));

        return new Graph(edges, points);
    }

}