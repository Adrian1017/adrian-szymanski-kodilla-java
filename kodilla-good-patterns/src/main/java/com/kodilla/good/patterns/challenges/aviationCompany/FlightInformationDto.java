package com.kodilla.good.patterns.challenges.aviationCompany;

public class FlightInformationDto {
    private Passenger passenger;
    private String message;

    public Passenger getPassenger() {
        return passenger;
    }

    public String getMessage() {
        return message;
    }

    public FlightInformationDto(Passenger passenger, String message) {
        this.passenger = passenger;
        this.message = message;
    }
}
