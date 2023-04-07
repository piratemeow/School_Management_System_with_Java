package com.schoolmanagementsystem.users;

public class Student extends People {
    private int clas;
    private String section;
    private int roll;

    Student()
    {
        super();
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
