package com.matthewksc.carrating;

import com.matthewksc.carrating.dao.CarRating;
import com.matthewksc.carrating.services.RatingService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class init {

    private RatingService ratingService;

    public init(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void get(){
        CarRating mazda = new CarRating();
        mazda.setCarId("mazda");
        mazda.setRating(4);
        CarRating scirocco = new CarRating();
        scirocco.setCarId("scirocco");
        scirocco.setRating(5);

        Flux<CarRating> carRatingFlux = Flux.just(mazda, scirocco);
        ratingService.insertMany(carRatingFlux.toIterable()).subscribe();
    }
}
