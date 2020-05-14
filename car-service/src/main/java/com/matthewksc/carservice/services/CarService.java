package com.matthewksc.carservice.services;

import com.matthewksc.carservice.dao.CarRepository;
import com.matthewksc.carservice.dao.Car;
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

    public Mono<Car> findById(String id) {
        return carRepository.findById(id);
    }

    public <S extends Car> Mono<S> insert(S s) {
        return carRepository.insert(s);
    }

    public <S extends Car> Flux<S> insertMany(Iterable<S> iterable) {
        return carRepository.insert(iterable);
    }

    public Mono<Void> deleteById(String id) {
        return carRepository.deleteById(id);
    }
}
