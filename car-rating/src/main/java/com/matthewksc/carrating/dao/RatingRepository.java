package com.matthewksc.carrating.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RatingRepository extends ReactiveMongoRepository<CarRating, String> {
}
