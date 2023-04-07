package com.schoolmanagementsystem;

import com.schoolmanagementsystem.controllers.HomeController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        HomeController controller = new HomeController();
        try {
            controller.loadFXML();
            Platform.runLater(() -> controller.getStage().show());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

