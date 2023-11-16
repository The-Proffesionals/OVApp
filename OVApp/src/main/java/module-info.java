module com.proffesionals.ovapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.proffesionals.ovapp to javafx.fxml;
    exports com.proffesionals.ovapp;
}