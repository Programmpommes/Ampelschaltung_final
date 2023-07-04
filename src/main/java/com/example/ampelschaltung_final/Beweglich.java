package com.example.ampelschaltung_final;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Beweglich extends Application {
    Ampel ampel1 = new Ampel();
    public Boolean halt = false;
    StackPane groot = new StackPane();
    Auto Ferrari = new Auto();
    Auto Aston = new Auto();
    Auto Audi = new Auto();
    private static final int MOVE_DISTANCE = 10;
    private static final int MOVE_INTERVAL_MS = 100;
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    Pane pane = new Pane();


//    Beweglich() {
//
//    }


//    public void stopGo() {
//        if (ampel1.istRot1 || ampel1.istRot2) {
//            halt = true;
//        } else if (!ampel1.istRot1 || !ampel1.istRot2) {
//            halt = false;
//        }
//    }

    @Override
    public void start(Stage primaryStage) {


        Image image = new Image("Ferrari.jpg");
        Image image2 = new Image("aston-martin-amr22.jpg");
        Image image3 = new Image("Graues Auto.jpg");


        ImageView imageView = new ImageView(image);
        ImageView imageView2 = new ImageView(image2);
        ImageView imageView3 = new ImageView(image3);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);
        imageView2.setFitWidth(200);
        imageView2.setPreserveRatio(true);
        imageView3.setFitWidth(200);
        imageView3.setPreserveRatio(true);
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        imageView.setLayoutX(100);
        imageView.setLayoutY(100);

        javafx.animation.KeyFrame keyFrame = new javafx.animation.KeyFrame(
                javafx.util.Duration.millis(100),
                event -> {
                    // Bewege das ImageView nach rechts
                    imageView.setLayoutX(imageView.getLayoutX() + MOVE_DISTANCE);
                }
        );

        javafx.animation.Timeline timeline = new javafx.animation.Timeline(keyFrame);
        timeline.setCycleCount(javafx.animation.Animation.INDEFINITE);
        timeline.play();
        groot.getChildren().add(imageView);



//        Pane pane = new Pane();
//        pane.getChildren().add(imageView);


        //groot.getChildren().add(imageView2);
        //groot.getChildren().add(imageView3);

//        Timeline timeline = new Timeline(
//                new KeyFrame(Duration.millis(30), event -> {
//                    update();
//                    // imageView.setTranslateX(100);
//                    // imageView.setTranslateY(100);
////                    imageView.setX(Ferrari.x);
////                    imageView.setY(Ferrari.y);
//                    //imageView.setLayoutX(imageView.getLayoutX() + Ferrari.maxGeschw);
//
//                })
//        );
//
//        timeline.setCycleCount(Animation.INDEFINITE);
//        timeline.play();

//        Timeline timeline = new Timeline(
//                new KeyFrame(Duration.millis(MOVE_INTERVAL_MS), event -> {
//            // Bewege das ImageView nach rechts
//            imageView.setLayoutX(imageView.getLayoutX() + MOVE_DISTANCE);
//        })
//        );
//        timeline.setCycleCount(Animation.INDEFINITE);
//        timeline.play();




//        Timeline timeline = new Timeline(
//                new KeyFrame(Duration.ZERO, event -> {
//                    imageView.setTranslateX(0);
//                    imageView.setTranslateY(0);
//                }),
//                new KeyFrame(Duration.seconds(1), event -> {
//                    imageView.setTranslateX(10);
//                    imageView.setTranslateY(0);
//                }),
//                new KeyFrame(Duration.seconds(1), event -> {
//                    imageView.setTranslateX(20);
//                    imageView.setTranslateY(0);
//                }),
//                new KeyFrame(Duration.seconds(1), event -> {
//                    imageView.setTranslateX(30);
//                    imageView.setTranslateY(0);
//                }),
//                new KeyFrame(Duration.seconds(1), event -> {
//                    imageView.setTranslateX(40);
//                    imageView.setTranslateY(0);
//                })
//
//
//
//
//
//
//        );
        // (KeyFrame)


//        Pane groot = new Pane();
//
//        Image image1 = new Image("graues Auto.jpg");
//
//
//        ImageView imageVieh = new ImageView(image1);
//        imageVieh.setFitWidth(200);
//        imageVieh.setPreserveRatio(true);
//
//
//        groot.getChildren().add(imageVieh);
//
//
//        Timeline timeline1 = new Timeline(
//                new KeyFrame(Duration.ZERO, event1 -> {
//                    imageVieh.setTranslateX(0);
//                    imageVieh.setTranslateY(0);
//                }),
//                new KeyFrame(Duration.seconds(2), event1 -> {
//                    imageVieh.setTranslateX(200);
//                    imageVieh.setTranslateY(200);
//                }));
//        (KeyFrame)
//
//
//                Pane groot1 = new Pane();
//
//        Image image2 = new Image("aston-martin-amr22.jpg");
//
//
//        ImageView imageViech = new ImageView(image2);
//        imageViech.setFitWidth(200);
//        imageViech.setPreserveRatio(true);
//
//
//        groot1.getChildren().add(imageViech);
//
//
//        Timeline timeline2 = new Timeline(
//                new KeyFrame(Duration.ZERO, event2 -> {
//                    imageViech.setTranslateX(0);
//                    imageViech.setTranslateY(0);
//                }),
//                new KeyFrame(Duration.seconds(2), event2 -> {
//                    imageViech.setTranslateX(200);
//                    imageViech.setTranslateY(200);
//                })
//
//
//        );

        //timeline.play();
        //timeline1.play();
        //timeline3.play();

//        Scene scene1 = new Scene(pane, HEIGHT, WIDTH);
//
//
//        primaryStage.setTitle("Beweg");
//        primaryStage.setScene(scene1);
//        primaryStage.setFullScreen(true);
//        primaryStage.show();


    }

    private ImageView imageView;
    //private static final int MOVE_DISTANCE = 10;

    public void ImageMovement(ImageView imageView) {
        this.imageView = imageView;
    }

    public void startMovement() {

    }

//    public void update() {
//        Ferrari.x = Ferrari.x + 1;
//        Ferrari.x = Ferrari.x + 1;
//        Aston.x = Aston.x + 1;
//        Aston.y = Aston.y + 1;
//        Audi.x = Audi.x + 1;
//        Audi.y = Audi.y + 1;
//
//    }

    public Parent getRoot() {
        return groot;
    }

}
