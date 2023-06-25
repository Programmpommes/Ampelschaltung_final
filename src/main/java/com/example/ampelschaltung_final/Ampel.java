package com.example.ampelschaltung_final;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.application.Application;

public class Ampel extends Application {
    @Override
    public void start(Stage primaryStage) {
        Button button = new Button("Drück mich");


        button.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            MouseButton mouseButton = event.getButton();
            if (mouseButton == MouseButton.PRIMARY) {
                System.out.println("Linke Taste");
            }
            if (mouseButton == MouseButton.SECONDARY){
                System.out.println("Rechte Taste");
            }
            if (mouseButton == MouseButton.MIDDLE){
                System.out.println("Mittlere Taste");
            }
            if (mouseButton == MouseButton.BACK){
                System.out.println("Zurücktaste");
            }
            if (mouseButton == MouseButton.FORWARD){
                System.out.println("Weitertaste");
            }
        });

        Scene scene = new Scene(button, 200, 100);

        primaryStage.setTitle("Klick Klack");
        primaryStage.setScene(scene);
        primaryStage.show();



    }
}
