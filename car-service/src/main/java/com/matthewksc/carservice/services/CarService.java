package com.matthewksc.carservice.services;

import com.matthewksc.carservice.dao.CarRepository;
import com.matthewksc.carservice.dao.entity.Car;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CarService {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Flux<Car> findAll(){
        return carRepository.findAll();
    }

    public Mono<Car> findById(String s) {
        return carRepository.findById(s);
    }

    public <S extends Car> Mono<S> insert(S s) {
        return carRepository.insert(s);
    }

    public Mono<Void> deleteById(String s) {
        return carRepository.deleteById(s);
    }
}
