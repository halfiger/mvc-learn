package com.tommy.mvc.udemi;

import java.util.HashMap;
import java.util.Map;

public class Car {

    private String brand;

    private String color;

    private int volume;

    private String privid;

    private String country;

    private Integer []tos;

    private Map<Integer, Integer> yearsOfTOList;
    public Car() {
    yearsOfTOList = new HashMap<>();
    yearsOfTOList.put(2020, 20);
    yearsOfTOList.put(2022, 22);
    yearsOfTOList.put(2024, 24);
    yearsOfTOList.put(2026, 26);
    }

    public Map<Integer, Integer> getYearsOfTOList() {
        return yearsOfTOList;
    }

    public void setYearsOfTOList(Map<Integer, Integer> yearsOfTOList) {
        this.yearsOfTOList = yearsOfTOList;
    }

    public Integer[] getTos() {
        return tos;
    }

    public void setTos(Integer[] to) {
        this.tos = to;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
                ", country='" + country + '\'' +
                '}';
    }
}