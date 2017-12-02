package com.kodilla.good.patterns.challenges.aviationCompany;

import java.time.LocalDate;

public class FlightRequest {

    private AirportsCodes departureAirport;
    private AirportsCodes arrivalAirport;
    private LocalDate dateOfDeparture;


    public AirportsCodes getDepartureAirport() { return departureAirport; }

    public AirportsCodes getArrivalAirport() {
        return arrivalAirport;
    }

    public LocalDate getDateOfDeparture() {
        return dateOfDeparture;
    }

    public FlightRequest(AirportsCodes departureAirport, AirportsCodes arrivalAirport, LocalDate dateOfDeparture) {

        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.dateOfDeparture = dateOfDeparture;
    }
}
