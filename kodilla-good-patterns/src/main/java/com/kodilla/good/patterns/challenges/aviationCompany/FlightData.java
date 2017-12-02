package com.kodilla.good.patterns.challenges.aviationCompany;

import java.time.LocalTime;
import java.util.Arrays;

public class FlightData  {
    private AirportsCodes arrivalAirport;
    private AirportsCodes departureAirport;
    private LocalTime timeOfDeparture;
    private LocalTime timeOfArrival;
    private Boolean[] weeklyFlights = new Boolean[7]; // 1-Monday, 2-Tuesday, etc.

    public FlightData(AirportsCodes departureAirport, AirportsCodes arrivalAirport, LocalTime timeOfDeparture, LocalTime timeOfArrival, Boolean[] weeklyFlights) {
        this.arrivalAirport = arrivalAirport;
        this.departureAirport = departureAirport;
        this.timeOfDeparture = timeOfDeparture;
        this.timeOfArrival = timeOfArrival;
        this.weeklyFlights = weeklyFlights;
    }

    public AirportsCodes getArrivalAirport() {
        return arrivalAirport;
    }

    public LocalTime getTimeOfDeparture() {
        return timeOfDeparture;
    }

    public LocalTime getTimeOfArrival() {
        return timeOfArrival;
    }

    public AirportsCodes getDepartureAirport() {
        return departureAirport;
    }

    public Boolean[] getWeeklyFlights() {
        return weeklyFlights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlightData)) return false;

        FlightData that = (FlightData) o;

        if (arrivalAirport != that.arrivalAirport) return false;
        if (departureAirport != that.departureAirport) return false;
        if (!timeOfDeparture.equals(that.timeOfDeparture)) return false;
        if (!timeOfArrival.equals(that.timeOfArrival)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(weeklyFlights, that.weeklyFlights);
    }

    @Override
    public int hashCode() {
        int result = arrivalAirport.hashCode();
        result = 31 * result + departureAirport.hashCode();
        result = 31 * result + timeOfDeparture.hashCode();
        result = 31 * result + timeOfArrival.hashCode();
        result = 31 * result + Arrays.hashCode(weeklyFlights);
        return result;
    }

    @Override
    public String toString() {
        return "FlightData{" +
                "departureAirport=" + departureAirport +
                ", arrivalAirport=" + arrivalAirport +
                ", timeOfDeparture=" + timeOfDeparture +
                ", timeOfArrival=" + timeOfArrival + "}";
    }
}
