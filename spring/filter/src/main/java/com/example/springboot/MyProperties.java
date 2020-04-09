package com.example.springboot;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@Configuration
@ConfigurationProperties("tenant")
public class MyProperties {

    private String fast;
    private String slow;
    private String dcos;
    private String k8s;

    public String getDcos() {
        return dcos;
    }

    public void setDcos(String prop) {
        this.dcos = prop;
    }


    public String getK8s() {
        return k8s;
    }

    public void setK8s(String prop) {
        this.k8s = prop;
    }


    public String getFast() {
        return fast;
    }

    public void setFast(String prop) {
        this.fast = prop;
    }


    public String getSlow() {
        return slow;
    }

    public void setSlow(String prop) {
        this.slow = prop;
    }

}
