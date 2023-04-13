package com.schoolmanagementsystem.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.schoolmanagementsystem.users.LoginValidator;

import java.net.URL;
import java.util.ResourceBundle;

public class loginController implements Initializable {

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

    public loginController() {
    }

    public loginController(int id, String pass) {
        this.id = id;
        this.pass = pass;
    }

    @FXML
    void loginVerify(ActionEvent event) {

        id = Integer.parseInt(loginid.getText());
        pass = loginpass.getText();

        loginController login = new loginController(id, pass);

        try {
            int ans = LoginValidator.log(login);
            if(ans == 0) {
                loggable.setText("Invalid Id. Register first");
            } else if (ans == 1) {
                loggable.setText("Invalid password. Try again");
            }
        }
        catch (Exception e) {
            System.out.println(e);
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

    }
}
