package com.catalogo.esercizioCatalogo.bin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "com.catalogo.esercizioCatalogo.service", "com.catalogo.esercizioCatalogo.controller" })
@EnableJpaRepositories(basePackages = { "com.catalogo.esercizioCatalogo.repository" })
@EntityScan(basePackages = { "com.catalogo.esercizioCatalogo.model" })
public class EsercizioCatalogoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsercizioCatalogoApplication.class, args);
	}

}
