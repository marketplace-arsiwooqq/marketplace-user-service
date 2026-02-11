package com.arsiwooqq.userservice.client;

import com.arsiwooqq.userservice.dto.ApiResponse;
import com.arsiwooqq.userservice.dto.ValidateTokenRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "auth-service", url = "${AUTH_SERVICE_URL:}")
public interface AuthServiceClient {

    @PostMapping("/api/v1/auth/validate")
    ApiResponse<Boolean> validate(ValidateTokenRequest request);
}
