package com.matthewksc.carrating.services;

import com.matthewksc.carrating.dao.CarRating;
import com.matthewksc.carrating.dao.RatingRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RatingService {

    private RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public Mono<CarRating> getRatingOfCar(String carId){
        return ratingRepository.findById(carId);
    }

    public <S extends CarRating> Mono<S> insert(S s) {
        return ratingRepository.insert(s);
    }

    public <S extends CarRating> Flux<S> insertMany(Iterable<S> iterable) {
        return ratingRepository.insert(iterable);
    }

    public Flux<CarRating> findAll() {
        return ratingRepository.findAll();
    }
}
