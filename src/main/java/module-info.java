module com.schoolmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.schoolmanagementsystem to javafx.fxml;
    opens com.schoolmanagementsystem.controllers to javafx.fxml;
    
    exports com.schoolmanagementsystem;
    exports com.schoolmanagementsystem.controllers;
}
