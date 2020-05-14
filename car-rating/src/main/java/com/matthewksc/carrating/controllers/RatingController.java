package com.matthewksc.carrating.controllers;

import com.matthewksc.carrating.dao.CarRating;
import com.matthewksc.carrating.services.RatingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/rating")
public class RatingController {

    private RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping()
    public Flux<CarRating> getRatings(){
        return ratingService.findAll();
    }

    @GetMapping("/{carId}")
    public Mono<CarRating> getCarRating(@PathVariable String carId){
        return ratingService.getRatingOfCar(carId);
    }
}
