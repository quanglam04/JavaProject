package com.example.food_store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

<<<<<<< HEAD
@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class)
=======
@SpringBootApplication
// @SpringBootApplication(exclude =
// org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class)
>>>>>>> featureByLam
public class FoodStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodStoreApplication.class, args);
	}

}
