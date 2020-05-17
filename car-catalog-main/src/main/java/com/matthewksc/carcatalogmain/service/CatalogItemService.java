package com.matthewksc.carcatalogmain.service;

import com.matthewksc.carcatalogmain.dao.CatalogItemRepository;
import com.matthewksc.carcatalogmain.dao.enityty.CatalogItem;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CatalogItemService {

    private CatalogItemRepository catalogItemRepository;

    public CatalogItemService(CatalogItemRepository catalogItemRepository) {
        this.catalogItemRepository = catalogItemRepository;
    }

    public <S extends CatalogItem> Flux<S> insert(Iterable<S> iterable) {
        return catalogItemRepository.insert(iterable);
    }

    public Mono<CatalogItem> findById(String s) {
        return catalogItemRepository.findById(s);
    }

    public Flux<CatalogItem> findAll() {
        return catalogItemRepository.findAll();
    }
}
