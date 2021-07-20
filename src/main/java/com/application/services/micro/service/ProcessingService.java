package com.application.services.micro.service;

import com.application.services.micro.exception.ApplicationNotFoundException;
import com.application.services.micro.model.CustomerAddress;
import com.application.services.micro.model.Request;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.application.services.micro.model.Constants.USER_SERVICE;

@Service
public class ProcessingService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    ObjectMapper mapper;

    @Value("${user.service}")
    private String userServiceName;

    private String getApplicationUrl(String service){
        String serviceName=
                discoveryClient
                .getServices()
                .stream()
                .filter(s->s.equalsIgnoreCase(service)).findFirst().orElseThrow(()->new ApplicationNotFoundException("Couldn't find the application"));
        return serviceName ;
    }



    public void processUserService(CustomerAddress consumerRequest)  {
    String serviceUrl = getApplicationUrl(USER_SERVICE);
        HttpHeaders headers = new HttpHeaders();

        try {
            JsonNode node = mapper.readTree(String.valueOf(consumerRequest));
            System.out.println(node);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        HttpEntity<Object> httpEntity = null;
        try {
            httpEntity = new HttpEntity<>(mapper.readTree(String.valueOf(consumerRequest)),headers);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        restTemplate.exchange(serviceUrl+"/"+userServiceName, HttpMethod.POST,httpEntity, JsonNode.class);

    }

   /* public void processOrderService(){
    restTemplate.exchange();
    }*/
}
