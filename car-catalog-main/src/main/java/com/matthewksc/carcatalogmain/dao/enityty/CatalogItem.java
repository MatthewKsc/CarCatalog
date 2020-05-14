package com.matthewksc.carcatalogmain.dao.enityty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CatalogItem {

    @Id
    private String id;
    private String carId;
    private String name;
    private String mark;
    private String description;
    private String YearOfProductions;
    private String power;
    private int rating;

    public CatalogItem() {
    }

    public CatalogItem(String id, String carId, String name, String mark, String description,
                       String yearOfProductions, String power, int rating) {
        this.id = id;
        this.carId = carId;
        this.name = name;
        this.mark = mark;
        this.description = description;
        YearOfProductions = yearOfProductions;
        this.power = power;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        this.power = power;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
