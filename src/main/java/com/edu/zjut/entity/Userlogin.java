package com.edu.zjut.entity;

public class Userlogin {
    String uid;
    String upassword;
    String uname;
    int usex;
    int uage;
    String uaddress;
    int ucintegral;

    public Userlogin() {
    }

    public Userlogin(String uid, String upassword, String uname, int usex, int uage, String uaddress, int ucintegral) {
        this.uid = uid;
        this.upassword = upassword;
        this.uname = uname;
        this.usex = usex;
        this.uage = uage;
        this.uaddress = uaddress;
        this.ucintegral = ucintegral;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getUsex() {
        return usex;
    }

    public void setUsex(int usex) {
        this.usex = usex;
    }

    public int getUage() {
        return uage;
    }

    public void setUage(int uage) {
        this.uage = uage;
    }

    public String getUaddress() {
        return uaddress;
    }

    public void setUaddress(String uaddress) {
        this.uaddress = uaddress;
    }

    public int getUcintegral() {
        return ucintegral;
    }

    public void setUcintegral(int ucintegral) {
        this.ucintegral = ucintegral;
    }

    @Override
    public String toString() {
        return "UsrNoP{" +
                "uid='" + uid + '\'' +
                ", upassword='" + upassword + '\'' +
                ", uname='" + uname + '\'' +
                ", usex=" + usex +
                ", uage=" + uage +
                ", uaddress='" + uaddress + '\'' +
                ", ucintegral=" + ucintegral +
                '}';
    }
}

