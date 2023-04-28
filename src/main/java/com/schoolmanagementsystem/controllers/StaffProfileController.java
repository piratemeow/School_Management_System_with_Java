package com.schoolmanagementsystem.controllers;

import com.schoolmanagementsystem.database.ConnectDatabase;
import com.schoolmanagementsystem.database.LoginCRUD;
import com.schoolmanagementsystem.database.StaffCRUD;
import com.schoolmanagementsystem.database.StudentCRUD;
import javafx.event.ActionEvent;
import javafx.event.Event;
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

public class StaffProfileController extends Controller {

    @FXML
    private Label staffName;

    @FXML
    private Label address;

    @FXML
    private Label conNum;

    @FXML
    private Label designation;

    @FXML
    private Label dob;

    @FXML
    private Label fname;

    @FXML
    private Label gender;

    @FXML
    private Label joinDate;

    @FXML
    private Label mname;

    @FXML
    private Label religion;

    @FXML
    private ImageView profilePic;

    @FXML
    private Label nam;

    @FXML
    private Label usrID;

    @FXML
    private Label update;

    @FXML
    private ImageView updateIcon;

    @FXML
    private Label delete;

    @FXML
    private ImageView deleteIcon;

    public void handleStaffProfile(Event event, int id) throws IOException, SQLException {
        FXMLLoader fxmlLoader = loadPage("button", "/com/schoolmanagementsystem/staff.fxml", event);

        StaffProfileController controller = fxmlLoader.getController();

        ConnectDatabase db = new ConnectDatabase();
        Connection con = db.getCon();

        String query = "SELECT * FROM employeeInfo WHERE employeeID = ?";

        PreparedStatement statement = con.prepareStatement(query);
        statement.setInt(1, id);

        ResultSet r = statement.executeQuery();

        byte[] imageData;

        if (r.next()) {
            controller.staffName.setText(r.getString("name").toUpperCase());
            controller.designation.setText(r.getString("profession").toUpperCase());
            controller.fname.setText(r.getString("fatherName").toUpperCase());
            controller.mname.setText(r.getString("motherName").toUpperCase());
            controller.dob.setText(String.valueOf(r.getDate("dateOfBirth")));
            controller.joinDate.setText(String.valueOf(r.getDate("joiningDate")));
            controller.religion.setText(r.getString("religion").toUpperCase());
            controller.gender.setText(r.getString("gender").toUpperCase());
            controller.address.setText(r.getString("address").toUpperCase());
            controller.conNum.setText(r.getString("contactNumber").toUpperCase());
            controller.nam.setText(r.getString("name").toUpperCase());
            controller.usrID.setText("ID : " + r.getInt("employeeID"));

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
        StaffRegistrationController controller = new StaffRegistrationController();
        controller.updateHelp(mouseEvent);
    }

    public void handleDelete(MouseEvent mouseEvent) throws IOException, SQLException {
        if(handleAlert("The profile will be permanently deleted from the record", "Are you sure to proceed ?")) {
            StaffCRUD crud = new StaffCRUD();
            crud.deleteStaff(Controller.requiredID);

            LoginCRUD loginCRUD = new LoginCRUD();
            loginCRUD.deleteLoginInfo(Controller.requiredID);
            handleStaffProfile(mouseEvent, Controller.requiredID);
        }
    }
}
