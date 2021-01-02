package com.edu.zjut.entity;

public class FilePath {

    int id;

    String path;

    public FilePath() {
    }

    public FilePath(int id, String path) {
        this.id = id;
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
