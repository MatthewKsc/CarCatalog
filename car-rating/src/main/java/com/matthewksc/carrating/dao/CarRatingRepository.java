package com.matthewksc.carrating.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CarRatingRepository extends ReactiveMongoRepository<CarRating, String> {
}
