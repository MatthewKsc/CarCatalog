package com.matthewksc.carcatalogmain.service;

import com.matthewksc.carcatalogmain.dao.enityty.Car;
import com.matthewksc.carcatalogmain.dao.enityty.CarDetails;
import com.matthewksc.carcatalogmain.dao.enityty.CarRating;
import com.matthewksc.carcatalogmain.dao.enityty.CatalogItem;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatalogItemInitData {


    private WebClient.Builder webClientBuilder;
    private CatalogItemService catalogItemService;

    public CatalogItemInitData(WebClient.Builder webClientBuilder, CatalogItemService catalogItemService) {
        this.webClientBuilder = webClientBuilder;
        this.catalogItemService = catalogItemService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void getCatalog(){
        List<CatalogItem> resultCars= getItemsForCatalog();
        catalogItemService.insert(resultCars).subscribe();
    }

    private List<CatalogItem> getItemsForCatalog() {
        return getCars().stream().map(car -> {
            //getting details of car
            CarDetails carDetails = getDetailsForCar(car.getId());
            //getting ratings of car
            CarRating carRating = getRatingOfCar(car.getId());
            //wrap to CatalogItem and return as list
            return new CatalogItem(car.getId(), car.getName(), carDetails.getMark(), carDetails.getDescription(),
                    carDetails.getYearOfProductions(), carDetails.getPower(), carRating.getRating());
        }).collect(Collectors.toList());
    }

    private List<Car> getCars() {

        return webClientBuilder.build()
                .get()
                .uri("http://car-serice/cars", Car.class)
                .retrieve()
                .bodyToFlux(Car.class)
                .collectList()
                .block();
    }

    private CarRating getRatingOfCar(String carId) {
        return webClientBuilder.build()
                .get()
                .uri("http://car-rating/rating/"+ carId, CarRating.class)
                .retrieve()
                .bodyToMono(CarRating.class)
                .block();
    }

    private CarDetails getDetailsForCar(String carId) {
        return webClientBuilder.build()
                .get()
                .uri("http://car-details/details/"+carId, CarDetails.class)
                .retrieve()
                .bodyToMono(CarDetails.class)
                .block();
    }
}
