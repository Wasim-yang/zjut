package com.edu.zjut.entity;

public class Welfare {
    int wid;
    String wname;
    int wtotal;
    int wgain;
    String wdescription;

    public Welfare(){}

    public Welfare( int wid, String wname, int wtotal, int wgain, String wdescription) {
        this.wid = wid;
        this.wname = wname;
        this.wtotal =wtotal;
        this.wgain =wgain;
        this.wdescription = wdescription;
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
                '}';
    }
}
