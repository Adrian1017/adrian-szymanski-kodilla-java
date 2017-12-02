package com.kodilla.good.patterns.challenges.aviationCompany;


import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class BookingServiceProcessor {

    private FlightRouteService flightRouteService;
    private FlightInformationSystem flightInformationSystem;
    private List<FlightData> listOfFlights = new LinkedList<>();

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
        String message = "Direct flights from: " + bookingRequest.getFlightRequest().getDepartureAirport()
                + "-Airport" + " to: " + bookingRequest.getFlightRequest().getArrivalAirport() + "-Airport" + ":\n";
        message = message + listOfFlights.stream().map( f -> f.toString()).collect(Collectors.joining("\n"));
        flightInformationSystem.inform( new FlightInformationDto( bookingRequest.getPassenger(), message));
    }

    private void sendConfirmationForConnectingFligth(BookingRequest bookingRequest){
        String message ="On this day there are only connecting flights from: " + bookingRequest.getFlightRequest().getDepartureAirport()
        + "-Airport" + " to: " + bookingRequest.getFlightRequest().getArrivalAirport()+ "-Airport" + ":\n";
        message = message + listOfFlights.stream().map( f -> f.toString()).collect(Collectors.joining("\n"));
        flightInformationSystem.inform( new FlightInformationDto( bookingRequest.getPassenger(), message));
    }
    private void sendConfirmationForNoFlight( BookingRequest bookingRequest){
        String message = "On this day there are no flights to the " + bookingRequest.getFlightRequest().getArrivalAirport() + "-Airport";
        flightInformationSystem.inform( new FlightInformationDto( bookingRequest.getPassenger(), message));
    }
}
