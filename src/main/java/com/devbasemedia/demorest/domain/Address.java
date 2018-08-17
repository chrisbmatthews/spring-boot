package com.devbasemedia.demorest.domain;

public class Address {
    private int civicNumber;
    private String streetName;
    private String city;
    private State state;
    private String zipCode;
    private Country country;

    public int getCivicNumber() {
        return civicNumber;
    }

    public void setCivicNumber(int civicNumber) {
        this.civicNumber = civicNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Address() {

    }
}
