package com.matthewksc.carcatalogmain.dao.enityty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;

@Document
public class CarRating{

    @Id
    private String carId;
    private Integer rating;

    public CarRating() {
    }

    public CarRating(String carId, int rating) {
        this.carId = carId;
        this.rating = rating;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
