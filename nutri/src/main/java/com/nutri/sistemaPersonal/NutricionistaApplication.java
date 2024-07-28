package com.nutri.sistemaPersonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class NutricionistaApplication {
    public static void main(String[] args){
        SpringApplication.run(NutricionistaApplication.class, args);
    }
}
