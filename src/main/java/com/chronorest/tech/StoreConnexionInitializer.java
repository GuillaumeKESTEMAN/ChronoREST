package com.chronorest.tech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientResponseException;

import jakarta.annotation.PostConstruct;

@Configuration
public class StoreConnexionInitializer {

    @Autowired
    private RestClient restClient;

    @Value("${CentralStore.endpoint}")
    private String endpointUrl;

    @PostConstruct
    public Store RegisterStore() {
        Store store = new Store(endpointUrl,"ChronoREST");
        try {
            return restClient.post()
                    .uri("/central/stores")
                    .body(store)
                    .retrieve()
                    .body(Store.class);
        } catch (RestClientResponseException e) {
            throw e;
        }
    }
}
