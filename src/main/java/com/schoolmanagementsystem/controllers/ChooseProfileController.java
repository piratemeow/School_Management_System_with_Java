package com.schoolmanagementsystem.controllers;

import com.schoolmanagementsystem.database.ConnectDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class ChooseProfileController extends Controller implements Initializable {

    @FXML
    private Label invalid;
    @FXML
    private Label inputLabel;
    @FXML
    private Button otherProfile;

    @FXML
    private Button ok;
    @FXML
    private TextField input;
    @FXML
    private Button self;

    public void handleSelf(ActionEvent actionEvent) throws IOException, SQLException {
        Controller.requiredID = loginController.getLoggedInID();
        StaffProfileController cont = new StaffProfileController();
        cont.handleStaffProfile(actionEvent, loginController.getLoggedInID());
    }

    public void handleOther(ActionEvent actionEvent) {
        inputLabel.setVisible(true);
        input.setVisible(true);
        ok.setVisible(true);
    }

    public void handleOk(ActionEvent actionEvent) throws IOException, SQLException {
        String id = input.getText();
        String type = "";
        if (id.length() == 7) {
            type = "employee";
        } else if (id.length() == 9) {
            type = "Student";
        } else {
            invalid.setVisible(true);
            return;
        }
        // if(type.equals("student")) {
        // StudentProfileController cont = new StudentProfileController();
        // cont.handleStudentProfile(actionEvent);
        // return;
        // }
        int ID = Integer.parseInt(id);

        ConnectDatabase db = new ConnectDatabase();
        Connection con = db.getCon();

        String query;

        if (type.equals("Student")) {
            query = "SELECT * FROM studentInfo WHERE studentID = ?";
        } else {
            query = "SELECT * FROM loginInfo WHERE ID = ?";
        }
        PreparedStatement statement = con.prepareStatement(query);
        statement.setInt(1, ID);

        ResultSet r = statement.executeQuery();

        if (!r.next()) {
            invalid.setVisible(true);
            return;
        } else if (type.equals("employee")) {
            type = r.getString("userType");
        }
        Controller.requiredID = ID;

        if (Objects.equals(type, "Teacher")) {
            TeacherProfileController cont = new TeacherProfileController();
            cont.handleTeacherProfile(actionEvent, ID);
        } else if (Objects.equals(type, "Student")) {
            StudentProfileController cont = new StudentProfileController();
            cont.handleStudentProfile(actionEvent, ID);
        } else {
            StaffProfileController cont = new StaffProfileController();
            cont.handleStaffProfile(actionEvent, ID);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inputLabel.setVisible(false);
        input.setVisible(false);
        invalid.setVisible(false);
        ok.setVisible(false);
    }

    @FXML
    void inputChange(KeyEvent actionEvent) {
        invalid.setVisible(false);
    }
}
