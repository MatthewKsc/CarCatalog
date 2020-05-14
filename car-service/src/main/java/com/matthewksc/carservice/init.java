package com.matthewksc.carservice;

import com.matthewksc.carservice.dao.entity.Car;
import com.matthewksc.carservice.services.CarService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class init {

    private CarService carService;

    public init(CarService carService) {
        this.carService = carService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void get(){
        Car mazda= new Car();
        mazda.setId("mazda");
        mazda.setName("Mazda");
        Car scirocco = new Car();
        scirocco.setId("scirocco");
        scirocco.setName("Scirocco");
        Flux<Car> cars = Flux.just(mazda, scirocco);
        carService.insertMany(cars.toIterable()).subscribe();
    }
}
