package com.schoolmanagementsystem.database;

import com.schoolmanagementsystem.users.Employee;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class LoginCRUD {

    public void addNewLoginInfo(Employee emp, String userType) throws SQLException {
        ConnectDatabase db = new ConnectDatabase();
        Connection con = db.getCon();

        String insertQuery = "INSERT INTO loginInfo (ID, userType, password) VALUES (?, ?, ?)";

        PreparedStatement statement = con.prepareStatement(insertQuery);

        // set values for the insert query
        statement.setInt(1, emp.getId());
        statement.setString(2, userType);
        statement.setString(3, emp.getPass());

        statement.executeUpdate();
    }
}
