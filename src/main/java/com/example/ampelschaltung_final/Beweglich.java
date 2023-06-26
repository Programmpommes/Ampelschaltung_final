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

        // Lade das Bild
        Image image = new Image("pfad/zum/dein-bild.png");

        // Erstelle ein ImageView, um das Bild anzuzeigen
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(200); // Breite des Bildes anpassen
        imageView.setPreserveRatio(true); // Beibehaltung des Seitenverhältnisses des Bildes

        // Füge das ImageView dem Pane hinzu
        root.getChildren().add(imageView);

        // Erstelle eine Timeline-Animation für die Bewegung des Bildes
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, event -> {
                    // Initialposition des Bildes
                    imageView.setTranslateX(0);
                    imageView.setTranslateY(0);
                }),
                new KeyFrame(Duration.seconds(2), event -> {
                    // Zielposition des Bildes
                    imageView.setTranslateX(200);
                    imageView.setTranslateY(200);
                })
        );
        timeline.setCycleCount(Animation.INDEFINITE); // Wiederhole die Animation unendlich oft
        timeline.setAutoReverse(true); // Reverse die Animation nach jedem Durchlauf

        // Starte die Animation
        timeline.play();


    }
}
