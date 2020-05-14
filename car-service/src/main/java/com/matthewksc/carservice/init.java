package com.matthewksc.carservice;

import com.matthewksc.carservice.dao.CarRepository;
import com.matthewksc.carservice.dao.entity.Car;
import org.springframework.context.annotation.Configuration;

@Configuration
public class init {

    public init(CarRepository carRepository){
        Car mazda = new Car();
        mazda.setName("Mazda");
        Car scirocco = new Car();
        mazda.setName("Scirocco");
    }
}
