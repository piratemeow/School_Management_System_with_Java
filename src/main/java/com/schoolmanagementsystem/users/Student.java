package com.schoolmanagementsystem.users;

import java.time.LocalDate;

public class Student extends People {
    private int clas;
    private String section;
    private int roll;

    public Student()
    {
        super();
    }

    public Student(int id, String name, String contact, String address, LocalDate date_of_birth, String gender, String father, String mother, String religion, int clas, String section, int roll) {
        super(id, name, contact, address, date_of_birth, gender, father, mother, religion);
        this.clas = clas;
        this.section = section;
        this.roll = roll;
    }

    public void setClas(int clas)
    {
        this.clas = clas;
    }

    public void setSection(String section)
    {
        this.section = section;
    }

    public void setRoll(int roll)
    {
        this.roll = roll;
    }

    public int getclas()
    {
        return this.clas;
    }

    public String getSection()
    {
        return this.section;
    }


    public int getRoll()
    {
        return this.roll;
    }
}
