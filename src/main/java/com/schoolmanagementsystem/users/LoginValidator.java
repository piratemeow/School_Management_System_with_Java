package com.schoolmanagementsystem.users;

import com.schoolmanagementsystem.controllers.loginController;
import com.schoolmanagementsystem.database.ConnectDatabase;
import com.schoolmanagementsystem.database.LoginCRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginValidator{

    public static void log(loginController login) throws SQLException{
        ConnectDatabase db = new ConnectDatabase();
        Connection con = db.getCon();


        String query = "SELECT * FROM loginInfo WHERE ID = ? AND password = ?";
        PreparedStatement statement = con.prepareStatement(query);

        statement.setInt(1, login.getId());
        statement.setString(2, login.getPass());

        ResultSet r = statement.executeQuery();

        if (r.next())
        {
            System.out.println("Yes");
        }
        else
        {
            System.out.println("NO");
        }

    }
}