package com.schoolmanagementsystem.controllers;
import com.schoolmanagementsystem.database.LoginCRUD;
import com.schoolmanagementsystem.database.StaffCRUD;
import com.schoolmanagementsystem.users.Staff;
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
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.SQLException;
import java.time.Year;
import java.util.Random;
import java.util.ResourceBundle;

public class StaffRegistrationController extends Controller implements Initializable {

    private String imgPath;
    private Stage stage;
    @FXML
    Button imgButton;
    @FXML
    private TextField address;

    @FXML
    private TextField contact;

    @FXML
    private TextField designation;

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
        cross.setVisible(false);
    }

    public void submitHandler() throws SQLException, FileNotFoundException {
        if (religion.getText().isEmpty() || ename.getText().isEmpty() || fname.getText().isEmpty()
                || mname.getText().isEmpty() || password.getText().isEmpty() || contact.getText().isEmpty()
                || address.getText().isEmpty() || designation.getText().isEmpty() || imgPath == null) {
            wrongInput.setText("Incorrect Input. Please give correct information");
            cross.setVisible(true);
        } else if (gender.getValue() == null || marital.getValue() == null
                || dob.getValue() == null) {
            wrongInput.setText("Incorrect Input. Please give correct information");
            cross.setVisible(true);
        } else if (validateNum(contact.getText()) || contact.getText().length() != 11
                || validateDate(dob)) {
            wrongInput.setText("Incorrect Input. Please give correct information");
            cross.setVisible(true);
        } else {
            int year = Year.now().getValue();

            Random rand = new Random();

            int id = 1000 * year + rand.nextInt(100, 999);
            String message1 = "You are about to register.";
            String message2 = "Your id is " + id + "\nPlease remember this id for further access.";

            if (handleAlert(message1,message2)) {
                wrongInput.setText("Congratulation. You have successfully Registered");
                cross.setVisible(true);

                Staff staff = new Staff(id, ename.getText(), contact.getText(), address.getText(), dob.getValue(),
                        gender.getValue(), fname.getText(), mname.getText(), religion.getText(), designation.getText(),
                        password.getText());

                StaffCRUD staffCrud = new StaffCRUD();
                staffCrud.addStaff(staff, imgPath);

                LoginCRUD loginCRUD = new LoginCRUD();
                loginCRUD.addNewLoginInfo(staff);
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
        imgPath = uploadImage(stage, Img, imgButton);
    }

}
