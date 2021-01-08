package com.edu.zjut.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Business_deliver {
    String uid;
    int gid;
    String gname;
    int ugnumber;
    int gean;
    String uaddress;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    Date gtime;
    int gstate;
    String bid;

    public Business_deliver() {
    }

    public Business_deliver(String uid, int gid, String gname, int ugnumber, int gean, String uaddress, Date gtime, int gstate, String bid) {
        this.uid = uid;
        this.gid = gid;
        this.gname = gname;
        this.ugnumber = ugnumber;
        this.gean = gean;
        this.uaddress = uaddress;
        this.gtime = gtime;
        this.gstate = gstate;
        this.bid = bid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public int getUgnumber() {
        return ugnumber;
    }

    public void setUgnumber(int ugnumber) {
        this.ugnumber = ugnumber;
    }

    public int getGean() {
        return gean;
    }

    public void setGean(int gean) {
        this.gean = gean;
    }

    public String getUaddress() {
        return uaddress;
    }

    public void setUaddress(String uaddress) {
        this.uaddress = uaddress;
    }

    public Date getGtime() {
        return gtime;
    }

    public void setGtime(Date gtime) {
        this.gtime = gtime;
    }

    public int getGstate() {
        return gstate;
    }

    public void setGstate(int gstate) {
        this.gstate = gstate;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "Business_deliver{" +
                "uid='" + uid + '\'' +
                ", gid=" + gid +
                ", gname='" + gname + '\'' +
                ", ugnumber=" + ugnumber +
                ", gean=" + gean +
                ", uaddress='" + uaddress + '\'' +
                ", gtime=" + gtime +
                ", gstate=" + gstate +
                ", bid='" + bid + '\'' +
                '}';
    }
}
