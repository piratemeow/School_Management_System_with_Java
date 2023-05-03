package com.schoolmanagementsystem.database;

import com.schoolmanagementsystem.co_curricular.Club;
import com.schoolmanagementsystem.controllers.ClubController;
import com.schoolmanagementsystem.controllers.NoticeController;
import com.schoolmanagementsystem.models.Fee;

import java.sql.*;

public class ClubCRUD {

    public void addOrUpdateHelp(String ID, String query, String clubName) throws SQLException {
        ConnectDatabase db = new ConnectDatabase();
        Connection con = db.getCon();

        if(ID == null) {
            return;
        }

        PreparedStatement statement = con.prepareStatement(query);

        statement.setInt(1, Integer.parseInt(ID));
        statement.setString(2, clubName);
        statement.executeUpdate();
    }
    public void addOrUpdateClub(Club club) throws SQLException {
        ConnectDatabase db = new ConnectDatabase();
        Connection con = db.getCon();

        String query;
        PreparedStatement statement;

        if(ClubController.isAddClubFlag()) {
            query = "INSERT INTO club (clubName) VALUES (?)";
            statement = con.prepareStatement(query);
            statement.setString(1,club.getNameOfClub());
            statement.executeUpdate();
        }

        addOrUpdateHelp(club.getPresidentID(),"UPDATE club SET president = ? WHERE clubName = ?", club.getNameOfClub());
        addOrUpdateHelp(club.getVicePresidentID(),"UPDATE club SET vicePresident = ? WHERE clubName = ?", club.getNameOfClub());
        addOrUpdateHelp(club.getTreasurerID(),"UPDATE club SET treasurer = ? WHERE clubName = ?", club.getNameOfClub());
        addOrUpdateHelp(club.getGeneralSecretaryID(),"UPDATE club SET generalSecretary = ? WHERE clubName = ?", club.getNameOfClub());
        addOrUpdateHelp(club.getClubModeratorID(),"UPDATE club SET clubModerator = ? WHERE clubName = ?", club.getNameOfClub());
        addOrUpdateHelp(club.getAssistantGSID(),"UPDATE club SET assistantGS = ? WHERE clubName = ?", club.getNameOfClub());
        addOrUpdateHelp(club.getPublicRelationsID(),"UPDATE club SET publicRelations = ? WHERE clubName = ?", club.getNameOfClub());
        addOrUpdateHelp(club.getSecretaryID(),"UPDATE club SET secretary = ? WHERE clubName = ?", club.getNameOfClub());
        addOrUpdateHelp(club.getExecutive_1_ID(),"UPDATE club SET executive_1 = ? WHERE clubName = ?", club.getNameOfClub());
        addOrUpdateHelp(club.getExecutive_2_ID(),"UPDATE club SET executive_2 = ? WHERE clubName = ?", club.getNameOfClub());
        addOrUpdateHelp(club.getExecutive_3_ID(),"UPDATE club SET executive_3 = ? WHERE clubName = ?", club.getNameOfClub());

        if(club.getFundAmount() != null) {
            query = "UPDATE club SET president = ? WHERE clubName = ?";
            statement = con.prepareStatement(query);
            statement.setString(2,club.getNameOfClub());
            statement.setString(1,club.getFundAmount());
            statement.executeUpdate();
        }

    }

    public void deleteClub(String str) throws SQLException {

        ConnectDatabase db = new ConnectDatabase();
        Connection con = db.getCon();

        String deleteSql = "DELETE FROM club WHERE clubName = ?";

        PreparedStatement delStatement = con.prepareStatement(deleteSql);
        delStatement.setString(1, str);
        delStatement.executeUpdate();

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT MAX(clubID) FROM club");
        rs.next();
        int maxId = rs.getInt(1);

        // Reset the id values of the remaining rows
        int resetId = 0;
        stmt.executeUpdate("SET @reset_id = " + resetId);
        stmt.executeUpdate("UPDATE club SET clubID = (@reset_id := @reset_id + 1) WHERE clubID <= " + maxId);

        // Reset the auto-increment value
        stmt.executeUpdate("ALTER TABLE club AUTO_INCREMENT = " + resetId);
    }
}
