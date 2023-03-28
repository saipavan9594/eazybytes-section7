package com.example.section7configserver2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Section7Configserver2Application {

	public static void main(String[] args) {
		SpringApplication.run(Section7Configserver2Application.class, args);
	}

}
