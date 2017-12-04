package com.kodilla.good.patterns.challenges.aviationCompany;

import java.util.Set;

public interface RouteService {
    public Set<FlightData> findDirectFlight(FlightRequest flightRequest);
    public Set<FlightData> findConnectingFlight( FlightRequest flightRequest);
}
