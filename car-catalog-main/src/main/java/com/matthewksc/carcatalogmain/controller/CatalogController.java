package com.matthewksc.carcatalogmain.controller;


import com.matthewksc.carcatalogmain.dao.CatalogItemRepository;
import com.matthewksc.carcatalogmain.dao.enityty.Car;
import com.matthewksc.carcatalogmain.dao.enityty.CarDetails;
import com.matthewksc.carcatalogmain.dao.enityty.CarRating;
import com.matthewksc.carcatalogmain.dao.enityty.CatalogItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @GetMapping()
    public List<CatalogItem> CatalogController(){
         List<Car> cars = WebClient
                 .builder()
                 .build()
                 .get()
                 .uri("http://localhost:8083/cars", Car.class)
                 .retrieve()
                 .bodyToFlux(Car.class)
                 .collectList()
                 .block();
         return cars.stream().map(car -> {
             CarDetails carDetails = WebClient
                     .builder()
                     .build()
                     .get()
                     .uri("http://localhost:8081/details/"+car.getId(),CarDetails.class)
                     .retrieve()
                     .bodyToMono(CarDetails.class)
                     .block();
             CarRating carRating = WebClient
                     .builder()
                     .build()
                     .get()
                     .uri("http://localhost:8082/rating/"+car.getId(),CarRating.class)
                     .retrieve()
                     .bodyToMono(CarRating.class)
                     .block();
             return new CatalogItem(car.getId(), car.getName(),carDetails.getMark(), carDetails.getDescription(),
                     carDetails.getYearOfProductions(), carDetails.getPower(), carRating.getRating());
         }).collect(Collectors.toList());
    }
}
