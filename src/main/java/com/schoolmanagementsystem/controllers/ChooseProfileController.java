package com.schoolmanagementsystem.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ChooseProfileController extends Controller implements Initializable {

    @FXML
    private Button otherProfile;

    @FXML
    private Button ok;
    @FXML
    private TextField input;
    @FXML
    private Button self;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void handleSelf(ActionEvent actionEvent) {
    }

    public void handleOther(ActionEvent actionEvent) {
    }

    public void handleOk(ActionEvent actionEvent) {
    }
}
