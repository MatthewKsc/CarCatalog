package com.matthewksc.carservice.dao;

import com.matthewksc.carservice.dao.entity.Car;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CarRepository extends ReactiveMongoRepository<Car, String> {
}
