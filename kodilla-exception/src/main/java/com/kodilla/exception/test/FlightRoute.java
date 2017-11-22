package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightRoute {

    public void findFlight( Flight flight) throws RouteNotFoundException{
        Map<String,Boolean> route = new HashMap<>();
        route.put("Wroclaw",true);
        route.put("Katowice",false);
        route.put("Warszawa",true);
        route.put("Poznan",false);
        route.put("Gdansk",true);

        if(route.get(flight.getArrivalAirport()) && route.get(flight.getDepartureAirport()) ){

            System.out.println("Ok!");
        }
        else
        {
            throw new RouteNotFoundException("Flight doesn't exist!");
        }
    }

}
