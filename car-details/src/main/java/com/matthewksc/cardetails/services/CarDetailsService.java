package com.matthewksc.cardetails.services;

import com.matthewksc.cardetails.dao.CarDetails;
import com.matthewksc.cardetails.dao.CarDetailsRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CarDetailsService {

    private CarDetailsRepository carDetailsRepository;

    public CarDetailsService(CarDetailsRepository carDetailsRepository) {
        this.carDetailsRepository = carDetailsRepository;
    }

    public Mono<CarDetails> findById(String s) {
        return carDetailsRepository.findById(s);
    }

    public <S extends CarDetails> Mono<S> insert(S s) {
        return carDetailsRepository.insert(s);
    }

    public <S extends CarDetails> Flux<S> insertMany(Iterable<S> iterable) {
        return carDetailsRepository.insert(iterable);
    }

    public Flux<CarDetails> findAll() {
        return carDetailsRepository.findAll();
    }

    public Mono<Void> deleteById(String s) {
        return carDetailsRepository.deleteById(s);
    }

}
