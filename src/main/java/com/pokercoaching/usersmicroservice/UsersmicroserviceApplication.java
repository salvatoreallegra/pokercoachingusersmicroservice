package com.pokercoaching.usersmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableDiscoveryClient
public class UsersmicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersmicroserviceApplication.class, args);
	}

}
