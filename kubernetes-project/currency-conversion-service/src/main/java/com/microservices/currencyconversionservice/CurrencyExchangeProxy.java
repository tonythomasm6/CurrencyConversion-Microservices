package com.microservices.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//@FeignClient(name="currency-exchange", url="localhost:8000")
//@FeignClient(name="currency-exchange")

//CHANGE-KUBERNETES
//In kubernetes env, first CURRENCY_EXCHANGE_SERVICE variable will be checked for host name discovery, if not found,
// then http://localhost.
//Env variable is automatically created by kubernetes based on service name.
//@FeignClient(name = "currency-exchange", url = "${CURRENCY_EXCHANGE_SERVICE_HOST:http://localhost}:8000")
//To give custom env variable. CURRENCY_EXCHANGE_URI configured in deployment.yaml
@FeignClient(name = "currency-exchange", url = "${CURRENCY_EXCHANGE_URI:http://localhost}:8000")
public interface CurrencyExchangeProxy {
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue(
			@PathVariable String from,
			@PathVariable String to);

}
