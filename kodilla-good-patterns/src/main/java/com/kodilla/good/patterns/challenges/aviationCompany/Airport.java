package com.kodilla.good.patterns.challenges.aviationCompany;

import java.util.HashSet;
import java.util.Set;

public final class Airport {
    private final Set<FlightData> listOfDepartures = new HashSet<>();

    public void addFlight(FlightData flightData)
    {
        listOfDepartures.add(flightData);
    }

    public Set<FlightData> getListOfDepartures()
    {
        return listOfDepartures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airport)) return false;

        Airport airport = (Airport) o;

        return listOfDepartures.equals(airport.listOfDepartures);
    }

    @Override
    public int hashCode() {
        return listOfDepartures.hashCode();
    }
}
