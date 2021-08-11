package com.microservices.currencyconversionservice.feignClient;

import com.microservices.currencyconversionservice.entity.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchange", url="localhost:8000")
@FeignClient(name="currency-exchange") // If url is removed then it will talk to eureka naming server with name
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
    //CurrencyConversion and currencyExchange entity structure matches.
    //Hence, since we dont have access to currencyExchange, we are using currencyConversion here.
}
