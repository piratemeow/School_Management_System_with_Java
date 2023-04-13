package com.schoolmanagementsystem.controllers;

import com.schoolmanagementsystem.database.EmployeeCRUD;
import com.schoolmanagementsystem.database.LoginCRUD;
import com.schoolmanagementsystem.database.StudentCRUD;
import com.schoolmanagementsystem.users.Employee;
import com.schoolmanagementsystem.users.Student;
import javafx.event.ActionEvent;
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
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.SQLException;
import java.time.Year;
import java.util.Random;
import java.util.ResourceBundle;

public class EmployeeRegistrationController implements Initializable {

    private String imgPath;
    private Stage stage;
    @FXML
    Button imgButton;
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
    private TextField religion;

    @FXML
    private ChoiceBox<String> marital;

    @FXML
    private TextField mname;

    @FXML
    private PasswordField password;

    @FXML
    private Button register;

    @FXML
    private Button cross;

    @FXML
    private ImageView Img;

    @FXML
    private Label wrongInput;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gender.getItems().addAll("Male", "Female");
        marital.getItems().addAll("Married", "Unmarried");
        designation.getItems().addAll("Teacher", "Others");
        cross.setVisible(false);
    }

    public void submitHandler() throws SQLException, FileNotFoundException {
        if (religion.getText().isEmpty() || ename.getText().isEmpty() || fname.getText().isEmpty()
                || mname.getText().isEmpty() || password.getText().isEmpty() || contact.getText().isEmpty()
                || address.getText().isEmpty()) {
            wrongInput.setText("Incorrect Input. Please give correct information");
            cross.setVisible(true);
        } else if (gender.getValue() == null || marital.getValue() == null || designation.getValue() == null
                || dob.getValue() == null) {
            wrongInput.setText("Incorrect Input. Please give correct information");
            cross.setVisible(true);
        } else if (Controller.validateNum(contact.getText()) || contact.getText().length() != 11
                || Controller.validateDate(dob)) {
            wrongInput.setText("Incorrect Input. Please give correct information");
            cross.setVisible(true);
        } else {
            int year = Year.now().getValue();

            Random rand = new Random();

            int id = 1000 * year + rand.nextInt(100, 999);
            String message = "Your id is " + id + "\nPlease remember this id for further access.";

            if (Controller.handleAlert(message)) {
                wrongInput.setText("Congratulation. You have successfully Registered");
                cross.setVisible(true);

                Employee emp = new Employee(id, ename.getText(), contact.getText(), address.getText(), dob.getValue(),
                        gender.getValue(), fname.getText(), mname.getText(), religion.getText(), designation.getValue(),
                        marital.getValue(), password.getText());

                EmployeeCRUD empCrud = new EmployeeCRUD();
                empCrud.addEmployee(emp, imgPath);

                LoginCRUD loginCRUD = new LoginCRUD();
                loginCRUD.addNewLoginInfo(emp);
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
