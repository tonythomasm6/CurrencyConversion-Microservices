# CurrencyConversion-Microservices-GCP
#Title: Currency conversion and exchange services implemented using Spring cloud microservices

Currency conversion service implemented using Spring boot microservices. It has 2 microservices:
        1) currency-exchange: To fetch the exchange rate for each currency (eg: from AUD to USD) from associated database
        2) Currency-conversion: It uses the exchange rate fetched from currency-exchange service to convert the input currency amount to required currency.
       

 
 The whole project was implemented in 2 ways. In local environment and in cloud using Google Cloud Platform(GCP).
 --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

<b><i>Google Cloud Platform (GCP)</i></b>  <br/>
---------------------------------------------------
       <b>Both microservices where created using Spring boot and then docker images created for both. Images were then uploaded to docker hub.</b>
      ![image](https://user-images.githubusercontent.com/68453981/136789202-256cbfe1-227a-45de-9be3-8c7f58ffa5c9.png)
      
      
      
      
<b>In GCP, a new cluster engine is created.</b>
      ![image](https://user-images.githubusercontent.com/68453981/136789524-4c74878f-aa3d-4165-83a4-43b2adce69d7.png)
      
      
      
      
      
      
<b>Using deployment.yaml, service.yaml and configmap.yaml, the docker images (currency-conversion and currency-exchange) were deployed 
      into the kubernetes cluster created in last step. It was done by using Google Cloud SDK shell. Sample deployment yaml given below:</b>
      ![image](https://user-images.githubusercontent.com/68453981/136790006-19e7b0d2-e9d7-4505-953c-d04427bf81ce.png)
      
      
      
      
      
<b>After deployment, 2 pods, one each for currency-conversion and currency-exchange is created (since relicas count is set as 1 for both).</b>
      ![image](https://user-images.githubusercontent.com/68453981/136791006-bc2344fd-c5e0-4e21-838c-c18670287b36.png)
      
<b>Services created with public IP to access the service.</b>
      ![image](https://user-images.githubusercontent.com/68453981/136790590-f5fe7107-a614-4848-8d99-6c0397926893.png)

<b>Application running using the public IP  </b>
![image](https://user-images.githubusercontent.com/68453981/136792238-124e6da8-1ab2-4304-8ac5-b9ff5ddd992c.png)
      
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 Local environment using Netflix Eureka server
 ---------------------------------------------
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Both microservices are deployed locally. The following services where utilized for it:
       1) Netflix Eureka : For service discovery  <br/>
       2) Zipkin : Distributed Tracing  <br/>
       3) API gateway : For request routing  <br/>
       4) Hystrix: Fault tolerance  <br/>
       5) Resiliance4j : Circuit breaker.  <br/>
       
<b>Instances registered with Eureka</b>
       ![image](https://user-images.githubusercontent.com/68453981/136793533-a0a2064a-26a6-48d7-9053-edf722379685.png)
       
<b>Zipkin distributed tracing</b>
       ![image](https://user-images.githubusercontent.com/68453981/136796538-992c6bd7-789d-4f60-8a02-b91283fd4338.png)
       
<b>Demo</b>   
       ![image](https://user-images.githubusercontent.com/68453981/136797294-32744cc5-9d91-4af4-b584-f378a7978081.png)




       
