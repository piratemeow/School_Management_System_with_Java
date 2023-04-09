package com.schoolmanagementsystem.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeRegistrationController implements Initializable {

    @FXML
    private TextField address;

    @FXML
    private TextField contact;

    @FXML
    private ChoiceBox<String> designation;

    @FXML
    private DatePicker dob;

    @FXML
    private TextField ename;

    @FXML
    private TextField fname;

    @FXML
    private ChoiceBox<String> gender;

    @FXML
    private TextField id;

    @FXML
    private ChoiceBox<String> marital;

    @FXML
    private TextField mname;

    @FXML
    private PasswordField password;

    @FXML
    private Button register;

    @FXML
    private  Button cross;

    @FXML
    private ImageView studImg;

    @FXML
    private Label wrongInput;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gender.getItems().addAll("Male","Female");
        marital.getItems().addAll("Married", "Unmarried");
        designation.getItems().addAll("Teacher","Others");
        cross.setVisible(false);
    }

    public void submitHandler() {
        if(id.getText().isEmpty() || ename.getText().isEmpty() || fname.getText().isEmpty() || mname.getText().isEmpty() || password.getText().isEmpty() || contact.getText().isEmpty() || address.getText().isEmpty()) {
            wrongInput.setText("Incorrect Input. Please give correct information");
            cross.setVisible(true);
        } else if (gender.getValue() == null || marital.getValue() == null || designation.getValue() == null || dob.getValue() == null) {
            wrongInput.setText("Incorrect Input. Please give correct information");
            cross.setVisible(true);
        } else if (Controller.validateNum(id.getText().toString()) || Controller.validateNum(contact.getText().toString()) || contact.getText().toString().length() != 11 || Controller.validateDate(dob)) {
            wrongInput.setText("Incorrect Input. Please give correct information");
            cross.setVisible(true);
        } else {
            if (Controller.handleAlert()) {
                wrongInput.setText("Congratulation. You have successfully Registered");
                cross.setVisible(true);
            }
        }
    }

    public void handleCross() {
        if(cross.isVisible()) {
            cross.setVisible(false);
            wrongInput.setText("");
        }
        else {
            cross.setVisible(true);
        }
    }

}
