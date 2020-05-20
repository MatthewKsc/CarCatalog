package com.matthewksc.carcatalogmain.controller;

import com.matthewksc.carcatalogmain.dao.enityty.CatalogItem;
import com.matthewksc.carcatalogmain.service.CatalogItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private CatalogItemService catalogItemService;

    public CatalogController(CatalogItemService catalogItemService) {
        this.catalogItemService = catalogItemService;
    }

    @GetMapping
    public Flux<CatalogItem> getAllItems(){
         return catalogItemService.findAll();
    }

    @GetMapping("/{carId}")
    public Mono<CatalogItem> getItem(@PathVariable String carId){
        return catalogItemService.findById(carId);
    }
}
