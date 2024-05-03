package com.msvc.compradores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CompradoresServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompradoresServiceApplication.class, args);
	}

}
