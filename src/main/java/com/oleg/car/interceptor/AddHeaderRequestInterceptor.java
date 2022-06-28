package com.oleg.car.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AddHeaderRequestInterceptor implements RequestInterceptor {

    @Value("${car-service.token}")
    private String token;

    @Value("${car-service.api.key}")
    private String apiKey;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        if (requestTemplate.url().contains("cars")) {
            requestTemplate.query("api_key", apiKey);
        }

        requestTemplate.header("Authorization", "Bearer " + token);
    }
}