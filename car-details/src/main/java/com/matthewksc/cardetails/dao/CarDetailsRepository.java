package com.matthewksc.cardetails.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CarDetailsRepository extends ReactiveMongoRepository<CarDetails, String> {
}
