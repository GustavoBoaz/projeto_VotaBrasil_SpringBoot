package com.votabrasil.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenAPIConfiguration {
	
	@Bean
	public OpenAPI springOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Projeto Vota Brasil")
						.description("Api para consumo de Votos apurados na eleição 2022")
						.version("v0.0.1")
						.license(new License()
								.name("Generation Brazil")
								.url("https://brazil.generation.org/"))
						.contact(new Contact()
								.name("Github Boaz")
								.url("https://github.com/GustavoBoaz/")
								.email("gustavo.boaz@hotmail.com")))
				.externalDocs(new ExternalDocumentation()
						.description("Github Project")
						.url("https://github.com/GustavoBoaz/project_VotaBrasil"));
	}

}
