package com.chronorest.tech;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestClient;

import jakarta.annotation.PostConstruct;

@Configuration
@Profile("dev")
public class StoreConnexionInitializer {

    @Autowired
    private RestClient restClient;

    @Value("${server.port}")
    private String port;

    private String endpointUrl;

    @PostConstruct
    public Store RegisterStore() {
        try {
            String ip =InetAddress.getLocalHost().toString().split("/")[1];
            endpointUrl = "http://"+ip+":"+port;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        Store store = new Store(endpointUrl,"ChronoREST");
            return restClient.post()
                    .uri("/central/stores")
                    .body(store)
                    .retrieve()
                    .body(Store.class);

    }
}
