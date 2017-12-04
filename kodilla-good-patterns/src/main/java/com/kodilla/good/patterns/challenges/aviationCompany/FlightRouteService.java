package com.kodilla.good.patterns.challenges.aviationCompany;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FlightRouteService implements  RouteService {
    private RepositoryService repositoryService;

    public FlightRouteService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @Override
    public Set<FlightData> findDirectFlight(FlightRequest flightRequest) {

        Set<Airport> listOfAirports = repositoryService.getListOfAirports();

        int numberOfDayOfWeek = flightRequest.getDateOfDeparture().getDayOfWeek().getValue();

        return listOfAirports.stream()
                .flatMap(flight -> flight.getListOfDepartures().stream())
                .filter( flight -> flight.getDepartureAirport().equals(flightRequest.getDepartureAirport()))
                .filter(flight -> flight.getArrivalAirport().equals(flightRequest.getArrivalAirport()))
                .filter(flight -> Arrays.asList(flight.getWeeklyFlights()).get(numberOfDayOfWeek - 1).equals(true))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<FlightData> findConnectingFlight(FlightRequest flightRequest) {
           Set<Airport> listOfAirports = repositoryService.getListOfAirports();

        int numberOfDayOfWeek = flightRequest.getDateOfDeparture().getDayOfWeek().getValue();

        Set<FlightData> listOfpossibleDeparturesFlights = listOfAirports.stream()
                .flatMap( a -> a.getListOfDepartures().stream())
                .filter( f -> f.getDepartureAirport().equals(flightRequest.getDepartureAirport()))
                .collect(Collectors.toSet());


        Set<FlightData> listOfpossibleArrivalFlights = listOfAirports.stream()
                .flatMap( a -> a.getListOfDepartures().stream())
                .filter( f -> f.getArrivalAirport().equals(flightRequest.getArrivalAirport()))
                .collect(Collectors.toSet());


        Set<FlightData> listOfConnectingFlights = new HashSet<>();

        for( FlightData flightDeparture : listOfpossibleDeparturesFlights){
            for( FlightData flightArrival : listOfpossibleArrivalFlights){
                boolean isConnectedFlights = flightDeparture.getArrivalAirport().equals(flightArrival.getDepartureAirport());
                if(isConnectedFlights){
                    boolean isEnoughTimeForChange = flightDeparture.getTimeOfArrival().plusHours(1).isBefore(flightArrival.getTimeOfDeparture());
                    if(isEnoughTimeForChange) {
                        listOfConnectingFlights.add(flightDeparture);
                        listOfConnectingFlights.add(flightArrival);
                    }
                }
            }
        }
        return listOfConnectingFlights;
    }
}