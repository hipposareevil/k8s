package com.example.springboot;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@Configuration
@ConfigurationProperties("gate.tenant")
public class MyProperties {

    private String k8s;

    public String getK8s() {
        return k8s;
    }

    public void setK8s(String prop) {
        this.k8s = prop;
    }

}
