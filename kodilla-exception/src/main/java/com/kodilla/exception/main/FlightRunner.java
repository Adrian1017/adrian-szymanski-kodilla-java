package com.kodilla.exception.main;

import com.kodilla.exception.test.Flight;
import com.kodilla.exception.test.FlightRoute;
import com.kodilla.exception.test.RouteNotFoundException;

public class FlightRunner {
    public static void main(String[] args) {

        Flight flight1 = new Flight("Wroclaw","Warszawa");
        Flight flight2 = new Flight("Wroclaw","Poznan");

        FlightRoute flightRoute = new FlightRoute();
        System.out.println("Flight from:" + flight1.getDepartureAirport() +" to:" +flight1.getArrivalAirport());
        try {
            flightRoute.findFlight(flight1);
        }catch (RouteNotFoundException e){
        }

        System.out.println("Flight from:" + flight2.getDepartureAirport() +" to:" +flight2.getArrivalAirport());
        try {
            flightRoute.findFlight(flight2);
        }catch (RouteNotFoundException e){
            System.out.println(e);
        }
    }
}
