package com.pseudowasabi.catalogservice.domain.catalog;

import org.springframework.data.repository.CrudRepository;

public interface CatalogsRepository extends CrudRepository<Catalogs, Long> {
    Catalogs findByProductId(String productId);
}
