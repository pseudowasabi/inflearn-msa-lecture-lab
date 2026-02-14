package com.pseudowasabi.catalogservice.web.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CatalogsResponse {
    private String productId;
    private String productName;
    private Integer stock;
    private Integer unitPrice;
    private LocalDateTime createdDateTime;
    private LocalDateTime modifiedDateTime;
}
