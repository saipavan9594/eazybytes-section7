package com.example.section8cards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class Section8CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Section8CardsApplication.class, args);
	}

}
