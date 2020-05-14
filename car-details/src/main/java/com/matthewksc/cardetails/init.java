package com.matthewksc.cardetails;

import com.matthewksc.cardetails.dao.CarDetails;
import com.matthewksc.cardetails.services.CarDetailsService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class init {

    private CarDetailsService carDetailsService;

    public init(CarDetailsService carDetailsService) {
        this.carDetailsService = carDetailsService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void get(){
        CarDetails rexDetails = new CarDetails("rx-8", "mazda",
                "rotar engine is the best", "2008", "180");
        CarDetails sciroccoDetails = new CarDetails("scirocco", "Volkswagen",
                "Renovated Hatchback", "2013", "230");

        Flux<CarDetails> detailsFlux = Flux.just(rexDetails, sciroccoDetails);
        carDetailsService.insertMany(detailsFlux.toIterable()).subscribe();
    }
}
