package com.schoolmanagementsystem.controllers;

import com.schoolmanagementsystem.co_curricular.Club;
import com.schoolmanagementsystem.database.ConnectDatabase;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.util.Pair;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class AllMembersController extends Controller implements Initializable {

    @FXML
    private MenuButton select;

    @FXML
    private Label id;

    @FXML
    private Label listID;

    @FXML
    private Label name;

    @FXML
    private Label id_1;

    @FXML
    private Label id_10;

    @FXML
    private Label id_11;

    @FXML
    private Label id_12;

    @FXML
    private Label id_13;

    @FXML
    private Label id_14;

    @FXML
    private Label id_15;

    @FXML
    private Label id_2;

    @FXML
    private Label id_3;

    @FXML
    private Label id_4;

    @FXML
    private Label id_5;

    @FXML
    private Label id_6;

    @FXML
    private Label id_7;

    @FXML
    private Label id_8;

    @FXML
    private Label id_9;

    @FXML
    private Label name_1;

    @FXML
    private Label name_10;

    @FXML
    private Label name_11;

    @FXML
    private Label name_12;

    @FXML
    private Label name_13;

    @FXML
    private Label name_14;

    @FXML
    private Label name_15;

    @FXML
    private Label name_2;

    @FXML
    private Label name_3;

    @FXML
    private Label name_4;

    @FXML
    private Label name_5;

    @FXML
    private Label name_6;

    @FXML
    private Label name_7;

    @FXML
    private Label name_8;

    @FXML
    private Label name_9;

    @FXML
    private Button next;

    @FXML
    private Button previous;

    @FXML
    private HBox hbox;

    @FXML
    private ScrollPane scrollPane;

    private static int currentIndex;

    private static String currentList;

    private static boolean allUserFlag;

    public static boolean isAllUserFlag() {
        return allUserFlag;
    }

    public static void setAllUserFlag(boolean allUserFlag) {
        AllMembersController.allUserFlag = allUserFlag;
    }

    @FXML
    void handleCross(ActionEvent event) throws SQLException, IOException {
        handleHome(event);
    }

    @FXML
    void handleNext(ActionEvent event) throws SQLException, IOException {
        AllMembersController.currentIndex += 15;
        AllMembersController.allUserFlag = true;
        handleAllMemberPage(event);
    }

    @FXML
    void handlePrevious(ActionEvent event) throws SQLException, IOException {
        AllMembersController.currentIndex -= 15;
        AllMembersController.allUserFlag = true;
        handleAllMemberPage(event);
    }

    @FXML
    void handleStudentList(Event event) throws SQLException, IOException {
        AllMembersController.currentList = "student";
        AllMembersController.currentIndex = 0;
        AllMembersController.allUserFlag = false;
        handleAllMemberPage(event);
    }

    @FXML
    void handleTeacherList(Event event) throws SQLException, IOException {
        AllMembersController.currentList = "Teacher";
        AllMembersController.currentIndex = 0;
        AllMembersController.allUserFlag = false;
        handleAllMemberPage(event);
    }

    @FXML
    void handleStaffList(Event event) throws SQLException, IOException {
        AllMembersController.currentList = "Staff";
        AllMembersController.currentIndex = 0;
        AllMembersController.allUserFlag = false;
        handleAllMemberPage(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public static int getCurrentIndex() {
        return currentIndex;
    }

    public static void setCurrentIndex(int currentIndex) {
        AllMembersController.currentIndex = currentIndex;
    }

    public static String getCurrentList() {
        return currentList;
    }

    public static void setCurrentList(String currentList) {
        AllMembersController.currentList = currentList;
    }

    public void handleAllMemberPage(Event event) throws IOException, SQLException {
        String buttonType;
        if(AllMembersController.allUserFlag) {
            buttonType = "button";
        } else {
            buttonType = "menuButton";
        }
        FXMLLoader fxmlLoader = loadPage(buttonType, "/com/schoolmanagementsystem/fxml_Files/allMembers.fxml", event);
        AllMembersController controller = fxmlLoader.getController();

        if(AllMembersController.currentList == null) {
            controller.scrollPane.setVisible(false);
            controller.hbox.setVisible(false);
            controller.previous.setVisible(false);
            controller.next.setVisible(false);
            return;
        }

        if(AllMembersController.currentList.equals("student")) {
            controller.select.setText("STUDENT");
        }

        if(AllMembersController.currentList.equals("Staff")) {
            controller.select.setText("STAFF");
        }

        if(AllMembersController.currentList.equals("Teacher")) {
            controller.select.setText("TEACHER");
        }

        ConnectDatabase db = new ConnectDatabase();
        Connection con = db.getCon();

        ArrayList<Pair<Integer, String>> allMember = new ArrayList<>();
        String query, selectQuery;
        PreparedStatement statement, preparedStatement;
        ResultSet r, resultSet;

        if(Objects.equals(AllMembersController.currentList, "student")) {
            query = "SELECT studentID, name FROM studentInfo";
            statement = con.prepareStatement(query);
            r = statement.executeQuery();
            while(r.next()) {
                int id = r.getInt("studentID");
                String name = r.getString("name");
                Pair<Integer, String> p = new Pair<>(id,name);
                allMember.add(p);
            }
        } else {
            query = "SELECT ID FROM loginInfo WHERE userType = ?";
            statement = con.prepareStatement(query);
            statement.setString(1, AllMembersController.currentList);
            r = statement.executeQuery();
            while (r.next()) {
                int id = r.getInt("ID");
                selectQuery = "SELECT name FROM employeeInfo WHERE employeeID = ?";
                preparedStatement = con.prepareStatement(selectQuery);
                preparedStatement.setInt(1, id);
                resultSet = preparedStatement.executeQuery();
                String name = "";
                if(resultSet.next()) {
                    name = resultSet.getString("name");
                }
                Pair<Integer, String> p = new Pair<>(id,name);
                allMember.add(p);
            }
        }

        for (int i = AllMembersController.currentIndex; i < AllMembersController.currentIndex + 15; i++) {
            if (i == allMember.size()) {
                break;
            } else if (i == AllMembersController.currentIndex) {
                controller.id_1.setText(String.valueOf(allMember.get(i).getKey()));
                controller.name_1.setText(allMember.get(i).getValue());
            } else if (i == AllMembersController.currentIndex + 1) {
                controller.id_2.setText(String.valueOf(allMember.get(i).getKey()));
                controller.name_2.setText(allMember.get(i).getValue());
            } else if (i == AllMembersController.currentIndex + 2) {
                controller.id_3.setText(String.valueOf(allMember.get(i).getKey()));
                controller.name_3.setText(allMember.get(i).getValue());
            } else if (i == AllMembersController.currentIndex + 3) {
                controller.id_4.setText(String.valueOf(allMember.get(i).getKey()));
                controller.name_4.setText(allMember.get(i).getValue());
            } else if (i == AllMembersController.currentIndex + 4) {
                controller.id_5.setText(String.valueOf(allMember.get(i).getKey()));
                controller.name_5.setText(allMember.get(i).getValue());
            } else if (i == AllMembersController.currentIndex + 5) {
                controller.id_6.setText(String.valueOf(allMember.get(i).getKey()));
                controller.name_6.setText(allMember.get(i).getValue());
            } else if (i == AllMembersController.currentIndex + 6) {
                controller.id_7.setText(String.valueOf(allMember.get(i).getKey()));
                controller.name_7.setText(allMember.get(i).getValue());
            } else if (i == AllMembersController.currentIndex + 7) {
                controller.id_8.setText(String.valueOf(allMember.get(i).getKey()));
                controller.name_8.setText(allMember.get(i).getValue());
            } else if (i == AllMembersController.currentIndex + 8) {
                controller.id_9.setText(String.valueOf(allMember.get(i).getKey()));
                controller.name_9.setText(allMember.get(i).getValue());
            } else if (i == AllMembersController.currentIndex + 9) {
                controller.id_10.setText(String.valueOf(allMember.get(i).getKey()));
                controller.name_10.setText(allMember.get(i).getValue());
            } else if (i == AllMembersController.currentIndex + 10) {
                controller.id_11.setText(String.valueOf(allMember.get(i).getKey()));
                controller.name_11.setText(allMember.get(i).getValue());
            } else if (i == AllMembersController.currentIndex + 11) {
                controller.id_12.setText(String.valueOf(allMember.get(i).getKey()));
                controller.name_12.setText(allMember.get(i).getValue());
            } else if (i == AllMembersController.currentIndex + 12) {
                controller.id_13.setText(String.valueOf(allMember.get(i).getKey()));
                controller.name_13.setText(allMember.get(i).getValue());
            } else if (i == AllMembersController.currentIndex + 13) {
                controller.id_14.setText(String.valueOf(allMember.get(i).getKey()));
                controller.name_14.setText(allMember.get(i).getValue());
            } else if (i == AllMembersController.currentIndex + 14) {
                controller.id_15.setText(String.valueOf(allMember.get(i).getKey()));
                controller.name_15.setText(allMember.get(i).getValue());
            }
        }

        if (AllMembersController.currentIndex == 0) {
            controller.previous.setVisible(false);
        }
        if (AllMembersController.currentIndex + 15 >= allMember.size()) {
            controller.next.setVisible(false);
        }
    }
}
