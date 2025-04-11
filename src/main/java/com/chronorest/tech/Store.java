package com.chronorest.tech;

public class Store {
    private String name;
    private String baseUrl;

    public Store(String baseUrl, String name) {
        this.baseUrl = baseUrl;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

}
