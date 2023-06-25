package com.example.ampelschaltung_final;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ampel extends Application {
    Boolean istRot1 = false;
    Boolean istRot2 = false;


    @Override
    public void start(Stage primaryStage) {
        Button button = new Button("Drück mich");


//        button.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
//            MouseButton mouseButton = event.getButton();
//            if (mouseButton == MouseButton.PRIMARY) {
//                System.out.println("Linke Taste");
//                istRot = true;
//            }
//            if (mouseButton == MouseButton.SECONDARY){
//                System.out.println("Rechte Taste");
//                istRot = false;
//            }
//            if (mouseButton == MouseButton.MIDDLE){
//                System.out.println("Mittlere Taste");
//            }
//            if (mouseButton == MouseButton.BACK){
//                System.out.println("Zurücktaste");
//            }
//            if (mouseButton == MouseButton.FORWARD){
//                System.out.println("Weitertaste");
//            }
//        });

        Circle circle = new Circle(20, Color.GREEN);
        circle.setTranslateX(150);
        circle.setTranslateY(100);

        Circle circle2 = new Circle(20, Color.GREEN);
        circle2.setLayoutX(50);
        circle2.setLayoutY(50);

        // Add a mouse click event handler to the circle
        circle.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            MouseButton mouseButton = event.getButton();
            if (mouseButton == MouseButton.PRIMARY) {
                circle.setFill(Color.RED);
                istRot1 = true;
            }
            else if (mouseButton == MouseButton.SECONDARY) {
                circle.setFill(Color.GREEN);
                istRot1 = false;
            }
        });

        circle2.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            MouseButton mouseButton = event.getButton();
            if (mouseButton == MouseButton.PRIMARY) {
                circle2.setFill(Color.RED);
                istRot2 = true;
            }
            else if (mouseButton == MouseButton.SECONDARY) {
                circle2.setFill(Color.GREEN);
                istRot2 = false;
            }
        });

        StackPane root = new StackPane(circle, circle2);
        //StackPane groot = new StackPane(circle2);
        Scene scene = new Scene(root, 1000, 1000);

        //Scene scene = new Scene(button, 200, 100);

        primaryStage.setTitle("Klick Klack");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
