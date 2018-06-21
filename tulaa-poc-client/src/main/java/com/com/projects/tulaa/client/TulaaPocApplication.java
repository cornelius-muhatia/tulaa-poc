package com.com.projects.tulaa.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class TulaaPocApplication {

    public static void main(String[] args) {
        SpringApplication.run(TulaaPocApplication.class, args);
    }
}
