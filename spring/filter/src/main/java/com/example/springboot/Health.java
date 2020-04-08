package com.example.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Health {

    @RequestMapping("/health")
    public String health() {
        return "OK";
    }
}
