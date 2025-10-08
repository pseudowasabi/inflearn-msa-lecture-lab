package com.pseudowasabi.apigatewaywebflux.filter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class LoggingFilter extends AbstractGatewayFilterFactory<LoggingFilter.Config> {

    public LoggingFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            // Logging filter actions
            log.info("[Logging filter baseMessage] {}", config.baseMessage);
            if (config.isPreLogger()) {
                log.info("[Logging pre-filter] request id: {}", exchange.getRequest().getId());
            }

            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                // Logging post-filter
                if (config.isPostLogger()) {
                    log.info("[Logging post-filter] status code: {}", exchange.getResponse().getStatusCode());
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
