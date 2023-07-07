package com.example.ampelschaltung_final;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;

public class Main extends Application {
    Boolean istRot1 = false;
    Boolean istRot2 = false;
    Pane root = new Pane();
    private static final int WIDTH = 1920;
    private static final int HEIGHT = 1080;
    private static final int MOVE_DISTANCE = 1;
    private static final int MOVE_INTERVAL_MS = 10;
    Auto Ferrari = new Auto();
    Auto Aston = new Auto();
    Auto Audi = new Auto();
    Timeline timeline = new Timeline();
    Timeline timeline2 = new Timeline();
    private ImageView imageView;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    Circle circle = new Circle(20, Color.GREEN);
    Circle circle2 = new Circle(20, Color.GREEN);
    Random auto = new Random();
    List<String> imagePaths = new ArrayList<>();



    @Override

    public void start(Stage primaryStage) {

        imagePaths.add("aston-martin-amr22.jpg");
        imagePaths.add("bmw.jpg");
        imagePaths.add("bugatti.jpg");
        imagePaths.add("Ferrari.jpg");
        imagePaths.add("graues Auto.jpg");
        imagePaths.add("oldtimer.jpg");
        imagePaths.add("opel.jpg");

//        Ampel firstClass = new Ampel();
//        firstClass.start(primaryStage);
//        Scene firstScene = new Scene(firstClass.getRoot());
//
//        Beweglich secondClass = new Beweglich();
//
//        //for (int i=0; i<10; i++) {
//            secondClass.start(primaryStage);
//        //}
//        //secondClass.startMovement();
//        Scene secondScene = new Scene(secondClass.getRoot());
//
//
//        primaryStage.setTitle("Ampelschaltung");
//        primaryStage.setWidth(500);
//        primaryStage.setHeight(500);
//        primaryStage.setFullScreen(true);
//
//        TilePane container = new TilePane();
//
//        //HBox container = new HBox();
//        container.getChildren().addAll(firstClass.getRoot(), secondClass.getRoot());
//        //container.getChildren().add(secondClass.pane);
//
//
//        Scene mainScene = new Scene(container);
//        primaryStage.setScene(mainScene);
//        primaryStage.show();

        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(110);
        rectangle.setWidth(5000);
        rectangle.setX(0);
        rectangle.setY(445);
        rectangle.setFill(Color.GREY);

        Rectangle rectangle2 = new Rectangle();
        rectangle2.setHeight(5);
        rectangle2.setWidth(5000);
        rectangle2.setX(0);
        rectangle2.setY(495);
        rectangle2.setFill(Color.YELLOW);

        Rectangle rectangle3 = new Rectangle();
        rectangle3.setHeight(110);
        rectangle3.setWidth(1500);
        rectangle3.setX(210);
        rectangle3.setY(500);
        rectangle3.setRotate(90);
        rectangle3.setFill(Color.GREY);

        Rectangle rectangle4 = new Rectangle();
        rectangle4.setHeight(5);
        rectangle4.setWidth(1500);
        rectangle4.setX(210);
        rectangle4.setY(500);
        rectangle4.setRotate(90);
        rectangle4.setFill(Color.YELLOW);

        Rectangle rectangle5 = new Rectangle();
        rectangle5.setHeight(110);
        rectangle5.setWidth(110);
        rectangle5.setX(905);
        rectangle5.setY(445);
        rectangle5.setFill(Color.GREY);

        circle.setTranslateX(850);
        circle.setTranslateY(400);

        circle2.setLayoutX(1050);
        circle2.setLayoutY(600);

        circle.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            MouseButton mouseButton = event.getButton();
            if (mouseButton == MouseButton.PRIMARY) {
                circle.setFill(Color.RED);
                istRot1 = true;
            } else if (mouseButton == MouseButton.SECONDARY) {
                circle.setFill(Color.GREEN);
                istRot1 = false;
            }
        });

        circle2.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            MouseButton mouseButton = event.getButton();
            if (mouseButton == MouseButton.PRIMARY) {
                circle2.setFill(Color.RED);
                istRot2 = true;
            } else if (mouseButton == MouseButton.SECONDARY) {
                circle2.setFill(Color.GREEN);
                istRot2 = false;
            }
        });

        root.getChildren().add(circle);
        root.getChildren().add(circle2);
        root.getChildren().add(rectangle);
        root.getChildren().add(rectangle2);
        root.getChildren().add(rectangle3);
        root.getChildren().add(rectangle4);
        root.getChildren().add(rectangle5);


        //Image image = new Image("Ferrari.jpg");
        //ImageView imageView = new ImageView();

        //Ferrari
        imageView = new ImageView();
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        imageView.setPreserveRatio(true);
        root.getChildren().add(imageView);
        startTimeline();

        //Aston
        imageView2 = new ImageView();
        imageView2.setFitWidth(110);
        imageView2.setFitHeight(110);
        imageView2.setPreserveRatio(true);
        root.getChildren().add(imageView2);
        startTimeline2();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();

    }


    public void startTimeline() {
        Image image = new Image("Ferrari.jpg");
        //ImageView imageView = new ImageView(image);
        imageView.setImage(image);
        imageView.setLayoutX(0);
        imageView.setLayoutY(450);

        //if (shouldStartTimeline()) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(MOVE_INTERVAL_MS), event -> {
            // Bewege das ImageView nach rechts
            imageView.setLayoutX(imageView.getLayoutX() + MOVE_DISTANCE);

            // Überprüfe, ob das ImageView den rechten Rand erreicht hat, und setze es zurück auf den linken Rand
            if (imageView.getLayoutX() > WIDTH) {
                imageView.setLayoutX(-imageView.getFitWidth());
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        circle.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            MouseButton mouseButton = event.getButton();
            if (mouseButton == MouseButton.PRIMARY) {
                circle.setFill(Color.RED);
                timeline.stop();
            } else if (mouseButton == MouseButton.SECONDARY) {
                circle.setFill(Color.GREEN);
                timeline.play();
            }
        });
        //}
    }

    public void startTimeline2() {
        Image image2 = new Image("aston-martin-amr22.jpg");
        //ImageView imageView = new ImageView(image);
        imageView2.setImage(image2);
        imageView2.setLayoutX(1920);
        imageView2.setLayoutY(505);
        imageView2.setRotate(180);

        //if (shouldStartTimeline()) {
        Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(MOVE_INTERVAL_MS), event -> {
            // Bewege das ImageView nach rechts
            imageView2.setLayoutX(imageView2.getLayoutX() - MOVE_DISTANCE);

            // Überprüfe, ob das ImageView den rechten Rand erreicht hat, und setze es zurück auf den linken Rand
            if (imageView2.getLayoutX() == 0) {
                imageView2.setLayoutX(1920);
            }
        }));
        timeline2.setCycleCount(Timeline.INDEFINITE);
        timeline2.play();

        circle2.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            MouseButton mouseButton = event.getButton();
            if (mouseButton == MouseButton.PRIMARY) {
                circle2.setFill(Color.RED);
                timeline2.stop();
            } else if (mouseButton == MouseButton.SECONDARY) {
                circle2.setFill(Color.GREEN);
                timeline2.play();
            }
        });
        //}
    }

    private boolean shouldStartTimeline() {
        boolean startTimeline = false;
        if (istRot1) {
            startTimeline = false;
        }
        if (!istRot1) {
            startTimeline = true;
        }


        return startTimeline;
    }

    private void haltStop() {
        if (istRot1) {
            timeline.stop();
        }
    }

//    public void update(){
//        if(istRot1){
//
//        }
//        if(!istRot1){
//            timeline.play();
//        }
//    }


//        public void start(Stage primaryStage) {
//            Button button = new Button("Drück mich");
//
//
//            button.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
//                MouseButton mouseButton = event.getButton();
//                if (mouseButton == MouseButton.PRIMARY) {
//                    System.out.println("Linke Taste");
//                }
//                if (mouseButton == MouseButton.SECONDARY){
//                    System.out.println("Rechte Taste");
//                }
//                if (mouseButton == MouseButton.MIDDLE){
//                    System.out.println("Mittlere Taste");
//                }
//                if (mouseButton == MouseButton.BACK){
//                    System.out.println("Zurücktaste");
//                }
//                if (mouseButton == MouseButton.FORWARD){
//                    System.out.println("Weitertaste");
//                }
//            });
//
//            Scene scene = new Scene(button, 200, 100);
//
//            primaryStage.setTitle("Klick Klack");
//            primaryStage.setScene(scene);
//            primaryStage.show();
//
//
//
//        }


    public static void main(String[] args) {
        launch(args);
    }

}
