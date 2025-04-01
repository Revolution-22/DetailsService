package com.revolution.details.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class DetailsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DetailsServiceApplication.class, args);
	}

}
