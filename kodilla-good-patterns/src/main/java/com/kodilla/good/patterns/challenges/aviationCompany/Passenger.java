package com.kodilla.good.patterns.challenges.aviationCompany;

public class Passenger {
    private String name;
    private String surname;
    private String adress;
    private String phoneNumber;
    private String email;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAdress() {
        return adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Passenger(String name, String surname, String adress, String phoneNumber, String email) {

        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
