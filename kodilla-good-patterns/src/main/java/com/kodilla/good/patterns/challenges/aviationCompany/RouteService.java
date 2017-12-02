package com.kodilla.good.patterns.challenges.aviationCompany;

import java.util.List;

public interface RouteService {
    public List<FlightData> findDirectFlight(FlightRequest flightRequest);
    public List<FlightData> findConnectingFlight( FlightRequest flightRequest);
}
