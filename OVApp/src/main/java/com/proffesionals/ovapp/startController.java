package com.proffesionals.ovapp;

import javafx.fxml.FXML;


public class startController {

    @FXML
    protected void onRouteSelect(){
        System.out.println("Route select");
    }

    @FXML
    protected void onFavorite(){
        System.out.println("Favorite");
    }

    @FXML
    protected void onTravelHistory(){
        System.out.println("Travel history");
        
    }

    @FXML
    protected void onChangeLanguege(){
        System.out.println("Change languege");

    }


}