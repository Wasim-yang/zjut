package com.edu.zjut.entity;

import java.util.Date;

/**
 * 用户绿色出行记录类
 */
public class Travellog {
    String uid;
    Date utime;
    int ttype;
    float tmileage;

    public Travellog() {
    }

    public Travellog(String uid, Date utime, int ttype, float tmileage) {
        this.uid = uid;
        this.utime = utime;
        this.ttype = ttype;
        this.tmileage = tmileage;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }

    public int getTtype() {
        return ttype;
    }

    public void setTtype(int ttype) {
        this.ttype = ttype;
    }

    public float getTmileage() {
        return tmileage;
    }

    public void setTmileage(float tmileage) {
        this.tmileage = tmileage;
    }

    @Override
    public String toString() {
        return "Travellog{" +
                "uid='" + uid + '\'' +
                ", utime=" + utime +
                ", ttype=" + ttype +
                ", tmileage=" + tmileage +
                '}';
    }
}
