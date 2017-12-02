package com.kodilla.good.patterns.challenges.aviationCompany;

import java.time.LocalDate;

public class BookingRequestRetriever {

    public BookingRequest retrieve(){
    Passenger passenger = new Passenger("Jan","Nowak","ul. Racławicka 12, \n" +
            "53-148 Wrocław, Polska","737 690 578","contact@kodylla.com");
    FlightRequest flightRequest = new FlightRequest(AirportsCodes.WRO, AirportsCodes.WAW, LocalDate.of(2017,12,1));
    return new BookingRequest( passenger, flightRequest);
    }
}
