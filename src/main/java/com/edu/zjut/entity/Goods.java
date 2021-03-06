package com.edu.zjut.entity;

public class Goods {
    int gid;
    String gname;
    float gcost;
    int gnumber;
    int gean;
    String gdescription;
    String gimage;
    String bid;

    public Goods() {
    }

    public Goods(int gid, String gname, float gcost, int gnumber,
                 int gean, String gdescription, String gimage, String bid) {
        this.gid = gid;
        this.gname = gname;
        this.gcost = gcost;
        this.gnumber = gnumber;
        this.gean = gean;
        this.gdescription = gdescription;
        this.gimage = gimage;
        this.bid = bid;
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

    public float getGcost() {
        return gcost;
    }

    public void setGcost(float gcost) {
        this.gcost = gcost;
    }

    public int getGnumber() {
        return gnumber;
    }

    public void setGnumber(int gnumber) {
        this.gnumber = gnumber;
    }

    public int getGean() {
        return gean;
    }

    public void setGean(int gean) {
        this.gean = gean;
    }

    public String getGdescription() {
        return gdescription;
    }

    public void setGdescription(String gdescription) {
        this.gdescription = gdescription;
    }

    public String getGimage() {
        return gimage;
    }

    public void setGimage(String gimage) {
        this.gimage = gimage;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }
}
