package com.schoolmanagementsystem.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    protected Button home;

    @FXML
    protected Button login;

    @FXML
    protected Button notice;

    @FXML
    protected MenuButton other;

    @FXML
    protected MenuButton profile;

    @FXML
    protected MenuButton reg;

    @FXML
    private MenuButton result;

    @FXML
    protected MenuButton routine;

    @FXML
    protected VBox vbox;

    protected Stage stage;

    @FXML
    void emplyReg(ActionEvent event) throws IOException {
        loadPage("menuButton","/com/schoolmanagementsystem/employeeRegistrationForm.fxml",event);
    }

    @FXML
    void handleHome(ActionEvent event) throws IOException {
        loadPage("button","/com/schoolmanagementsystem/home.fxml",event);


//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/schoolmanagementsystem/home.fxml"));
//        Parent root = fxmlLoader.load();
//
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        HomeController controller = fxmlLoader.getController();
//
//        System.out.println(loginController.getLoggedInPerson());
//
//        if(Objects.equals(loginController.getLoggedInPerson(), "Teacher")) {
////            controller.login.setText("Log out");
////            controller.reg.setVisible(false);
////            controller.reg.setManaged(false);
////            VBox.getVgrow(controller.login);
//        }
//
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();

    }

    @FXML
    void handleLogin(ActionEvent event) throws IOException {
        if(loginController.getLoggedInPerson() == null){
            loadPage("button","/com/schoolmanagementsystem/login.fxml",event);
        }
        else{
            String m1 = "You are about to log out.";
            String m2 = "Your current session will be over. \nFor further use you need to log in again.";
            if(handleAlert(m1,m2)){
                loginController.setLoggedInPerson(null);
                handleHome(event);
            }
        }

//        loadPage("button","/com/schoolmanagementsystem/login.fxml",event);
    }

    @FXML
    void handleNotice(MouseEvent event) {

    }

    @FXML
    void handleOthers(MouseEvent event) {

    }

    @FXML
    void handleResult(MouseEvent event) {

    }

    @FXML
    void handleRoutine(MouseEvent event) {

    }

    @FXML
    void handleStaffProfile(ActionEvent event) throws IOException {
        loadPage("menuButton","/com/schoolmanagementsystem/staff.fxml",event);
    }

    @FXML
    void handleStudentProfile(ActionEvent event) throws IOException {
        loadPage("menuButton","/com/schoolmanagementsystem/student.fxml",event);
    }

    @FXML
    void handleTeacherProfile(ActionEvent event) throws IOException {
        loadPage("menuButton","/com/schoolmanagementsystem/teacher.fxml",event);
    }

    @FXML
    void studReg(ActionEvent event) throws IOException {
        loadPage("menuButton","/com/schoolmanagementsystem/studentRegistrationForm.fxml",event);
    }


    void loadPage(String buttonType, String str, ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(str));
        Parent root = fxmlLoader.load();

        if(Objects.equals(buttonType, "menuButton")){
            stage = (Stage)((MenuItem)event.getSource()).getParentPopup().getOwnerWindow();
        }
        else if(Objects.equals(buttonType, "button")){
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        }
        else if(Objects.equals(buttonType, "hyperLink")){
            stage = (Stage)((Hyperlink)event.getSource()).getScene().getWindow();
        }

        Controller controller = fxmlLoader.getController();

        if(Objects.equals(loginController.getLoggedInPerson(), "Teacher")) {
            controller.reg.setVisible(false);
            controller.reg.setManaged(false);
            controller.login.setText("Log out");
            controller.vbox.setStyle("-fx-background-color:  #720D05;");
        }

        if(Objects.equals(loginController.getLoggedInPerson(), "Staff")) {
            controller.reg.setVisible(false);
            controller.reg.setManaged(false);

            controller.result.setVisible(false);
            controller.result.setManaged(false);

            controller.routine.setVisible(false);
            controller.routine.setManaged(false);

            controller.login.setText("Log out");
            controller.vbox.setStyle("-fx-background-color:  #044C05;");
        }

        if(Objects.equals(loginController.getLoggedInPerson(), "Admin")) {
            controller.login.setText("Log out");
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public boolean validateNum(String str) {
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

    public boolean validateDate(DatePicker str) {
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

    public boolean handleAlert(String message1, String message2) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Alert");
        alert.setHeaderText(message1);
        alert.setContentText(message2);

        if (alert.showAndWait().get() == ButtonType.OK) {
            return true;
        }

        return false;
    }

    public String uploadImage(Stage stage, ImageView Img, Button imgButton) {
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
