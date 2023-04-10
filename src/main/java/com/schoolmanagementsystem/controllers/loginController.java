//package com.schoolmanagementsystem.controllers;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.PasswordField;
//import javafx.scene.control.TextField;
//import javafx.scene.input.InputMethodEvent;
//
//public class loginController {
//
//    @FXML
//    private Button loginbutton;
//
//    @FXML
//    private TextField loginid;
//
//    @FXML
//    private Label loginlable;
//
//    @FXML
//    private PasswordField loginpass;
//
//    private String id,pass;
//
//    @FXML
//    void getId(ActionEvent event) {
//        id = loginid.getText();
//
//    }
//
//    @FXML
//    void getPass(ActionEvent event) {
//
//        pass = loginpass.getText();
//
//    }
//
//    @FXML
//    void loginVerify(ActionEvent event) {
//
//        id = loginid.getText();
//        if (id.equals("Imran"))
//        {
//            System.out.println("Yes");
//        }
//
//    }
//
//}


package com.schoolmanagementsystem.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.schoolmanagementsystem.users.LoginValidator;
import javafx.scene.input.InputMethodEvent;

public class loginController {



    @FXML
    private Button loginbutton;

    @FXML
    private TextField loginid;

    @FXML
    private Label loginlable;

    @FXML
    private PasswordField loginpass;

    private int id;
    private String pass;

    @FXML
    void loginVerify(ActionEvent event) {

        id = Integer.parseInt(loginid.getText());
        pass = loginpass.getText();

        loginController login = new loginController();
        login.pass = pass;
        login.id = id;

        try {
            LoginValidator.log(login);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }


    }

    public int getId() {
        return id;
    }

    public String getPass() {
        return pass;
    }
//    public int id_validity()
//    {
//        return id;
//    }
//
//    public String pas_validity()
//    {
//        return pass;
//    }

}
