package com.example.demo;

public class Address {
    private String street;
    private String city;
    private String state;
    private String zip;

    public Address(String street, String city, String state, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    // Getter for the street property
    public String getStreet() {
        return street;
    }

    // Getter for the city property
    public String getCity() {
        return city;
    }

    // Getter for the state property
    public String getState() {
        return state;
    }

    // Getter for the zip property
    public String getZip() {
        return zip;
    }
    @Override
    public String toString() {
        return "Address [street=" + street + ", city=" + city + ", state=" + state + ", zip=" + zip + "]";
    }
}