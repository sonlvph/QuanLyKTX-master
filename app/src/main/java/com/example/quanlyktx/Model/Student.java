package com.example.quanlyktx.Model;



public class Student {

    public String fullname;
    public String date;
    public String adress;
    public String phone;

    public Student() {
    }

    public Student( String fullname, String date, String adress, String phone) {
        this.fullname = fullname;
        this.date = date;
        this.adress = adress;
        this.phone = phone;
    }


    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
