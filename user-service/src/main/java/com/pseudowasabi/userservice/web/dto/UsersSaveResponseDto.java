package com.pseudowasabi.userservice.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsersSaveResponseDto {
    private Long id;
    private String email;
    private String name;
    private String userId;
}
