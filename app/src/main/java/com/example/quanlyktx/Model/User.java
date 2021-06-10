package com.example.quanlyktx.Model;

public class User {
    String mailUser;
    String pass;
    String re_pass;

    public User() {
    }

    public User(String mailUser, String pass, String re_pass) {
        this.mailUser = mailUser;
        this.pass = pass;
        this.re_pass = re_pass;
    }

    public String getMailUser() {
        return mailUser;
    }

    public void setMailUser(String mailUser) {
        this.mailUser = mailUser;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRe_pass() {
        return re_pass;
    }

    public void setRe_pass(String re_pass) {
        this.re_pass = re_pass;
    }
}
