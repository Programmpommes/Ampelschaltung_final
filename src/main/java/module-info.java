module com.example.ampelschaltung_final {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ampelschaltung_final to javafx.fxml;
    exports com.example.ampelschaltung_final;
}