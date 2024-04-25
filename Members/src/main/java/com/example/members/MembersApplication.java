package com.example.members;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MembersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MembersApplication.class, args);
	}

}
