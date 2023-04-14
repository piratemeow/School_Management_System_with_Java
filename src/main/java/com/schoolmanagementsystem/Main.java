package com.schoolmanagementsystem;

import com.schoolmanagementsystem.controllers.HomeController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
//        HomeController controller = new HomeController();
        try {
//            controller.loadFXML();
////            controller.getStage().show();
//            Platform.runLater(() -> controller.getStage().show());



            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home.fxml"));
            Parent root = fxmlLoader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("School Management System");

            String url = getClass().getResource("image/icon.png").toExternalForm();
            Image icon = new Image(url);
            stage.getIcons().add(icon);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

