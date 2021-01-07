package com.edu.zjut.entity;

public class ResManager {
    String message;
    int code;
    String mid;

    public ResManager() {
    }

    public ResManager(String message, int code, String mid) {
        this.message = message;
        this.code = code;
        this.mid = mid;
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

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }
}
