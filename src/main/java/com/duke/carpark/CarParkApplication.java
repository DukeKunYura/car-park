package com.duke.carpark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarParkApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarParkApplication.class, args);
		System.out.println("Hey");
	}
}
