package com.aluno.sistemaPersonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AlunoPersonalApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlunoPersonalApplication.class, args);
	}

}
