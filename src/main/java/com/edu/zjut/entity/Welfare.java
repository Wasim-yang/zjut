package com.edu.zjut.entity;

public class Welfare {
    int wid;
    String wname;
    int wtotal;
    int wgain;
    String wdescription;
    int wcount;
    String uid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getWcount() {
        return wcount;
    }

    public void setWcount(int wcount) {
        this.wcount = wcount;
    }

    public Welfare(){}

    public Welfare( int wid, String wname, int wtotal, int wgain, String wdescription,int wcount,String uid) {
        this.wid = wid;
        this.wname = wname;
        this.wtotal =wtotal;
        this.wgain =wgain;
        this.wdescription = wdescription;
        this.wcount=wcount;
        this.uid=uid;
    }

    public int getwid() {
        return wid;
    }

    public void setwid(int wid) {
        this.wid = wid;
    }

    public String getwname() {
        return wname;
    }

    public void setwname(String wname) {
        this.wname = wname;
    }

    public int getwtotal() {
        return wtotal;
    }

    public void setwtotal(int wtotal) {
        this.wtotal = wtotal;
    }

    public int getwgain() {
        return wgain;
    }

    public void setwgain(int wgain) {
        this.wgain = wgain;
    }

    public String getwdescription() {
        return wdescription;
    }

    public void setwdescription(String wdescription) {
        this.wdescription = wdescription;
    }

    @Override
    public String toString() {
        return "Welfare{" +
                "wid=" + wid +
                ", wname='" + wname + '\'' +
                ", wtotal=" + wtotal +
                ", wgain=" + wgain +
                ", wdescription='" + wdescription + '\'' +
                ", wcount=" + wcount +
                ", uid=" + uid +
                '}';
    }
}
