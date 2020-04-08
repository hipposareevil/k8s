package com.example.springboot;

import java.net.URI;
import java.util.Optional;
import java.io.*;
import javax.naming.ServiceUnavailableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


@RestController
public class HelloController {

    @Autowired
    private DiscoveryClient discoveryClient;

    private final RestTemplate restTemplate = new RestTemplate();


    @Value("${my.prop}")
    String value;

   @Autowired
    private MyProperties properties;



 @GetMapping("/getConfigFromValue")
    public String getConfigFromValue() {
        return value;
    }

    @GetMapping("/getConfigFromProperty")
    public String getConfigFromProperty() {
        return properties.getProp();
    }



	@RequestMapping("/")
	public String index() throws Exception {
        String result = "";
        result = "filter it";
        return result;
	}


    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }


    @GetMapping("/discoveryClient")
    public String discoveryPing() throws RestClientException, ServiceUnavailableException {
        URI service = serviceUrl().map(s -> s.resolve("/ping"))
                .orElseThrow(ServiceUnavailableException::new);
        return restTemplate.getForEntity(service, String.class)
                .getBody();
    }




    @FilterEndpoint
	@RequestMapping("/filter/{tenantId}")
	public String filter(@PathVariable("tenantId") String tenantId) throws Exception {
        String result = "";
        result = "filter by id: '" + tenantId + "'";
        return result;
	}

    public Optional<URI> serviceUrl() {
        return discoveryClient.getInstances("filterit")
                .stream()
                .findFirst()
                .map(si -> si.getUri());
    }

}