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

import java.io.IOException;

public class Main extends Application {
    //Ampel op = new Ampel();
    Beweglich beweg = new Beweglich();
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
    private ImageView imageView;


    @Override

    public void start(Stage primaryStage) {

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

        
        Circle circle = new Circle(20, Color.GREEN);
        circle.setTranslateX(600);
        circle.setTranslateY(400);

        Circle circle2 = new Circle(20, Color.GREEN);
        circle2.setLayoutX(1200);
        circle2.setLayoutY(400);

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


        //Image image = new Image("Ferrari.jpg");
        //ImageView imageView = new ImageView();

        //Ferrari
        imageView = new ImageView();
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        imageView.setPreserveRatio(true);

        root.getChildren().add(imageView);

        startTimeline();
        haltStop();




//        if(istRot1=true){
//            startTimeline();
//        }

        Circle stop1 = new Circle(10, Color.BLACK);
        stop1.setTranslateX(500);
        stop1.setTranslateY(500);

//        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(MOVE_INTERVAL_MS), event -> {
//            // Bewege das ImageView nach rechts
//            imageView.setLayoutX(imageView.getLayoutX() + MOVE_DISTANCE);
//
//            // Überprüfe, ob das ImageView den rechten Rand erreicht hat, und setze es zurück auf den linken Rand
//            if (imageView.getLayoutX() > WIDTH) {
//                imageView.setLayoutX(-imageView.getFitWidth());
//            }
//        }));

//        timeline.setCycleCount(Timeline.INDEFINITE);
//        timeline.play();


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
        imageView.setLayoutY(505);

        if (shouldStartTimeline()) {
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
        }

//        while(istRot1=true){
//            timeline.stop();
//        }
//        while(istRot1=false){
//            timeline.play();
//        }


//        for(int i=0; i<999; i++) {
//            if (istRot1) {
//                timeline.stop();
//            }
//            if (!istRot1) {
//                timeline.play();
//            }
//        }

//        public void handle() {
//
//        }
    }

    private boolean shouldStartTimeline() {
        boolean startTimeline = false;
        if (istRot1) {
            startTimeline = false;
        }
        if(!istRot1){
            startTimeline =true;
        }


        return startTimeline;
    }

    private void haltStop(){
        if(istRot1){
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

//        private void simulateMouseClick(Button button) {
//            MouseEvent event = new MouseEvent(
//                    MouseEvent.MOUSE_CLICKED,
//                    button.getLayoutX() + button.getWidth() / 2,
//                    button.getLayoutY() + button.getHeight() / 2,
//                    button.getLayoutX() + button.getWidth() / 2,
//                    button.getLayoutY() + button.getHeight() / 2,
//                    MouseButton.PRIMARY,
//                    1,
//                    false,
//                    false,
//                    false,
//                    false,
//                    false,
//                    false,
//                    false,
//                    false,
//                    false,
//                    false,
//                    null
//            );
//
//            button.fireEvent(event);
//        }

    public static void main(String[] args) {
        launch(args);
    }

}
