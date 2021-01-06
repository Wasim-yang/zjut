package com.edu.zjut.entity;

/**
 * 项目负责人账号类
 */
public class Pleader {
    String pid;
    String pname;
    String ppassword;

    public Pleader() {
    }

    public Pleader(String pid, String pname, String ppassword) {
        this.pid = pid;
        this.pname = pname;
        this.ppassword = ppassword;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPpassword() {
        return ppassword;
    }

    public void setPpassword(String ppassword) {
        this.ppassword = ppassword;
    }

    @Override
    public String toString() {
        return "Leader{" +
                "pid='" + pid + '\'' +
                ", pname='" + pname + '\'' +
                ", ppassword='" + ppassword + '\'' +
                '}';
    }
}
