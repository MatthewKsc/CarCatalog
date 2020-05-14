package com.matthewksc.carservice;

import com.matthewksc.carservice.dao.Car;
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
        Car rex= new Car();
        rex.setId("rx-8");
        rex.setName("RX-8");
        Car scirocco = new Car();
        scirocco.setId("scirocco");
        scirocco.setName("Scirocco");
        Flux<Car> cars = Flux.just(rex, scirocco);
        carService.insertMany(cars.toIterable()).subscribe();
    }
}
