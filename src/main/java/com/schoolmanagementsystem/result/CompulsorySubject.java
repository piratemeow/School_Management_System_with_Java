package com.schoolmanagementsystem.result;

import com.schoolmanagementsystem.users.Student;

public class CompulsorySubject extends Student {
    private double Ban1;
    private double Ban2;
    private double Eng1;
    private double Eng2;

    public CompulsorySubject ()
    {
        super();
    }

    public CompulsorySubject(int id, double Ban1, double Ban2, double Eng1, double Eng2)
    {
        this.Ban1 = Ban1;
        this.Ban2 = Ban2;
        this.Eng1 = Eng1;
        this.Eng2 = Eng2;

    }


    public void setBan1(double Ban1)
    {
        this.Ban1 = Ban1;
    }

    private void setBan2(double Ban2)
    {
        this.Ban2 = Ban2;
    }
    private  void setEng1(double Eng1)
    {
        this.Eng1 = Eng1;
    }
    private void setEng2(double Eng2)
    {
        this.Eng2 = Eng2;
    }


    public double getBan1() {
        return Ban1;
    }

    public double getBan2() {
        return Ban2;
    }

    public double getEng1() {
        return Eng1;
    }

    public double getEng2() {
        return Eng2;
    }
}
