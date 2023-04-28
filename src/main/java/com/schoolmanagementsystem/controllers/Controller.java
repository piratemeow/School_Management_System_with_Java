package com.schoolmanagementsystem.controllers;

import javafx.event.ActionEvent;
import javafx.event.Event;
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
import javafx.util.Pair;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

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
    protected Button profile;

    @FXML
    protected MenuButton reg;

    @FXML
    private MenuButton result;

    @FXML
    protected Button routine;

    @FXML
    protected VBox vbox;

    protected Stage stage;

    protected static boolean isUpdate;

    protected static int requiredID;

    protected static boolean routineFlag;

    @FXML
    void teacherReg(ActionEvent event) throws IOException {
        Controller.isUpdate = false;
        if(!Objects.equals(loginController.getLoggedInPerson(), "Admin")) {
            handleAlert("Registration Alert", "Only Admin has the right to add new teacher");
        }
        else {
            loadPage("menuButton", "/com/schoolmanagementsystem/teacherRegistrationForm.fxml", event);
        }
    }

    @FXML
    void staffReg(ActionEvent event) throws IOException {
        Controller.isUpdate = false;
        if(!Objects.equals(loginController.getLoggedInPerson(), "Admin")) {
            handleAlert("Registration Alert", "Only Admin has the right to add new staff");
        }
        else {
            loadPage("menuButton", "/com/schoolmanagementsystem/staffRegistrationForm.fxml", event);
        }
    }

    @FXML
    void studReg(ActionEvent event) throws IOException {
        Controller.isUpdate = false;
        if(!Objects.equals(loginController.getLoggedInPerson(), "Admin")) {
            handleAlert("Registration Alert", "Only Admin has the right to add new student");
        }
        else {
            loadPage("menuButton", "/com/schoolmanagementsystem/studentRegistrationForm.fxml", event);
        }
    }

    @FXML
    void handleHome(ActionEvent event) throws IOException {
        loadPage("button","/com/schoolmanagementsystem/home.fxml",event);
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
                loginController.setLoggedInID(0);
                RoutineController.setSelectedClass(0);
                RoutineController.setSelectedSection(null);
                handleHome(event);
            }
        }

//        loadPage("button","/com/schoolmanagementsystem/login.fxml",event);
    }

    @FXML
    void handleNotice(Event event) throws IOException, SQLException {
        if(loginController.getLoggedInPerson() == null){
            handleAlert("Alert", "Log in first to view your profile.");
        }
        else {
            NoticeController cont = new NoticeController();
            cont.handleNoticePage(event);
        }
    }

    @FXML
    void handleOthers(MouseEvent event) {

    }

    @FXML
    void handleResult(MouseEvent event) {

    }

    @FXML
    void handleRoutine(Event event) throws SQLException, IOException {
        if(loginController.getLoggedInPerson() == null){
            handleAlert("Alert", "Log in first to view routine.");
        }
        else {
            Controller.routineFlag = true;
            RoutineController cont = new RoutineController();
            cont.handleRoutinePage(event);
        }
    }

    @FXML
    void handleProfile(ActionEvent actionEvent) throws IOException, SQLException {
        if(loginController.getLoggedInPerson() == null) {
            handleAlert("Alert", "Log in first to view your profile.");
        }
        else if(loginController.getLoggedInPerson().equals("Teacher")){
            TeacherProfileController cont = new TeacherProfileController();
            cont.handleTeacherProfile(actionEvent, loginController.getLoggedInID());
        }
        else if(loginController.getLoggedInPerson().equals("Staff")){
            StaffProfileController cont = new StaffProfileController();
            cont.handleStaffProfile(actionEvent, loginController.getLoggedInID());
        }
        else if(loginController.getLoggedInPerson().equals("Admin")){
            loadPage("button", "/com/schoolmanagementsystem/chooseProfile.fxml", actionEvent);
        }
    }

//    @FXML
//    public void handleStaffProfile(ActionEvent event) throws IOException {
//        loadPage("button","/com/schoolmanagementsystem/staff.fxml",event);
//    }

//    @FXML
//    public void handleStudentProfile(ActionEvent event) throws IOException {
//        loadPage("button","/com/schoolmanagementsystem/student.fxml",event);
//    }

//    @FXML
//    public void handleTeacherProfile(ActionEvent event) throws IOException {
//        loadPage("button","/com/schoolmanagementsystem/teacher.fxml",event);
//    }


    public FXMLLoader loadPage(String buttonType, String str, Event event) throws IOException {
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
        else if(Objects.equals(buttonType, "label")) {
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
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

        return fxmlLoader;
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

    public Pair<String, String> passwordInputAlert() {

        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Verification");
        dialog.setHeaderText("Select your role and \nenter password of admin for security:");

        ButtonType loginButtonType = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

        ChoiceBox<String> roleChoice = new ChoiceBox<>();
        roleChoice.getItems().addAll("Teacher", "Staff");
        roleChoice.setValue("Teacher");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password of the admin");

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(roleChoice, passwordField);

        dialog.getDialogPane().setContent(vBox);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                return new Pair<>(roleChoice.getValue(), passwordField.getText());
            }
            return null;
        });

        // Wait for the user to close the dialog
        Optional<Pair<String, String>> result = dialog.showAndWait();

        return result.orElse(null);
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

    public Image createImageFromByteArray(byte[] data) throws IOException {
        if (data != null) {
            try (InputStream is = new ByteArrayInputStream(data)) {
                return new Image(is);
            }
        } else {
            return null;
        }
    }
}
