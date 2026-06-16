package com.tommy.mvc.udemi;

public class Car {

    private String brand;

    private String color;

    private int volume;

    private String privid;

    public Car() {
    }

    public String getPrivid() {
        return privid;
    }

    public void setPrivid(String privid) {
        this.privid = privid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", volume=" + volume +
                ", privid='" + privid + '\'' +
                '}';
    }
}