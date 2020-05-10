package com.matthewksc.carcatalogmain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CarCatalogMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarCatalogMainApplication.class, args);
	}

}
