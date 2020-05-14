package com.matthewksc.cardetails.controller;

import com.matthewksc.cardetails.dao.CarDetails;
import com.matthewksc.cardetails.services.CarDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/details")
public class CarDetailsController {

    private CarDetailsService carDetailsService;

    public CarDetailsController(CarDetailsService carDetailsService) {
        this.carDetailsService = carDetailsService;
    }

    @GetMapping
    public Flux<CarDetails> getCarsDetail(){
        return carDetailsService.findAll();
    }

    @GetMapping("/{carId}")
    public Mono<CarDetails> getCarDetail(@PathVariable String carId){
        return carDetailsService.findById(carId);
    }
}
