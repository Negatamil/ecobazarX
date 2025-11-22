package com.first.ecobazaar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcobazaarApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcobazaarApplication.class, args);
		System.out.println("EcoBazaarX Backend Started Successfully!");
		System.out.println("Carbon Footprint Aware Shopping Assistant is now running...");
	}
}