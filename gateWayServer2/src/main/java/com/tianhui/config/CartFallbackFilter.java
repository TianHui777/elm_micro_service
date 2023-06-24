package com.tianhui.config;

import com.tianhui.controller.FallbackController;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
@Component
public class CartFallbackFilter extends AbstractGatewayFilterFactory<Object> {
    private final FallbackController fallbackController;
    public CartFallbackFilter(FallbackController fallbackController) {
        this.fallbackController = fallbackController;
    }

    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            return chain.filter(exchange)
                    .onErrorResume(throwable -> {
                        ServerWebExchangeUtils.setResponseStatus(exchange, HttpStatus.SERVICE_UNAVAILABLE);
                        return fallback(exchange);
                    });
        };
    }

    private Mono<Void> fallback(ServerWebExchange exchange) {
        exchange.getResponse().setStatusCode(HttpStatusCode.valueOf(403));
        exchange.getResponse().getHeaders().setContentType(MediaType.TEXT_PLAIN);
        return exchange.getResponse().writeWith(Mono.just(exchange.getResponse().bufferFactory().wrap("当前访问人数过多，请稍后重试".getBytes())));
    }

}
