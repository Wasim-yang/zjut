package com.edu.zjut.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Usr_Goods {
    String uid;
    int gid;
    int gstate;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    Date gtime;
    int ugnumber;
    float ugcost;
    String gimage;
    String gname;
    String gdescription;

    public Usr_Goods() {
    }

    public Usr_Goods(String uid, int gid, int gstate,
                     Date gtime, int ugnumber, float ugcost,
                     String gimage, String gname, String gdescription) {
        this.uid = uid;
        this.gid = gid;
        this.gstate = gstate;
        this.gtime = gtime;
        this.ugnumber = ugnumber;
        this.ugcost = ugcost;
        this.gimage = gimage;
        this.gname = gname;
        this.gdescription = gdescription;
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

    public int getGstate() {
        return gstate;
    }

    public void setGstate(int gstate) {
        this.gstate = gstate;
    }

    public Date getGtime() {
        return gtime;
    }

    public void setGtime(Date gtime) {
        this.gtime = gtime;
    }

    public int getUgnumber() {
        return ugnumber;
    }

    public void setUgnumber(int ugnumber) {
        this.ugnumber = ugnumber;
    }

    public float getUgcost() {
        return ugcost;
    }

    public void setUgcost(float ugcost) {
        this.ugcost = ugcost;
    }

    public String getGimage() {
        return gimage;
    }

    public void setGimage(String gimage) {
        this.gimage = gimage;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGdescription() {
        return gdescription;
    }

    public void setGdescription(String gdescription) {
        this.gdescription = gdescription;
    }

    @Override
    public String toString() {
        return "Usr_Goods{" +
                "uid='" + uid + '\'' +
                ", gid=" + gid +
                ", gstate=" + gstate +
                ", gtime=" + gtime +
                ", ugnumber=" + ugnumber +
                ", ugcost=" + ugcost +
                ", gimage='" + gimage + '\'' +
                ", gname='" + gname + '\'' +
                ", gdescription='" + gdescription + '\'' +
                '}';
    }
}
