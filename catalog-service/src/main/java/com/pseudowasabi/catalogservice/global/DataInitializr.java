package com.pseudowasabi.catalogservice.global;

import com.pseudowasabi.catalogservice.domain.catalog.Catalogs;
import com.pseudowasabi.catalogservice.domain.catalog.CatalogsRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializr {

    private final CatalogsRepository catalogsRepository;

    @PostConstruct
    void init() {
        catalogsRepository.save(new Catalogs("CTLG-001", "Seoul", 100, 1500));
        catalogsRepository.save(new Catalogs("CTLG-002", "Tokyo", 50, 2000));
        catalogsRepository.save(new Catalogs("CTLG-003", "Beijing", 200, 1200));
    }
}
