package com.matthewksc.cardetails.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CarDetails {

    @Id
    private String carId;
    private String mark;
    private String description;
    private String YearOfProductions;
    private String power;

    public CarDetails() {
    }

    public CarDetails(String carId, String mark, String description, String yearOfProductions, String power) {
        this.carId = carId;
        this.mark = mark;
        this.description = description;
        YearOfProductions = yearOfProductions;
        this.power = power +" km";
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYearOfProductions() {
        return YearOfProductions;
    }

    public void setYearOfProductions(String yearOfProductions) {
        YearOfProductions = yearOfProductions;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power +" km";
    }
}
