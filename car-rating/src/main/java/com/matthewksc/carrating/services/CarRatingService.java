package com.matthewksc.carrating.services;

import com.matthewksc.carrating.dao.CarRating;
import com.matthewksc.carrating.dao.CarRatingRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CarRatingService {

    private CarRatingRepository carRatingRepository;

    public CarRatingService(CarRatingRepository carRatingRepository) {
        this.carRatingRepository = carRatingRepository;
    }

    public Mono<CarRating> getRatingOfCar(String carId){
        return carRatingRepository.findById(carId);
    }

    public <S extends CarRating> Mono<S> insert(S s) {
        return carRatingRepository.insert(s);
    }

    public <S extends CarRating> Flux<S> insertMany(Iterable<S> iterable) {
        return carRatingRepository.insert(iterable);
    }

    public Flux<CarRating> findAll() {
        return carRatingRepository.findAll();
    }
}
