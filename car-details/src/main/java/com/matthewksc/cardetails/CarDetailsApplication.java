package com.matthewksc.cardetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CarDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarDetailsApplication.class, args);
	}

}
