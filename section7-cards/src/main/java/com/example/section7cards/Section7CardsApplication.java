package com.example.section7cards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class Section7CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Section7CardsApplication.class, args);
	}

}
