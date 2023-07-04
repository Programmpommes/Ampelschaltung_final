package com.example.ampelschaltung_final;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    //Ampel op = new Ampel();
    Beweglich beweg=new Beweglich();



    @Override

    public void start(Stage primaryStage) {

        Ampel firstClass = new Ampel();
        firstClass.start(primaryStage);
        Scene firstScene = new Scene(firstClass.getRoot());

        Beweglich secondClass = new Beweglich();
        secondClass.start(primaryStage);
        Scene secondScene = new Scene(secondClass.getRoot());


        primaryStage.setTitle("Ampelschaltung");
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.setFullScreen(true);

        TilePane container = new TilePane();

        //HBox container = new HBox();
        container.getChildren().addAll(firstClass.getRoot(), secondClass.getRoot());
        //container.getChildren().add(secondClass.pane);


        Scene mainScene = new Scene(container);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

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
