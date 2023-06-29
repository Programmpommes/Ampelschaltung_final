package com.example.ampelschaltung_final;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Beweglich extends Application {
    Ampel ampel1 = new Ampel();
    public Boolean halt = false;


    public void stopGo() {
        if (ampel1.istRot1 || ampel1.istRot2) {
            halt = true;
        } else if (!ampel1.istRot1 || !ampel1.istRot2) {
            halt = false;
        }
    }

    @Override
    public void start(Stage primaryStage) {

        Pane root = new Pane();


        Image image = new Image("src/main/resources/kisspng-car-ferrari-testarossa-laferrari-ferrari-275-lamborghini-top-view-5b1e13020f49b8.4702320015286976020626.jpg");


        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);


        root.getChildren().add(imageView);


        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, event -> {
                    imageView.setTranslateX(0);
                    imageView.setTranslateY(0);
                }),
                new KeyFrame(Duration.seconds(2), event -> {
                    imageView.setTranslateX(200);
                    imageView.setTranslateY(200);
                })



        
         Pane groot = new Pane();


        Image image1 = new Image("src/main/resources/kisspng-car-computer-icons-grey-car-top-view-icon-5ab0c1e90a67a3.2467640815215334170426.jpg");


        ImageView imageVieh = new ImageView(image1);
        imageVieh.setFitWidth(200);
        imageVieh.setPreserveRatio(true);


        groot.getChildren().add(imageVieh);


        Timeline timeline1 = new Timeline(
                new KeyFrame(Duration.ZERO, event1 -> {
                    imageVieh.setTranslateX(0);
                    imageVieh.setTranslateY(0);
                }),
                new KeyFrame(Duration.seconds(2), event1 -> {
                    imageVieh.setTranslateX(200);
                    imageVieh.setTranslateY(200);
                })
        );

        timeline.play();
        timeline1.play();


    }
}
