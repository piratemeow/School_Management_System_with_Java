package com.schoolmanagementsystem.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private Button home;

    @FXML
    private Button login;

    @FXML
    private Button notice;

    @FXML
    private MenuButton other;

    @FXML
    private MenuButton profile;

    @FXML
    private MenuButton reg;

    @FXML
    private MenuButton result;

    @FXML
    private MenuButton routine;

    void loadPage(boolean isMenuButton, String str, ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(str));
        Parent root = fxmlLoader.load();
        if(isMenuButton){
            stage = (Stage)((MenuItem)event.getSource()).getParentPopup().getOwnerWindow();
        }
        else{
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void handleHome(ActionEvent event) throws IOException {
        loadPage(false,"/com/schoolmanagementsystem/home.fxml",event);
    }

    @FXML
    void handleLogin(ActionEvent event) throws IOException {
        loadPage(false,"/com/schoolmanagementsystem/login.fxml",event);
    }

    @FXML
    void handleNotice(ActionEvent event) {

    }

    @FXML
    void handleOthers(ActionEvent event) {

    }

    @FXML
    void handleStudentProfile(ActionEvent event) throws IOException {
        loadPage(true,"/com/schoolmanagementsystem/student.fxml",event);
    }

    @FXML
    void handleTeacherProfile(ActionEvent event) throws IOException {
        loadPage(true,"/com/schoolmanagementsystem/teacher.fxml",event);
    }

    @FXML
    void handleStaffProfile(ActionEvent event) throws IOException {
        loadPage(true,"/com/schoolmanagementsystem/staff.fxml",event);
    }


    @FXML
    void handleResult(ActionEvent event) {

    }

    @FXML
    void handleRoutine(ActionEvent event) {

    }

    private Stage stage;

    public HomeController() {
        stage = new Stage();
    }

    public Stage getStage() {
        return stage;
    }

    public void loadFXML() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/schoolmanagementsystem/home.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("School Management System");
    }

    public void studReg(ActionEvent actionEvent) throws IOException {
        loadPage(true,"/com/schoolmanagementsystem/studentRegistrationForm.fxml",actionEvent);
    }

    public void emplyReg(ActionEvent actionEvent) throws IOException {
        loadPage(true,"/com/schoolmanagementsystem/employeeRegistrationForm.fxml",actionEvent);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
