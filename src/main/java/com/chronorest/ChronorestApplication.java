package com.chronorest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class ChronorestApplication {

	@Value("${CentralStore.endpoint}")
    private String endpointUrl;

	public static void main(String[] args) {
		SpringApplication.run(ChronorestApplication.class, args);
	}

	@Bean
	public RestClient restClient() {
		return RestClient.create(endpointUrl);
	}

}
