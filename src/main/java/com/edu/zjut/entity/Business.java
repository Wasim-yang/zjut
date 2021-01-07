package com.edu.zjut.entity;

/**
 * 商家账号类
 */
public class Business {
    String bid;
    String bname;
    String bpassword;
    String baddress;

    public Business() {
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBpassword() {
        return bpassword;
    }

    public void setBpassword(String bpassword) {
        this.bpassword = bpassword;
    }

    public String getBaddress() {
        return baddress;
    }

    public void setBaddress(String baddress) {
        this.baddress = baddress;
    }

    @Override
    public String toString() {
        return "Bussiness{" +
                "bid='" + bid + '\'' +
                ", bname='" + bname + '\'' +
                ", bpassword='" + bpassword + '\'' +
                ", baddress='" + baddress + '\'' +
                '}';
    }
}
