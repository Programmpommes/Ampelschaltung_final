package com.example.ampelschaltung_final;

import javafx.scene.Parent;
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
    StackPane root = new StackPane();


    @Override
    public void start(Stage primaryStage1) {
        Button button = new Button("Drück mich");
        //Beweglich bewegen = new Beweglich();




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
        circle.setTranslateX(500);
        circle.setTranslateY(500);

        Circle circle2 = new Circle(20, Color.GREEN);
        circle2.setLayoutX(500);
        circle2.setLayoutY(450);

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



        //bewegen.start(primaryStage1);

        //StackPane root = new StackPane(circle, circle2);
        root.getChildren().add(circle);
        root.getChildren().add(circle2);
        //StackPane groot = new StackPane(circle2);
        //Scene scene = new Scene(root, 500, 500);

        //Scene scen = new Scene(button, 100, 100);

//        primaryStage1.setTitle("Klick Klack");
//        primaryStage1.setScene(scene);
//        //primaryStage.setScene(scen);
//        primaryStage1.setFullScreen(true);
//        primaryStage1.show();



    }

    public Parent getRoot() {

        return root;
    }
}
