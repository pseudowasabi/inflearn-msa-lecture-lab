package com.pseudowasabi.userservice.web.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsersResponse {
    private String userId;
    private String email;
    private String name;
    private String nickname;

    private List<OrdersResponse> orders;
}
