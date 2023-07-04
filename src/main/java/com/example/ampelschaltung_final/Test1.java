package com.example.ampelschaltung_final;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Test1 extends Application{
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int MOVE_DISTANCE = 10;
    private static final int MOVE_INTERVAL_MS = 100;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("ImageView Movement");

        // Erstelle ein ImageView und lade ein Bild
        Image image = new Image("Ferrari.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        imageView.setPreserveRatio(true);

        // Erstelle ein Pane und füge das ImageView hinzu
        Pane pane = new Pane();
        pane.getChildren().add(imageView);

        // Erstelle eine Timeline, um das ImageView zu bewegen
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

        // Erstelle die Szene und füge das Pane hinzu
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
