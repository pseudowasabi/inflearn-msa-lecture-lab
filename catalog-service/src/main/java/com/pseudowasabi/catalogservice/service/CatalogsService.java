package com.pseudowasabi.catalogservice.service;

import com.pseudowasabi.catalogservice.domain.catalog.Catalogs;
import com.pseudowasabi.catalogservice.domain.catalog.CatalogsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CatalogsService {

    private final CatalogsRepository catalogsRepository;

    public Iterable<Catalogs> getAllCatalogs() {
        return catalogsRepository.findAll();
    }
}
