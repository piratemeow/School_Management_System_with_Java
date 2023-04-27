package com.schoolmanagementsystem.controllers;

import com.schoolmanagementsystem.database.ConnectDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentProfileController extends Controller {

    @FXML
    private Label address;

    @FXML
    private Label cls;

    @FXML
    private Label conNum;

    @FXML
    private Label dob;

    @FXML
    private Label fname;

    @FXML
    private Label gender;

    @FXML
    private Label mname;

    @FXML
    private Label nam;

    @FXML
    private ImageView profilePic;

    @FXML
    private Label religion;

    @FXML
    private Label roll;

    @FXML
    private Label sec;

    @FXML
    private Label sname;

    @FXML
    private Label usrID;

    @FXML
    private Label update;

    @FXML
    private ImageView updateIcon;

    public void handleStudentProfile(ActionEvent event, int id) throws IOException, SQLException {
        // loadPage("button","/com/schoolmanagementsystem/student.fxml",event);
        Controller.requiredID = id;

        FXMLLoader fxmlLoader = loadPage("button", "/com/schoolmanagementsystem/student.fxml", event);

        StudentProfileController controller = fxmlLoader.getController();

        ConnectDatabase db = new ConnectDatabase();
        Connection con = db.getCon();

        String query = "SELECT * FROM studentInfo WHERE studentID = ?";

        PreparedStatement statement = con.prepareStatement(query);
        statement.setInt(1, id);

        ResultSet r = statement.executeQuery();

        byte[] imageData;

        if (r.next()) {
            controller.sname.setText(r.getString("name").toUpperCase());
            controller.cls.setText(String.valueOf(r.getInt("class")));
            controller.roll.setText(String.valueOf(r.getInt("roll")));
            controller.fname.setText(r.getString("fatherName").toUpperCase());
            controller.mname.setText(r.getString("motherName").toUpperCase());
            controller.dob.setText(String.valueOf(r.getDate("dateOfBirth")));
            controller.sec.setText(r.getString("section").toUpperCase());
            controller.religion.setText(r.getString("religion").toUpperCase());
            controller.gender.setText(r.getString("gender").toUpperCase());
            controller.address.setText(r.getString("address").toUpperCase());
            controller.conNum.setText(r.getString("contactNumber").toUpperCase());
            controller.nam.setText(r.getString("name").toUpperCase());
            controller.usrID.setText("ID : " + r.getInt("studentID"));

            imageData = r.getBytes("profilePicture");
        } else {
            imageData = null;
        }
        // Convert the byte array to an Image
        Image image = createImageFromByteArray(imageData);

        if (image != null) {
            controller.profilePic.setImage(image);

            // Circle clip = new Circle();
            // clip.setCenterX(controller.profilePic.getFitWidth() / 2);
            // clip.setCenterY(controller.profilePic.getFitHeight() / 2 - 15);
            // clip.setRadius(Math.min(controller.profilePic.getFitWidth(),
            // controller.profilePic.getFitHeight()) / 2 - 15);
            //
            // controller.profilePic.setClip(clip);
            //
            // controller.profilePic.setStyle("-fx-border-radius: " + clip.getRadius() +
            // "px;");
        }
    }

    public void handleUpdate(MouseEvent mouseEvent) throws IOException, SQLException {
        StudentRegistrationController controller = new StudentRegistrationController();
        controller.updateHelp(mouseEvent);
    }
}
