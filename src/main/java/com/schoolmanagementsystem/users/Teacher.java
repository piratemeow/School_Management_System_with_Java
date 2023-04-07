package com.schoolmanagementsystem.users;

public class Teacher extends Employee {
    private String subject;
    private int[] clas = new int[10];
    private String[] section = new String[30];

    int iclas = 0;
    int isec = 0;

    Teacher()
    {

    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    public void setClas(int cl)
    {
        this.clas[iclas] = cl;
        iclas++;
    }

    public void setSection(String sec)
    {
        this.section[isec] = sec;
        isec++;
    }

    public String getSubject()
    {
        return this.subject;
    }

    public int[] getClas()
    {
        return this.clas;
    }

    public String[] getSection ()
    {
        return this.section;
    }

}
