package com.pseudowasabi.apigatewaywebflux.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class CustomFilter extends AbstractGatewayFilterFactory<CustomFilter.Config> {

    public CustomFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(CustomFilter.Config config) {

        return (exchange, chain) -> {
            // Custom pre-filter
            log.info("[Custom pre-filter] request id: {}", exchange.getRequest().getId());

            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                // Custom post-filter
                log.info("[Custom post-filter] status code: {}", exchange.getResponse().getStatusCode());
            }));
        };
    }

    public static class Config {
        // config properties
    }
}
