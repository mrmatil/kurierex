package com.example.kurierex.models;

public class UserModel {
    public String name;
    public String surname;
    public String street;
    public String apartement;
    public String city;
    public String phoneNumber;

    public UserModel(String name, String surname, String street, String apartement, String city, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.street = street;
        this.apartement = apartement;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }


}
