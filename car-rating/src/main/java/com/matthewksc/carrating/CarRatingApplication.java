package com.matthewksc.carrating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CarRatingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarRatingApplication.class, args);
	}

}
