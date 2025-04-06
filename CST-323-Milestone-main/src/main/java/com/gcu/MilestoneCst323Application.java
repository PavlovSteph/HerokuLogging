package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MilestoneCst323Application {
	/**
	 * The main method that runs the Spring Boot Application 
	 * @param args
	 */
	public static void main(String[] args) {
		String plainTextPassword = "password";
		
		String encoded = new BCryptPasswordEncoder().encode(plainTextPassword);
		System.out.println(plainTextPassword + " encoded is: " + encoded);
		
		boolean passwordMatches = new BCryptPasswordEncoder().matches(plainTextPassword, encoded);
		
		if(passwordMatches) {
			System.out.println("Password matches!");
		}
		else {
			System.out.println("Password does not match");
		}
		SpringApplication.run(MilestoneCst323Application.class, args);
	}

}
