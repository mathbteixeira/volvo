package com.volvo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.volvo.controller.VehicleController;

@SpringBootApplication
@ComponentScan(basePackageClasses = VehicleController.class)
@EnableMongoRepositories
public class VolvoApplication {

	public static void main(String[] args) {
		SpringApplication.run(VolvoApplication.class, args);
	}

}
