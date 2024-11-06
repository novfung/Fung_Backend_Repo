package com.example.fung_backend_repo;

import com.example.fung_backend_repo.global.security.jwt.JwtProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(JwtProperty.class)
@ConfigurationPropertiesScan
@SpringBootApplication
public class FungBackendRepoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FungBackendRepoApplication.class, args);
	}

}
