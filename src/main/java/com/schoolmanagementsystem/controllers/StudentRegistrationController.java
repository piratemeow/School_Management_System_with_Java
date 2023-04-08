package com.schoolmanagementsystem.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ResourceBundle;

public class StudentRegistrationController implements Initializable {

    @FXML
    private TextField address;

    @FXML
    private ChoiceBox<Integer> classNumber;

    @FXML
    private TextField contact;

    @FXML
    private DatePicker dob;

    @FXML
    private TextField fname;

    @FXML
    private ChoiceBox<String> gender;

    @FXML
    private TextField id;

    @FXML
    private TextField mname;

    @FXML
    private Button register;

    @FXML
    private TextField roll;

    @FXML
    private ChoiceBox<String> section;

    @FXML
    private TextField sname;

    @FXML
    private ImageView studImg;

    @FXML
    private Label wrongInput;

    @FXML
    private  Button cross;

    public DatePicker getDob() {
        return dob;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gender.getItems().addAll("Male","Female");
        classNumber.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
        section.getItems().addAll("A","B","C");
        cross.setVisible(false);
    }

    public void submitHandler() {
        if(id.getText().isEmpty() || sname.getText().isEmpty() || fname.getText().isEmpty() || mname.getText().isEmpty() || roll.getText().isEmpty() || contact.getText().isEmpty() || address.getText().isEmpty()) {
            wrongInput.setText("Incorrect Input. Please give correct information");
            cross.setVisible(true);
        } else if (gender.getValue() == null || classNumber.getValue() == null || section.getValue() == null || dob.getValue() == null) {
            wrongInput.setText("Incorrect Input. Please give correct information");
            cross.setVisible(true);
        } else if (Controller.validateNum(roll.getText().toString()) || Controller.validateNum(id.getText().toString()) || Controller.validateNum(contact.getText().toString()) || contact.getText().toString().length() != 11 || Controller.validateDate(dob)) {
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