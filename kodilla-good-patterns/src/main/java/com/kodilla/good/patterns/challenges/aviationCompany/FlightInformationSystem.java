package com.kodilla.good.patterns.challenges.aviationCompany;

public class FlightInformationSystem implements InformationService {
    private final static String DEAR = "Dear ";
    @Override
    public void inform(FlightInformationDto flightInformationDto) {
        System.out.println( DEAR + flightInformationDto.getPassenger().getName() + " " + flightInformationDto.getPassenger().getSurname() +"!");
        System.out.println(flightInformationDto.getMessage());
    }
}
