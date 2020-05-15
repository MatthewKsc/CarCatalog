package com.matthewksc.carcatalogmain.dao.enityty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import reactor.core.publisher.Mono;

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
    private Integer rating;


    public CatalogItem(String carId, String name, String mark,
                       String description, String yearOfProductions, String power, Integer rating) {
        this.carId = carId;
        this.name = name;
        this.mark = mark;
        this.description = description;
        YearOfProductions = yearOfProductions;
        this.power = power;
        this.rating = rating;
    }

    public CatalogItem() {
    }

    public CatalogItem(String carId, String name) {
        this.carId = carId;
        this.name = name;
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

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
