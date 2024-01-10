module com.proffesionals.ovapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.prefs;


    opens com.proffesionals.ovapp to javafx.fxml;
    exports com.proffesionals.ovapp;
}