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
        graph = intializeGraph();
        launch();
    }


    public static Graph intializeGraph(){
        ArrayList<Point> points = new ArrayList<>();
        ArrayList<Edge> edgesUp = new ArrayList<>();
        ArrayList<Edge> edgesDown = new ArrayList<>();

        points.add(new Point("Den Helder Centraal"));
        points.add(new Point("Utrecht Centraal"));
        points.add(new Point("Amsterdam Centraal"));
        points.add(new Point("s-Hertogenbosch Centraal"));
        points.add(new Point("Eindhoven Centraal"));
        points.add(new Point("Roermond Centraal"));
        points.add(new Point("Maastricht Centraal"));

        addEdges(edgesUp, edgesDown, points.get(0), points.get(1), 65);
        addEdges(edgesUp, edgesDown, points.get(1), points.get(2), 34);
        addEdges(edgesUp, edgesDown, points.get(2), points.get(3), 46);
        addEdges(edgesUp, edgesDown, points.get(3), points.get(4), 31);
        addEdges(edgesUp, edgesDown, points.get(4), points.get(5), 45);
        addEdges(edgesUp, edgesDown, points.get(5), points.get(6), 43);

        return new Graph(edgesUp, edgesDown, points);

    }

    public static void addEdges(ArrayList<Edge> edgesUp, ArrayList<Edge> edgesDown, Point point1, Point point2, Integer distance){
        edgesUp.add(new Edge(point1, point2, distance));
        edgesDown.add(new Edge(point2, point1, distance));
    }
}