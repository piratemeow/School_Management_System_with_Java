package com.schoolmanagementsystem.co_curricular;

import javafx.util.Pair;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CoCurricular {
    public void addFund(String fund) throws SQLException;

    public boolean spendFund(String fund) throws SQLException;

    public String addMember(int id) throws SQLException;

    public String removeMember(int id) throws SQLException;

    public ArrayList<Pair<String, Integer>> ecPanel() throws SQLException;

    public ArrayList<Integer> allMember() throws SQLException;
}
