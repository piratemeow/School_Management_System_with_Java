package com.schoolmanagementsystem.controllers;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Controller {
    public static boolean validateNum(String str) {
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                continue;
            }
            else {
                return true;
            }
        }
        return false;
    }

    public static boolean validateDate(DatePicker str) {
        LocalDate selectedDate = str.getValue();

        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate parsedDate = LocalDate.parse(dateFormatter.format(selectedDate), dateFormatter);
            if (!parsedDate.equals(selectedDate)) {
                return true;
            }
        } catch (DateTimeParseException e) {
            return true;
        }

        return false;
    }

    public static boolean handleAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Alert");
        alert.setHeaderText("You are about to register.");
        alert.setContentText(message);

        if (alert.showAndWait().get() == ButtonType.OK) {
            return true;
        }

        return false;
    }

    public static String uploadImage(Stage stage, ImageView Img, Button imgButton) {
        String imagePath = "";
        FileChooser fileChooser = new FileChooser();

        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            imagePath = selectedFile.getPath();
            Image image = new Image(selectedFile.toURI().toString());
            Img.setImage(image);
            Img.setFitHeight(135); // Set the height to 300 pixels
            Img.setFitWidth(170); // Set the width to 400 pixels
            imgButton.setVisible(false);
        }

        return imagePath;
    }
}
