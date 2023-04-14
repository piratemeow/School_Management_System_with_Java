//package com.schoolmanagementsystem.controllers;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Hyperlink;
//import javafx.scene.control.MenuButton;
//import javafx.scene.control.MenuItem;
//import javafx.scene.image.Image;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.Objects;
//import java.util.ResourceBundle;
//
//
//public class HomeController implements Initializable {
//
//    @FXML
//    private VBox vbox;
//
//    @FXML
//    private Button home;
//
//    @FXML
//    private Button login;
//
//    @FXML
//    private Button notice;
//
//    @FXML
//    private MenuButton other;
//
//    @FXML
//    private MenuButton profile;
//
//    @FXML
//    private MenuButton reg;
//
//    @FXML
//    private MenuButton result;
//
//    @FXML
//    private MenuButton routine;
//
//    private Stage stage;
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//
//    }
//
//    void loadPage(String buttonType, String str, ActionEvent event) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(str));
//        Parent root = fxmlLoader.load();
//
//
//        if(buttonType == "menuButton"){
//            stage = (Stage)((MenuItem)event.getSource()).getParentPopup().getOwnerWindow();
//        }
//        else if(buttonType == "button"){
//            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        }
//        else if(buttonType == "hyperLink"){
//            stage = (Stage)((Hyperlink)event.getSource()).getScene().getWindow();
//        }
//
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
//
//
//    @FXML
//    void handleHome(ActionEvent event) throws IOException {
//        loadPage("button","/com/schoolmanagementsystem/home.fxml",event);
//    }
//
//    @FXML
//    void handleLogin(ActionEvent event) throws IOException {
//        loadPage("button","/com/schoolmanagementsystem/login.fxml",event);
//    }
//
//    @FXML
//    void handleNotice(ActionEvent event) {
//
//    }
//
//    @FXML
//    void handleOthers(ActionEvent event) {
//
//    }
//
//    @FXML
//    void handleStudentProfile(ActionEvent event) throws IOException {
//        loadPage("menuButton","/com/schoolmanagementsystem/student.fxml",event);
//    }
//
//    @FXML
//    void handleTeacherProfile(ActionEvent event) throws IOException {
//        loadPage("menuButton","/com/schoolmanagementsystem/teacher.fxml",event);
//    }
//
//    @FXML
//    void handleStaffProfile(ActionEvent event) throws IOException {
//        loadPage("menuButton","/com/schoolmanagementsystem/staff.fxml",event);
//    }
//
//
//    @FXML
//    void handleResult(ActionEvent event) {
//
//    }
//
//    @FXML
//    void handleRoutine(ActionEvent event) {
//
//    }
//
//
////    public HomeController() {
////        stage = new Stage();
////        this.vbox = new VBox();
////        this.reg = new MenuButton();
////    }
//
////    public Stage getStage() {
////        String url = getClass().getResource("/com/schoolmanagementsystem/image/icon.png").toExternalForm();
////        Image icon = new Image(url);
////        stage.getIcons().add(icon);
////        return stage;
////    }
//
////    public void loadFXML() throws IOException {
////        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/schoolmanagementsystem/home.fxml"));
////        Parent root = fxmlLoader.load();
////
////        Scene scene = new Scene(root);
////        stage.setScene(scene);
////        stage.setTitle("School Management System");
////    }
//
//    public void studReg(ActionEvent actionEvent) throws IOException {
//        loadPage("menuButton","/com/schoolmanagementsystem/studentRegistrationForm.fxml",actionEvent);
//    }
//
//    public void emplyReg(ActionEvent actionEvent) throws IOException {
//        loadPage("menuButton","/com/schoolmanagementsystem/employeeRegistrationForm.fxml",actionEvent);
//    }
//
//    public void setBackGround(ActionEvent event) throws IOException {
//        if(Objects.equals(loginController.loggedInPerson, "Teacher")) {
//            login.setVisible(false);
//            reg.setVisible(false);
//        }
//        handleHome(event);
//    }
//}






package com.schoolmanagementsystem.controllers;

import com.schoolmanagementsystem.users.LoginValidator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.scene.layout.Priority;


public class HomeController extends Controller implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

//    @FXML
//    private Button home;
//
//    @FXML
//    private Button login;
//
//    @FXML
//    private Button notice;
//
//    @FXML
//    private MenuButton other;
//
//    @FXML
//    private MenuButton profile;
//
//    @FXML
//    private MenuButton reg;
//
//    @FXML
//    private MenuButton result;
//
//    @FXML
//    private MenuButton routine;
//
//    @FXML
//    private VBox vbox;
//
//    private Stage stage;
//
//    @FXML
//    void emplyReg(ActionEvent event) throws IOException {
//        loadPage("menuButton","/com/schoolmanagementsystem/employeeRegistrationForm.fxml",event);
//    }
//
//    @FXML
//    void handleHome(ActionEvent event) throws IOException {
////        loadPage("button","/com/schoolmanagementsystem/home.fxml",event);
//
//
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
//
//    }
//
//    @FXML
//    void handleLogin(ActionEvent event) throws IOException {
//        loadPage("button","/com/schoolmanagementsystem/login.fxml",event);
//    }
//
//    @FXML
//    void handleNotice(MouseEvent event) {
//
//    }
//
//    @FXML
//    void handleOthers(MouseEvent event) {
//
//    }
//
//    @FXML
//    void handleResult(MouseEvent event) {
//
//    }
//
//    @FXML
//    void handleRoutine(MouseEvent event) {
//
//    }
//
//    @FXML
//    void handleStaffProfile(ActionEvent event) throws IOException {
//        loadPage("menuButton","/com/schoolmanagementsystem/staff.fxml",event);
//    }
//
//    @FXML
//    void handleStudentProfile(ActionEvent event) throws IOException {
//        loadPage("menuButton","/com/schoolmanagementsystem/student.fxml",event);
//    }
//
//    @FXML
//    void handleTeacherProfile(ActionEvent event) throws IOException {
//        loadPage("menuButton","/com/schoolmanagementsystem/teacher.fxml",event);
//    }
//
//    @FXML
//    void studReg(ActionEvent event) throws IOException {
//        loadPage("menuButton","/com/schoolmanagementsystem/studentRegistrationForm.fxml",event);
//    }
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//
//    }
//
//    void loadPage(String buttonType, String str, ActionEvent event) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(str));
//        Parent root = fxmlLoader.load();
//
//        if(buttonType == "menuButton"){
//            stage = (Stage)((MenuItem)event.getSource()).getParentPopup().getOwnerWindow();
//        }
//        else if(buttonType == "button"){
//            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        }
//        else if(buttonType == "hyperLink"){
//            stage = (Stage)((Hyperlink)event.getSource()).getScene().getWindow();
//        }
//
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }

}
