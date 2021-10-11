# CurrencyConversion-Microservices-GCP
#Title: Currency conversion and exchange services implemented using Spring cloud microservices

Currency conversion service implemented using Spring boot microservices. It has 2 microservices:
       1) currency-exchange: To fetch the exchange rate for each currency (eg: from AUD to USD) from associated database
       2) Currency-conversion: It uses the exchange rate fetched from currency-exchange service to convert the input currency amount to required currency.
       

 
 The whole project was implemented in 2 ways. In local environment and in cloud using Google Cloud Platform(GCP).
 

<b><i>Google Cloud Platform (GCP)</i></b>  <br/>
       Both microservices where created using Spring boot and then docker images created for both. Images were then uploaded to docker hub.
      ![image](https://user-images.githubusercontent.com/68453981/136789202-256cbfe1-227a-45de-9be3-8c7f58ffa5c9.png)
      
      
      
      
In GCP, a new cluster engine is created.
      ![image](https://user-images.githubusercontent.com/68453981/136789524-4c74878f-aa3d-4165-83a4-43b2adce69d7.png)
      
      
      
      
      
      
Using deployment.yaml, service.yaml and configmap.yaml, the docker images (currency-conversion and currency-exchange) were deployed 
      into the kubernetes cluster created in last step. It was done by using Google Cloud SDK shell. Sample deployment yaml given below:
      ![image](https://user-images.githubusercontent.com/68453981/136790006-19e7b0d2-e9d7-4505-953c-d04427bf81ce.png)
      
      
      
      
      
After deployment, 2 pods, one each for currency-conversion and currency-exchange is created (since relicas count is set as 1 for both).
      ![image](https://user-images.githubusercontent.com/68453981/136791006-bc2344fd-c5e0-4e21-838c-c18670287b36.png)
      
Services created with public IP to access the service.
      ![image](https://user-images.githubusercontent.com/68453981/136790590-f5fe7107-a614-4848-8d99-6c0397926893.png)

Application running using the public port
![image](https://user-images.githubusercontent.com/68453981/136792238-124e6da8-1ab2-4304-8ac5-b9ff5ddd992c.png)
      
       
