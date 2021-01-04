package com.edu.zjut.entity;

public class Coupon {
    int id;
    String name;
    float discount;
    int expoints;
    String description;

public Coupon(){
}
    public Coupon(int id, String name, float discount, int expoints, String description){
        this.id = id;
        this.name = name;
        this.discount = discount;
        this.expoints = expoints;
        this.description = description;
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

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public int getExpoints() {
        return expoints;
    }

    public void setExpoints(int expoints) {
        this.expoints = expoints;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "Coupons{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", discount=" + discount +
                ", expoints=" + expoints +
                ", description='" + description + '\'' +
                '}';
    }
}
