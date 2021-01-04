package com.edu.zjut.entity;

public class ResUsr {
    String message;
    int code;
    String uid;

    public ResUsr() {
    }

    public ResUsr(String message, int code, String uid) {
        this.message = message;
        this.code = code;
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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
}
