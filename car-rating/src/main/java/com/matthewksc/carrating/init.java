package com.matthewksc.carrating;

import com.matthewksc.carrating.dao.CarRating;
import com.matthewksc.carrating.services.CarRatingService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class init {

    private CarRatingService carRatingService;

    public init(CarRatingService carRatingService) {
        this.carRatingService = carRatingService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void get(){
        CarRating rex = new CarRating();
        rex.setCarId("rx-8");
        rex.setRating(4);
        CarRating scirocco = new CarRating();
        scirocco.setCarId("scirocco");
        scirocco.setRating(5);

        Flux<CarRating> carRatingFlux = Flux.just(rex, scirocco);
        carRatingService.insertMany(carRatingFlux.toIterable()).subscribe();
    }
}
