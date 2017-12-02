package com.kodilla.good.patterns.challenges.aviationCompany;

public class Application {

    public static void main(String[] args) {

    System.out.println("Example for a direct flight:\n");
    BookingRequestRetriever bookingRequestRetriever = new BookingRequestRetriever();
    BookingRequest bookingRequest = bookingRequestRetriever.retrieve();

    BookingServiceProcessor bookingServiceProcessor = new BookingServiceProcessor( new FlightRouteService( new FlightRepositoryService()), new FlightInformationSystem());
    bookingServiceProcessor.process(bookingRequest);

    System.out.println("\nExample for a connecting flight:\n");
    BookingRequestRetriever2 bookingRequestRetriever2 = new BookingRequestRetriever2();
    BookingRequest bookingRequest2 = bookingRequestRetriever2.retrieve();

    bookingServiceProcessor = new BookingServiceProcessor( new FlightRouteService( new FlightRepositoryService()), new FlightInformationSystem());
    bookingServiceProcessor.process(bookingRequest2);
    }
}
