package com.schoolmanagementsystem.controllers;

import com.schoolmanagementsystem.database.StudentCRUD;
import com.schoolmanagementsystem.users.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.SQLException;
import java.time.Year;
import java.util.Random;
import java.util.ResourceBundle;

public class StudentRegistrationController implements Initializable {

    private Stage stage;

    private String imgPath;
    @FXML
    Button imgButton;

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
    private TextField religion;

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
    private ImageView Img;

    @FXML
    private Label wrongInput;

    @FXML
    private Button cross;

    public DatePicker getDob() {
        return dob;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gender.getItems().addAll("Male", "Female");
        classNumber.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        section.getItems().addAll("A", "B", "C");
        cross.setVisible(false);
    }

    public void submitHandler() throws SQLException, FileNotFoundException {
        if (religion.getText().isEmpty() || sname.getText().isEmpty() || fname.getText().isEmpty()
                || mname.getText().isEmpty() || roll.getText().isEmpty() || contact.getText().isEmpty()
                || address.getText().isEmpty()) {
            wrongInput.setText("Incorrect Input. Please give correct information");
            cross.setVisible(true);
        } else if (gender.getValue() == null || classNumber.getValue() == null || section.getValue() == null
                || dob.getValue() == null) {
            wrongInput.setText("Incorrect Input. Please give correct information");
            cross.setVisible(true);
        } else if (Controller.validateNum(roll.getText()) || Controller.validateNum(contact.getText())
                || contact.getText().length() != 11 || Controller.validateDate(dob)) {
            wrongInput.setText("Incorrect Input. Please give correct information");
            cross.setVisible(true);
        } else {
            int clas = Integer.parseInt(classNumber.getValue().toString());

            int year = Year.now().getValue();

            Random rand = new Random();

            int id = 100000 * year + 10000 * clas + rand.nextInt(1000, 9999);
            String message = "Your id is " + id + "\nPlease remember this id for further access.";

            if (Controller.handleAlert(message)) {
                wrongInput.setText("Congratulation. You have successfully Registered");
                cross.setVisible(true);

                Student st = new Student(id, sname.getText(), contact.getText(), address.getText(), dob.getValue(),
                        gender.getValue(), fname.getText(), mname.getText(), religion.getText(), clas,
                        section.getValue(), Integer.parseInt(roll.getText()));
                StudentCRUD stCrud = new StudentCRUD();
                stCrud.addStudent(st, imgPath);
            }
        }
    }

    public void handleCross() {
        if (cross.isVisible()) {
            cross.setVisible(false);
            wrongInput.setText("");
        } else {
            cross.setVisible(true);
        }
    }

    public void handleImgUpload(ActionEvent actionEvent) {
        imgPath = Controller.uploadImage(stage, Img, imgButton);
    }
}