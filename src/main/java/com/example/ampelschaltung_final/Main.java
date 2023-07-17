package com.example.ampelschaltung_final;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

import java.io.IOException;

import static java.time.Clock.tick;

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
    Timeline timeline3 = new Timeline();
    Timeline timeline4 = new Timeline();
    private ImageView imageView;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    Circle circle = new Circle(20, Color.GREEN);
    Circle circle2 = new Circle(20, Color.GREEN);
    Circle circle3 = new Circle(20, Color.GREEN);
    Circle circle4 = new Circle(20, Color.GREEN);
    Random auto = new Random();
    List<String> imagePaths = new ArrayList<>();
    String randomImagePath;
    String randomImagePath2;
    String randomImagePath3;
    String randomImagePath4;
    Button stop = new Button("Spiel beenden");
    Button start = new Button("Starten");
    private AnimationTimer timer;
    Button pause = new Button("Pause");
    public int punkte = 0;
    Label label = new Label("Punkte: " + punkte);
    Label text = new Label("Das Ziel ist es die Autos ohne Kollision über die Kreuzung zu navigieren.");
    Label text2 = new Label("Mit Rechtsklick können sie die Ampeln auf Grün setzen, mit Linksklick auf Rot.");
    public int tick = 0;


    @Override

    public void start(Stage primaryStage) {

        label.setFont(Font.font("Verdana", FontWeight.BLACK, FontPosture.REGULAR, 20));
        label.setLayoutX(1750);
        label.setLayoutY(10);
        text.setFont(Font.font("Verdana", FontWeight.BLACK, FontPosture.REGULAR, 20));
        text.setLayoutX(15);
        text.setLayoutY(700);
        text2.setFont(Font.font("Verdana", FontWeight.BLACK, FontPosture.REGULAR, 20));
        text2.setLayoutX(15);
        text2.setLayoutY(730);


        imagePaths.add("aston-martin-amr22.jpg");
        imagePaths.add("bmw.jpg");
        imagePaths.add("bugatti.jpg");
        imagePaths.add("Ferrari.jpg");
        imagePaths.add("graues Auto.jpg");
        imagePaths.add("oldtimer.jpg");
        imagePaths.add("opel.jpg");
        imagePaths.add("cabrio.jpg");
        imagePaths.add("dachfenster.jpg");
        imagePaths.add("futuristisch.jpg");
        imagePaths.add("lotus.jpg");
        imagePaths.add("old2.png");
        imagePaths.add("orange.png");
        imagePaths.add("polizei.png");
        imagePaths.add("porsche.jpg");
        imagePaths.add("rotes Auto.jpg");


        stop.setLayoutY(10);
        stop.setLayoutX(100);
        stop.setTranslateX(10);
        stop.setTranslateY(10);

        start.setLayoutY(10);
        start.setLayoutX(10);
        start.setTranslateX(10);
        start.setTranslateY(10);

        pause.setLayoutY(10);
        pause.setLayoutX(200);
        pause.setTranslateX(10);
        pause.setTranslateY(10);

        stop.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            primaryStage.close();
        });

        pause.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            timeline.stop();
            timeline2.stop();
            timeline3.stop();
            timeline4.stop();
            pause.setDisable(true);
        });




//        new AnimationTimer() {
//            long lastTick = 0;
//
//            public void handle(long now) {
//                if (lastTick == 0) {
//                    lastTick = now;
//                    tick(gc);
//                    return;
//                }
//
//                if (now - lastTick > 1000000000 / speed) {
//                    lastTick = now;
//                    tick(gc);
//                }
//            }
//
//        }.start();


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
        circle.setTranslateY(600);

        circle2.setLayoutX(1050);
        circle2.setLayoutY(400);

        circle3.setLayoutX(850);
        circle3.setLayoutY(400);

        circle4.setLayoutX(1050);
        circle4.setLayoutY(600);

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

        circle3.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            MouseButton mouseButton = event.getButton();
            if (mouseButton == MouseButton.PRIMARY) {
                circle3.setFill(Color.RED);
                istRot2 = true;
            } else if (mouseButton == MouseButton.SECONDARY) {
                circle3.setFill(Color.GREEN);
                istRot2 = false;
            }
        });

        circle4.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            MouseButton mouseButton = event.getButton();
            if (mouseButton == MouseButton.PRIMARY) {
                circle4.setFill(Color.RED);
                istRot2 = true;
            } else if (mouseButton == MouseButton.SECONDARY) {
                circle4.setFill(Color.GREEN);
                istRot2 = false;
            }
        });

        root.getChildren().add(circle);
        root.getChildren().add(circle2);
        root.getChildren().add(circle3);
        root.getChildren().add(circle4);
        root.getChildren().add(rectangle);
        root.getChildren().add(rectangle2);
        root.getChildren().add(rectangle3);
        root.getChildren().add(rectangle4);
        root.getChildren().add(rectangle5);
        root.getChildren().add(stop);
        root.getChildren().add(start);
        //root.getChildren().add(pause);
        root.getChildren().add(label);
        root.getChildren().add(text);
        root.getChildren().add(text2);


        //Image image = new Image("Ferrari.jpg");
        //ImageView imageView = new ImageView();

        //links nach rechts
        imageView = new ImageView();
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        imageView.setPreserveRatio(true);
        root.getChildren().add(imageView);


        //rechts nach links
        imageView2 = new ImageView();
        imageView2.setFitWidth(110);
        imageView2.setFitHeight(110);
        imageView2.setPreserveRatio(true);
        root.getChildren().add(imageView2);


        //oben nach unten
        imageView3 = new ImageView();
        imageView3.setFitWidth(110);
        imageView3.setFitHeight(110);
        imageView3.setPreserveRatio(true);
        root.getChildren().add(imageView3);


        //unten nach oben
        imageView4 = new ImageView();
        imageView4.setFitWidth(110);
        imageView4.setFitHeight(110);
        imageView4.setPreserveRatio(true);
        root.getChildren().add(imageView4);

        Thread collisionThread = new Thread(this::checkCollision);
        collisionThread.setDaemon(true);
        collisionThread.start();

//        AnimationTimer timer = new AnimationTimer() {
//            private long lastTick = 0;
//            private final long interval = 1;
//
//
//            public void handle(long now) {
//                if (now - lastTick >= interval) {
//                    tick++;
//                    System.out.println("Tick: " + tick);
//                    //checkCollision();
////                    if(imageView.getBoundsInParent().intersects(imageView3.getBoundsInParent())){
////                        System.out.println("Boom");
////                        //primaryStage.close();
////                    }
//                    primaryStage.sceneProperty().addListener((obs, oldScene, newScene) -> {
//                        newScene.setOnKeyPressed(event -> {
//                            if (doImageViewsCollide()) {
//                                System.out.println("Die ImageViews berühren sich!");
//                                // Hier kannst du den Code platzieren, der ausgeführt werden soll, wenn sich die ImageViews berühren
//                                primaryStage.close();
//                            }
//                        });
//                    });
//                    lastTick = now;
//                }
//            }
//        };


//        imageView.boundsInParentProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue.intersects(imageView3.getBoundsInParent())) {
//                //primaryStage.close();
//            }
//        });


        start.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            startTimeline();
            startTimeline2();
            startTimeline3();
            startTimeline4();
            start.setDisable(true);
        });

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
        //timer.start();



        //WARNUNG!!!! Dieser Code bringt das Spiel zum abstürzen!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//        while(scene.getWindow().isShowing()==true){
//            checkCollision(imageView, imageView2);
//        }

    }

    private void updateLabel(int value) {
        // Aktualisiere den Wert des Labels
        label.setText("Punkte: " + String.valueOf(value));
    }




    public void startTimeline() {
        randomImagePath = imagePaths.get(auto.nextInt(imagePaths.size()));
        imagePaths.remove(randomImagePath);
        Image image = new Image(randomImagePath);
        //ImageView imageView = new ImageView(image);
        imageView.setImage(image);
        imageView.setLayoutX(0);
        imageView.setLayoutY(505);

        //if (shouldStartTimeline()) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(MOVE_INTERVAL_MS), event -> {
            // Bewege das ImageView nach rechts
            imageView.setLayoutX(imageView.getLayoutX() + MOVE_DISTANCE);

            // Überprüfe, ob das ImageView den rechten Rand erreicht hat, und setze es zurück auf den linken Rand
            if (imageView.getLayoutX() == 1920) {
                imageView.setLayoutX(0);
                updateLabel(punkte = punkte + 1);
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        circle.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            MouseButton mouseButton = event.getButton();
            if (mouseButton == MouseButton.PRIMARY) {
                circle.setFill(Color.RED);
                //timeline.stop();
                if (imageView.getLayoutX() >= 550 && imageView.getLayoutX() <= 800) {
                    // timeline.stop();
                    if (circle.getFill() == Color.RED) {
                        timeline.stop();
                    }
                }
            } else if (mouseButton == MouseButton.SECONDARY) {
                circle.setFill(Color.GREEN);
                timeline.play();
            }
        });
        //}
    }


    public void startTimeline2() {
        randomImagePath2 = imagePaths.get(auto.nextInt(imagePaths.size()));
        imagePaths.remove(randomImagePath2);
        Image image2 = new Image(randomImagePath2);
        //ImageView imageView = new ImageView(image);
        imageView2.setImage(image2);
        imageView2.setLayoutX(1920);
        imageView2.setLayoutY(450);
        imageView2.setRotate(180);

        //if (shouldStartTimeline()) {
        Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(MOVE_INTERVAL_MS), event -> {
            // Bewege das ImageView nach rechts
            imageView2.setLayoutX(imageView2.getLayoutX() - MOVE_DISTANCE);

            // Überprüfe, ob das ImageView den rechten Rand erreicht hat, und setze es zurück auf den linken Rand
            if (imageView2.getLayoutX() == 0) {
                imageView2.setLayoutX(1920);
                updateLabel(punkte = punkte + 1);
            }
        }));
        timeline2.setCycleCount(Timeline.INDEFINITE);
        timeline2.play();

        circle2.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            MouseButton mouseButton = event.getButton();
            if (mouseButton == MouseButton.PRIMARY) {
                circle2.setFill(Color.RED);
                if (imageView2.getLayoutX() >= 1050 && imageView2.getLayoutX() <= 1300) {
                    // timeline.stop();
                    if (circle2.getFill() == Color.RED) {
                        timeline2.stop();
                    }
                }
            } else if (mouseButton == MouseButton.SECONDARY) {
                circle2.setFill(Color.GREEN);
                timeline2.play();
            }
        });
        //}
    }

    public void startTimeline3() {
        randomImagePath3 = imagePaths.get(auto.nextInt(imagePaths.size()));
        imagePaths.remove(randomImagePath3);
        Image image3 = new Image(randomImagePath3);
        //ImageView imageView = new ImageView(image);
        imageView3.setImage(image3);
        imageView3.setLayoutX(880);
        imageView3.setLayoutY(0);
        imageView3.setRotate(90);

        //if (shouldStartTimeline()) {
        Timeline timeline3 = new Timeline(new KeyFrame(Duration.millis(MOVE_INTERVAL_MS), event -> {
            // Bewege das ImageView nach rechts
            imageView3.setLayoutY(imageView3.getLayoutY() + MOVE_DISTANCE);

            // Überprüfe, ob das ImageView den rechten Rand erreicht hat, und setze es zurück auf den linken Rand
            if (imageView3.getLayoutY() == 1150) {
                imageView3.setLayoutY(-10);
                updateLabel(punkte = punkte + 1);
            }
        }));
        timeline3.setCycleCount(Timeline.INDEFINITE);
        timeline3.play();

        circle3.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            MouseButton mouseButton = event.getButton();
            if (mouseButton == MouseButton.PRIMARY) {
                circle3.setFill(Color.RED);
                if (imageView3.getLayoutY() >= 100 && imageView3.getLayoutY() <= 350) {
                    if (circle3.getFill() == Color.RED) {
                        timeline3.stop();
                    }
                }
            } else if (mouseButton == MouseButton.SECONDARY) {
                circle3.setFill(Color.GREEN);
                timeline3.play();
            }
        });
        //}
    }

    public void startTimeline4() {
        randomImagePath4 = imagePaths.get(auto.nextInt(imagePaths.size()));
        imagePaths.remove(randomImagePath4);
        Image image4 = new Image(randomImagePath4);
        //ImageView imageView = new ImageView(image);
        imageView4.setImage(image4);
        imageView4.setLayoutX(935);
        imageView4.setLayoutY(1150);
        imageView4.setRotate(270);

        //if (shouldStartTimeline()) {
        Timeline timeline4 = new Timeline(new KeyFrame(Duration.millis(MOVE_INTERVAL_MS), event -> {
            // Bewege das ImageView nach rechts
            imageView4.setLayoutY(imageView4.getLayoutY() - MOVE_DISTANCE);

            // Überprüfe, ob das ImageView den rechten Rand erreicht hat, und setze es zurück auf den linken Rand
            if (imageView4.getLayoutY() == 0) {
                imageView4.setLayoutY(1150);
                updateLabel(punkte = punkte + 1);
            }
        }));
        timeline4.setCycleCount(Timeline.INDEFINITE);
        timeline4.play();

        circle4.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            MouseButton mouseButton = event.getButton();
            if (mouseButton == MouseButton.PRIMARY) {
                circle4.setFill(Color.RED);
                if (imageView4.getLayoutY() >= 450 && imageView4.getLayoutY() <= 700) {
                    if (circle4.getFill() == Color.RED) {
                        timeline4.stop();
                    }
                }
            } else if (mouseButton == MouseButton.SECONDARY) {
                circle4.setFill(Color.GREEN);
                timeline4.play();
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

    public void timer(){

    }

//    public void checkCollision(){
//        if(imageView.getBoundsInParent().intersects(imageView3.getBoundsInParent())){
//            System.out.println("Boom");
//
//        }
//
//
//    }

    private void checkCollision() {
        while (true) {
            if (doImageViewsCollide()) {
                Platform.runLater(() -> {
                    System.out.println("Die ImageViews berühren sich!");
                    // Hier kannst du den Code platzieren, der ausgeführt werden soll, wenn sich die ImageViews berühren
                });
            }

            try {
                Thread.sleep(100); // Überprüfe alle 100 Millisekunden
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean doImageViewsCollide() {
        double imageViewX = imageView.getLayoutX();
        double imageViewY = imageView.getLayoutY();
        double imageViewWidth = imageView.getBoundsInParent().getWidth();
        double imageViewHeight = imageView.getBoundsInParent().getHeight();

        double imageView3X = imageView3.getLayoutX();
        double imageView3Y = imageView3.getLayoutY();
        double imageView3Width = imageView3.getBoundsInParent().getWidth();
        double imageView3Height = imageView3.getBoundsInParent().getHeight();

        // Überprüfe die Kollision der Bounding Boxes
        if (imageViewX < imageView3X + imageView3Width &&
                imageViewX + imageViewWidth > imageView3X &&
                imageViewY < imageView3Y + imageView3Height &&
                imageViewY + imageViewHeight > imageView3Y) {
            return true; // Kollision
        } else {
            return false; // Keine Kollision
        }
    }

//    public void collisionCheckThread()
//    {
//        collisionThread = new Thread(){
//            @Override
//            public void run(){
//                while(scene.getWindow().isShowing() == true){
//                    checkCollision(wolfIv,eggsList.get(0));
//                }
//
//            }
//        };
//        collisionThread.start();
//    }

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
