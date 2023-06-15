package com.duke.carpark;

import org.hibernate.boot.SchemaAutoTooling;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarParkApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarParkApplication.class, args);
		System.out.println("Hey");
	}

	// @Bean
	// public Docket productApi() {
	// return new Docket(DocumentationType.SWAGGER_2).select()
	// .apis(RequestHandlerSelectors.basePackage("com.duke.carpark")).build();
	// }

	https:// springdoc.org/#migrating-from-springfox

}
