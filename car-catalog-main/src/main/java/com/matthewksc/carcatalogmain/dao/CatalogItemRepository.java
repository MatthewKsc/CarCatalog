package com.matthewksc.carcatalogmain.dao;

import com.matthewksc.carcatalogmain.dao.enityty.CatalogItem;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CatalogItemRepository extends ReactiveMongoRepository<CatalogItem, String> {
}
