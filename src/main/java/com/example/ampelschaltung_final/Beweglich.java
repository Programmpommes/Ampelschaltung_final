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


        Image image = new Image("pfad");


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
        );

        timeline.play();


    }
}
