package com.application.services.micro.controller;

import com.application.services.micro.model.CustomerAddress;
import com.application.services.micro.model.Request;
import com.application.services.micro.service.ProcessingService;
import org.bouncycastle.cert.ocsp.Req;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@RequestMapping("/micro")
public class MicroServiceController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ProcessingService processingService;

    /*public void processIncomingRequest(Request request){

        callUserService();
        callOrderService();
    }*/

    @PostMapping("/process/users")
    public ResponseEntity<?> callUserService(@RequestBody CustomerAddress request){
        processingService.processUserService(request);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
