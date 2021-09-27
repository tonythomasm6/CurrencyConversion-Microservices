package com.microservices.currencyexchangeservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
//  @Retry(name="sample-api",fallbackMethod = "hardcodedResponse")
    @CircuitBreaker(name="default",fallbackMethod = "hardcodedResponse")
    @RateLimiter(name="default") // To set limit of specific number of calls in a time
    public String sampleApi(){
        logger.info("In method .................");
        //Response entity to manually fail the request
//      ResponseEntity<String> forEntity =  new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url",
//                    String.class);
//        return forEntity.getBody();
        return "call";
    }

    public String hardcodedResponse(Exception ex){
        return "fallback-response";
    }
}
