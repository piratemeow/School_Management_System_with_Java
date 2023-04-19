package com.schoolmanagementsystem.database;

import com.schoolmanagementsystem.users.Employee;
import com.schoolmanagementsystem.users.Teacher;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class TeacherCRUD {
    public void addTeacher(Teacher emp, String imgPath) throws SQLException, FileNotFoundException {
        ConnectDatabase db = new ConnectDatabase();
        Connection con = db.getCon();

        String insertQuery = "INSERT INTO employeeInfo (employeeID, name, profession, fatherName, motherName, subject, address, dateOfBirth, joiningDate, gender, contactNumber, religion, profilePicture) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement statement = con.prepareStatement(insertQuery);

        java.sql.Date sqlDate = java.sql.Date.valueOf(emp.getDateofbirth());

        LocalDate localDate = LocalDate.now();
        Date joinDate = Date.valueOf(localDate);

        // set values for the insert query
        statement.setInt(1, emp.getId());
        statement.setString(2, emp.getName());
        statement.setString(3, emp.getDesignation());
        statement.setString(4, emp.getFather());
        statement.setString(5, emp.getMother());
        statement.setString(6, emp.getSubject());
        statement.setString(7, emp.getAdderss());
        statement.setDate(8, sqlDate);
        statement.setDate(9, joinDate);
        statement.setString(10, emp.getGender());
        statement.setString(11, emp.getContact());
        statement.setString(12, emp.getReligion());

        FileInputStream fis = null;
        File file = new File(imgPath); // the path to the image file
        fis = new FileInputStream(file);
        statement.setBinaryStream(13, fis, (int) file.length());

        statement.executeUpdate();
    }
}
