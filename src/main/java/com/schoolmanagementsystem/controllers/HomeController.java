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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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


    @FXML
    void handleHome(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/schoolmanagementsystem/home.fxml"));
        Parent root = fxmlLoader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void handleLogin(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/schoolmanagementsystem/login.fxml"));
        Parent root = fxmlLoader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void handleNotice(MouseEvent event) {

    }

    @FXML
    void handleOthers(MouseEvent event) {

    }

    @FXML
    void handleProfile(MouseEvent event) {

    }


    @FXML
    void handleResult(MouseEvent event) {

    }

    @FXML
    void handleRoutine(MouseEvent event) {

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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/schoolmanagementsystem/studentRegistrationForm.fxml"));
        Parent root = fxmlLoader.load();

        stage = (Stage)((MenuItem)actionEvent.getSource()).getParentPopup().getOwnerWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void emplyReg(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/schoolmanagementsystem/employeeRegistrationForm.fxml"));
        Parent root = fxmlLoader.load();

        stage = (Stage)((MenuItem)actionEvent.getSource()).getParentPopup().getOwnerWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
