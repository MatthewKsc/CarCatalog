package com.matthewksc.carservice.controllers;

import com.matthewksc.carservice.dao.entity.Car;
import com.matthewksc.carservice.services.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public Flux<Car> getAllCars(){
        return carService.findAll();
    }

    @GetMapping("/{carId}")
    public Mono<Car> getCar(@PathVariable String carId){
        return carService.findById(carId);
    }
}
