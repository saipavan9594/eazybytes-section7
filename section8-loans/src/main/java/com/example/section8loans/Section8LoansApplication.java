package com.example.section8loans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@RefreshScope
public class Section8LoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(Section8LoansApplication.class, args);
	}

}
