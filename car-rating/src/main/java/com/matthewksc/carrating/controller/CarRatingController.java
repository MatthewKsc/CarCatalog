package com.matthewksc.carrating.controller;

import com.matthewksc.carrating.dao.CarRating;
import com.matthewksc.carrating.services.CarRatingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/rating")
public class CarRatingController {

    private CarRatingService carRatingService;

    public CarRatingController(CarRatingService carRatingService) {
        this.carRatingService = carRatingService;
    }

    @GetMapping()
    public Flux<CarRating> getRatings(){
        return carRatingService.findAll();
    }

    @GetMapping("/{carId}")
    public Mono<CarRating> getCarRating(@PathVariable String carId){
        return carRatingService.getRatingOfCar(carId);
    }
}
