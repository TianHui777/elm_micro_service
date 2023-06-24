package com.tianhui.config;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;

import java.time.Duration;

//@Component
public class CircuitGatewayFilterFactory extends AbstractGatewayFilterFactory<CircuitGatewayFilterFactory.Config> {

    private final CircuitBreakerRegistry circuitBreakerRegistry;

    public CircuitGatewayFilterFactory(CircuitBreakerRegistry circuitBreakerRegistry) {
        super(Config.class);
        this.circuitBreakerRegistry = circuitBreakerRegistry;
    }

    @Override
    public GatewayFilter apply(Config config) {
        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                .failureRateThreshold(50)
                .waitDurationInOpenState(Duration.ofMillis(1000))
                .slidingWindowSize(2)
                .build();

        CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker(config.getName(), circuitBreakerConfig);

        return (exchange, chain) -> {
            return circuitBreaker.executeSupplier(() -> chain.filter(exchange));
        };
    }

    public static class Config {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}