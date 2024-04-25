package com.example.circulation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CirculationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CirculationApplication.class, args);
	}

}
