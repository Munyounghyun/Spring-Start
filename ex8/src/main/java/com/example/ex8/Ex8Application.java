package com.example.ex8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "com.example.ex8.repository")
@SpringBootApplication
public class Ex8Application {

	public static void main(String[] args) {
		SpringApplication.run(Ex8Application.class, args);
	}

}
