module ultrasomma {
    requires javafx.controls;
    requires javafx.fxml;
    requires poi;
    requires poi.ooxml;
    requires java.sql;

    opens ultrasomma to javafx.fxml;
    exports ultrasomma;
}