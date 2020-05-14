package com.matthewksc.carservice.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CarRepository extends ReactiveMongoRepository<Car, String> {
}
