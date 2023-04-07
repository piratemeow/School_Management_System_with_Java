package com.schoolmanagementsystem.users;

public class People {
    private String name;
    private int id;
    private String contact;
    private String address;
    private String date_of_birth;
    private String gender;
    private String father;
    private String mother;
    private String religion;

    People()
    {

    }

    public void setName(String name)
    {
        this.name = name;
    }
    public void setId(int id)
    {
        this.id = id;
    }

    public void setContact (String contact)
    {
        this.contact = contact;
    }

    public void setAddress (String address)
    {
        this.address = address;
    }

    public void setDateofbirth(String date_of_birth)
    {
        this.date_of_birth = date_of_birth;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public void setFather(String father)
    {
        this.father = father;
    }

    public void setMother(String mother)
    {
        this.mother = mother;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }


    public String getName ()
    {
        return this.name;
    }

    public int getId()
    {
        return this.id;
    }

    public String getContact()
    {
        return this.contact;
    }

    public String getAdderss()
    {
        return this.address;
    }

    public String getDateofbirth()
    {
        return this.date_of_birth;
    }

    public String getGender()
    {
        return this.gender;
    }

    public String getFather()
    {
        return this.father;
    }
    public String getMother()
    {
        return this.mother;
    }

    public String getReligion() {
        return religion;
    }


}
