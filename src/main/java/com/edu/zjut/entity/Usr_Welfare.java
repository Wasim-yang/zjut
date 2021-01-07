package com.edu.zjut.entity;

public class Usr_Welfare {
    String uid;
    int wid;
    int wcount;

    public Usr_Welfare() {
    }

    public Usr_Welfare(String uid, int wid, int wcount) {
        this.uid = uid;
        this.wid = wid;
        this.wcount = wcount;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public int getWcount() {
        return wcount;
    }

    public void setWcount(int wcount) {
        this.wcount = wcount;
    }

    @Override
    public String toString() {
        return "Usr_Welfare{" +
                "uid='" + uid + '\'' +
                ", wid=" + wid +
                ", wcount=" + wcount +
                '}';
    }
}
