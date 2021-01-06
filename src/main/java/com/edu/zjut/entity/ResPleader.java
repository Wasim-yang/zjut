package com.edu.zjut.entity;

public class ResPleader {
    String message;
    int code;
    String pid;

    public ResPleader() {
    }

    public ResPleader(String message, int code, String pid) {
        this.message = message;
        this.code = code;
        this.pid = pid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
