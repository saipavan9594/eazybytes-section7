package com.example.section7accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@RefreshScope
public class Section7AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Section7AccountsApplication.class, args);
	}

}
