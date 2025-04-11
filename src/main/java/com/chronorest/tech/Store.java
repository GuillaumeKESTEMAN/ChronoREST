package com.chronorest.tech;

public class Store {
    private String name;
    private String baseUrl;

    public Store (){}

    public Store(String baseUrl, String name) {
        this.baseUrl = baseUrl;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

}
