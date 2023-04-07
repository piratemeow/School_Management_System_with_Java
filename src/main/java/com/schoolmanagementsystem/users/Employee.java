package com.schoolmanagementsystem.users;

public class Employee extends People {
    private String designation;
    private String marital;
    private int salary;
    private String joining_date;
    private String pass;


    Employee() {
        super();
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setMaritalsatus(String marital) {
        this.marital = marital;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setJoinigdate(String joining_date) {
        this.joining_date = joining_date;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDesignation() {
        return this.designation;
    }

    public String getMaritalstatus() {
        return this.marital;
    }

    public int getSalary() {
        return this.salary;
    }

    public String getJoiningdate() {
        return this.joining_date;
    }

}