package com.example;

import com.example.entites.SpringSecurityAuditor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef="auditorAware")
public class BusManagementApplication {


	@Bean
	public AuditorAware<String> auditorAware(){

		return new SpringSecurityAuditor();
	}

	public static void main(String[] args) {
		SpringApplication.run(BusManagementApplication.class, args);
	}

}
