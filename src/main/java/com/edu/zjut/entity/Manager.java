package com.edu.zjut.entity;

/**
 * 管理员账号类
 */
public class Manager {
    String mid;
    String mname;
    String mpassword;

    public Manager() {
    }

    public Manager(String mid, String mname, String mpassword) {
        this.mid = mid;
        this.mname = mname;
        this.mpassword = mpassword;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMpassword() {
        return mpassword;
    }

    public void setMpassword(String mpassword) {
        this.mpassword = mpassword;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "mid='" + mid + '\'' +
                ", mname='" + mname + '\'' +
                ", mpassword='" + mpassword + '\'' +
                '}';
    }
}
