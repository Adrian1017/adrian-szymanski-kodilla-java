package com.kodilla.good.patterns.challenges.aviationCompany;

public class FlightInformationSystem implements InformationService {
    @Override
    public void inform(FlightInformationDto flightInformationDto) {
        System.out.println(" Dear " + flightInformationDto.getPassenger().getName() + " " + flightInformationDto.getPassenger().getSurname() +"!");
        System.out.println(flightInformationDto.getMessage());
    }
}
