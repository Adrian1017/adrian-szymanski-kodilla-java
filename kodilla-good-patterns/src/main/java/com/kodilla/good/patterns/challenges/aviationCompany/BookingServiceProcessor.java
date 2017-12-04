package com.kodilla.good.patterns.challenges.aviationCompany;


import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class BookingServiceProcessor {

    private FlightRouteService flightRouteService;
    private FlightInformationSystem flightInformationSystem;
    private Set<FlightData> listOfFlights = new HashSet<>();
    private final static String AIRPORT = "-Airport";
    private final static String DIRECT_FLIGHTS = "Direct flights from: ";
    private final static String CONNECTING_FLIGHTS = "On this day there are only connecting flights from: ";
    private final static String NO_FLIGHTS = "On this day there are no flights to the ";
    private final static String TO = " to: ";

    public BookingServiceProcessor(FlightRouteService flightRouteService, FlightInformationSystem flightInformationSystem) {
        this.flightRouteService = flightRouteService;
        this.flightInformationSystem = flightInformationSystem;
    }

    public void process(BookingRequest bookingRequest){

        if(isDirectFlight(bookingRequest)) {
           sendConfirmationForDirectFligth(bookingRequest);
        }
        else if (isConnectingFlight(bookingRequest)){
           sendConfirmationForConnectingFligth(bookingRequest);
        }
        else{
           sendConfirmationForNoFlight(bookingRequest);
        }
    }

    private boolean isDirectFlight(BookingRequest bookingRequest){
        listOfFlights = flightRouteService.findDirectFlight(bookingRequest.getFlightRequest());
        return listOfFlights.isEmpty() ? false: true;
    }

    private boolean isConnectingFlight(BookingRequest bookingRequest){
        listOfFlights = flightRouteService.findConnectingFlight(bookingRequest.getFlightRequest());
        return listOfFlights.isEmpty() ? false: true;
    }

    private void sendConfirmationForDirectFligth(BookingRequest bookingRequest){
        String message = DIRECT_FLIGHTS + bookingRequest.getFlightRequest().getDepartureAirport()
                + AIRPORT + TO + bookingRequest.getFlightRequest().getArrivalAirport() + AIRPORT + ":\n";
        message = message + listOfFlights.stream().map( f -> f.toString()).collect(Collectors.joining("\n"));
        flightInformationSystem.inform( new FlightInformationDto( bookingRequest.getPassenger(), message));
    }

    private void sendConfirmationForConnectingFligth(BookingRequest bookingRequest){
        String message = CONNECTING_FLIGHTS + bookingRequest.getFlightRequest().getDepartureAirport()
        + AIRPORT + TO + bookingRequest.getFlightRequest().getArrivalAirport()+ AIRPORT + ":\n";
        message = message + listOfFlights.stream().map( f -> f.toString()).collect(Collectors.joining("\n"));
        flightInformationSystem.inform( new FlightInformationDto( bookingRequest.getPassenger(), message));
    }
    private void sendConfirmationForNoFlight( BookingRequest bookingRequest){
        String message = NO_FLIGHTS + bookingRequest.getFlightRequest().getArrivalAirport() + AIRPORT;
        flightInformationSystem.inform( new FlightInformationDto( bookingRequest.getPassenger(), message));
    }
}
