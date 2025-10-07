package com.pseudowasabi.apigatewaywebflux.filter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class GlobalFilter extends AbstractGatewayFilterFactory<GlobalFilter.Config> {

    public GlobalFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            // Global filter actions
            log.info("[Global filter baseMessage] {}", config.baseMessage);
            if (config.isPreLogger()) {
                log.info("[Global pre-filter] request id: {}", exchange.getRequest().getId());
            }

            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                // Global post-filter
                if (config.isPostLogger()) {
                    log.info("[Global post-filter] status code: {}", exchange.getResponse().getStatusCode());
                }
            }));
        };
    }

    @Data
    public static class Config {
        private String baseMessage;
        private boolean preLogger;
        private boolean postLogger;
    }
}
