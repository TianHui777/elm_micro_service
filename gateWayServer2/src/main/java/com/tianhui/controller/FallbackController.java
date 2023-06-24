package com.tianhui.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

//import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
//import org.example.po.CommonResult;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//public class FallbackController {
//    @RequestMapping("/fallback")
////    @CircuitBreaker(name = "myCircuitBreaker")
//    public CommonResult fallback() {
//        return new CommonResult(403, "Gateway触发了熔断降级", null);
//    }
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//@RestController
//public class FallbackController {
//
//    @RequestMapping("/fallback")
//    public Mono<Void> fallback(ServerWebExchange exchange) {
//        String errorMessage = "Server connection failed.";
//        exchange.getResponse().setStatusCode(HttpStatus.SERVICE_UNAVAILABLE);
//        exchange.getResponse().getHeaders().setContentType(MediaType.TEXT_PLAIN);
//        return exchange.getResponse().writeWith(Mono.just(exchange.getResponse().bufferFactory().wrap(errorMessage.getBytes())));
//    }
//}



import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @GetMapping("/fallback")
    public Mono<ResponseEntity<String>> fallback(ServerWebExchange exchange) {
        return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .contentType(MediaType.TEXT_PLAIN)
                .body("服务器出现异常"));
    }
}

