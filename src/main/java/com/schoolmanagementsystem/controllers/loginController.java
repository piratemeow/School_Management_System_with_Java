package com.schoolmanagementsystem.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.schoolmanagementsystem.users.LoginValidator;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class loginController extends Controller implements Initializable {

    private static String loggedInPerson;


    private Controller controller;
    @FXML
    private Button loginbutton;

    @FXML
    private TextField loginid;

    @FXML
    private Label loggable;

    @FXML
    private PasswordField loginpass;

    private int id;
    private String pass;

    public static String getLoggedInPerson() {
        return loggedInPerson;
    }


    public static void setLoggedInPerson(String loggedInPerson) {
        loginController.loggedInPerson = loggedInPerson;
    }

    public loginController() {
        controller = new Controller();
    }

    public loginController(int id, String pass) {
        this.id = id;
        this.pass = pass;
        loginController.loggedInPerson = null;
//        controller = new Controller();
    }

    @FXML
    void loginVerify(ActionEvent event) throws IOException {

        id = Integer.parseInt(loginid.getText());
        pass = loginpass.getText();

        loginController login = new loginController(id, pass);

        if(loginController.loggedInPerson == null) {
            try {
                int ans = LoginValidator.log(login);
                if (ans == 0) {
                    loggable.setText("Invalid Id. Register first");
                } else if (ans == 1) {
                    loggable.setText("Invalid password. Try again");
                } else {
                    loggable.setText("");
                    controller.handleHome(event);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            loginController.setLoggedInPerson(null);
            controller.handleHome(event);
        }

    }

    public int getId() {
        return id;
    }

    public String getPass() {
        return pass;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        loggedInPerson = "";
    }

    public void handleLink(ActionEvent actionEvent) throws IOException {
        controller.loadPage("hyperLink","/com/schoolmanagementsystem/employeeRegistrationForm.fxml",actionEvent);
    }
}
