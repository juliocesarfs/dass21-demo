package com.cis.dass21;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "DASS21 Demo API - Júlio Silva", version = "1", description = "API desenvolvida para testes do DASS21"))
public class Dass21ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Dass21ApiApplication.class, args);
	}

}
