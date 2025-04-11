package com.chronorest.tech;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
@Profile("dev")
public class StoreConnectionInitializer {

    @Autowired
    private RestClient restClient;

    @Value("${server.port}")
    private String port;

    @Value("${spring.application.name}")
    private String applicationName;

    @PostConstruct
    public Store RegisterStore() {

        String endpointUrl = "";

        try {
            String ip= InetAddress.getLocalHost().getHostAddress();
            endpointUrl = "http://"+ip+":"+port;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        Store store = new Store(endpointUrl, applicationName);
        try {
            return restClient.post()
                    .uri("/central/stores")
                    .body(store)
                    .retrieve()
                    .body(Store.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
