module com.example.ampelschaltung_final {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.ampelschaltung_final to javafx.fxml;
    exports com.example.ampelschaltung_final;
}