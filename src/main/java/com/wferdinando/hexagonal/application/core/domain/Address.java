package com.wferdinando.hexagonal.application.core.domain;

public class Address {

    private String street;

    private String city;
    
    private String state;
    

    public Address(String street, String city, String state) {
        this.street = street;
        this.city = city;
        this.state = state;
    }

    public Address(){}

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}
