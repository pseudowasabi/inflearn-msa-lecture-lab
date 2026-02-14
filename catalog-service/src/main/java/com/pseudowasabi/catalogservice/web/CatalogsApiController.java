package com.pseudowasabi.catalogservice.web;

import com.pseudowasabi.catalogservice.domain.catalog.Catalogs;
import com.pseudowasabi.catalogservice.service.CatalogsService;
import com.pseudowasabi.catalogservice.web.dto.response.CatalogsResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CatalogsApiController {

    private final CatalogsService catalogsService;

    @GetMapping("/status")
    public String status(HttpServletRequest httpServletRequest) {
        return String.format("Running catalog-service on port %s", httpServletRequest.getServerPort());
    }

    @GetMapping("/catalogs")
    public ResponseEntity<List<CatalogsResponse>> getCatalogs() {
        Iterable<Catalogs> catalogs = catalogsService.getAllCatalogs();
        List<CatalogsResponse> result = new ArrayList<>();
        catalogs.forEach(item -> {
            result.add(CatalogsResponse.builder()
                    .productId(item.getProductId())
                    .productName(item.getProductName())
                    .stock(item.getStock())
                    .unitPrice(item.getUnitPrice())
                    .createdDateTime(item.getCreatedDateTime())
                    .modifiedDateTime(item.getModifiedDateTime())
                    .build());
        });

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
