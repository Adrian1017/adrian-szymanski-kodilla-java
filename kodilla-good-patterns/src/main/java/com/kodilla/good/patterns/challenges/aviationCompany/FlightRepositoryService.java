package com.kodilla.good.patterns.challenges.aviationCompany;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class FlightRepositoryService implements RepositoryService {

    private final Set<Airport> listOfAirports = new HashSet<>();

    public FlightRepositoryService() {

        Airport katowice = new Airport();
        Airport wroclaw = new Airport();
        Airport gdansk = new Airport();
        Airport warszawa = new Airport();
        Airport krakow = new Airport();

        Boolean[] onlyInWeek = new Boolean[]{true, true,true,true,true, false,false}; // 1-Monday, 2-Tuesday, etc.
        Boolean[] onlyForTheWeekend = new Boolean[]{false, false,false,false,false, true,true};

        katowice.addFlight( new FlightData(AirportsCodes.KTW,AirportsCodes.WRO, LocalTime.of(8,00), LocalTime.of(10,00),onlyInWeek));
        katowice.addFlight( new FlightData(AirportsCodes.KTW,AirportsCodes.WRO, LocalTime.of(16,00), LocalTime.of(18,00),onlyInWeek));
        katowice.addFlight( new FlightData(AirportsCodes.KTW,AirportsCodes.WAW, LocalTime.of(8,00), LocalTime.of(10,00),onlyInWeek));
        katowice.addFlight( new FlightData(AirportsCodes.KTW,AirportsCodes.WAW, LocalTime.of(16,00), LocalTime.of(18,00),onlyForTheWeekend));
        katowice.addFlight( new FlightData(AirportsCodes.KTW,AirportsCodes.GDN, LocalTime.of(8,00), LocalTime.of(10,00),onlyInWeek));
        katowice.addFlight( new FlightData(AirportsCodes.KTW,AirportsCodes.GDN, LocalTime.of(16,00), LocalTime.of(18,00),onlyForTheWeekend));

        wroclaw.addFlight(new FlightData(AirportsCodes.WRO,AirportsCodes.KRK,LocalTime.of(6,0),LocalTime.of(8,0),onlyInWeek));
        wroclaw.addFlight(new FlightData(AirportsCodes.WRO,AirportsCodes.WAW,LocalTime.of(8,0),LocalTime.of(10,0),onlyInWeek));

        gdansk.addFlight(new FlightData(AirportsCodes.GDN,AirportsCodes.KTW,LocalTime.of(13,00),LocalTime.of(15,0),onlyInWeek));
        gdansk.addFlight(new FlightData(AirportsCodes.GDN,AirportsCodes.WAW,LocalTime.of(6,00),LocalTime.of(8,0),onlyInWeek));
        gdansk.addFlight(new FlightData(AirportsCodes.GDN,AirportsCodes.WAW,LocalTime.of(18,00),LocalTime.of(20,0),onlyInWeek));

        warszawa.addFlight(new FlightData(AirportsCodes.WAW,AirportsCodes.KRK,LocalTime.of(10,0),LocalTime.of(12,0),onlyInWeek));
        warszawa.addFlight(new FlightData(AirportsCodes.WAW,AirportsCodes.KTW,LocalTime.of(13,0),LocalTime.of(15,0),onlyInWeek));
        warszawa.addFlight(new FlightData(AirportsCodes.WAW,AirportsCodes.WRO,LocalTime.of(20,0),LocalTime.of(22,0),onlyInWeek));
        warszawa.addFlight(new FlightData(AirportsCodes.WAW,AirportsCodes.GDN,LocalTime.of(12,0),LocalTime.of(14,0),onlyInWeek));

        krakow.addFlight(new FlightData(AirportsCodes.KRK,AirportsCodes.KTW,LocalTime.of(16,0),LocalTime.of(18,0),onlyInWeek));
        krakow.addFlight(new FlightData(AirportsCodes.KRK,AirportsCodes.WRO,LocalTime.of(9,0),LocalTime.of(11,0),onlyInWeek));
        krakow.addFlight(new FlightData(AirportsCodes.KRK,AirportsCodes.WAW,LocalTime.of(11,0),LocalTime.of(13,0),onlyInWeek));
        krakow.addFlight(new FlightData(AirportsCodes.KRK,AirportsCodes.WAW,LocalTime.of(19,0),LocalTime.of(21,0),onlyForTheWeekend));

       listOfAirports.add(katowice);
       listOfAirports.add(wroclaw);
       listOfAirports.add(gdansk);
       listOfAirports.add(warszawa);
       listOfAirports.add(krakow);
    }

    @Override
    public Set<Airport> getListOfAirports() {
        return listOfAirports;
    }
}
