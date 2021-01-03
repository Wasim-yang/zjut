package com.edu.zjut.entity;

import java.sql.Blob;

public class Goods {
    int id;
    String name;
    float cost;
    int number;
    int ean;
    String description;
    String path;


    public Goods() {
    }

    public Goods(int id, String name, float cost, int number, int ean, String description, String path) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.number = number;
        this.ean = ean;
        this.description = description;
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getEan() {
        return ean;
    }

    public void setEan(int ean) {
        this.ean = ean;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", number=" + number +
                ", ean=" + ean +
                ", description='" + description + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
