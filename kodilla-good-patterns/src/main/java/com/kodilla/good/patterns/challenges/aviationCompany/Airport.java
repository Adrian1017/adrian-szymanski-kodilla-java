package com.kodilla.good.patterns.challenges.aviationCompany;

import java.util.LinkedList;
import java.util.List;

public final class Airport {
    private final List<FlightData> listOfDepartures = new LinkedList<>();

    public void addFlight(FlightData flightData)
    {
        listOfDepartures.add(flightData);
    }

    public List<FlightData> getListOfDepartures()
    {
        return listOfDepartures;
    }

}
