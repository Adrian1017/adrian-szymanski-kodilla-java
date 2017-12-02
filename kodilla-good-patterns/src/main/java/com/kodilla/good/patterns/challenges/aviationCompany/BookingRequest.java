package com.kodilla.good.patterns.challenges.aviationCompany;


public class BookingRequest {
    private Passenger passenger;
    private FlightRequest flightRequest;

    public Passenger getPassenger() {
        return passenger;
    }

    public FlightRequest getFlightRequest() {
        return flightRequest;
    }

    public BookingRequest(Passenger passenger, FlightRequest flightRequest) {

        this.passenger = passenger;
        this.flightRequest = flightRequest;
    }
}
