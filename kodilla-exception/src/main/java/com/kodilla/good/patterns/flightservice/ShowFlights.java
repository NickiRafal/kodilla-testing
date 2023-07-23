package com.kodilla.good.patterns.flightservice;

import java.util.List;

public class ShowFlights {
    public static void main(String[] args) {


        FlightService flightService = new FlightService();
        flightService.addFlight("Gdańsk",null,"Wrocław");
        flightService.addFlight("Gdańsk","Kraków","Wrocław");
        flightService.addFlight("Wrocław","Warszawa","Gdańsk");
        flightService.addFlight("Kraków",null,"Warszawa");

        List<Flight>flightsFromGdansk = flightService.findAllFlightFrom("Gdańsk");
        System.out.println("Loty z Gdańska");
        flightsFromGdansk.forEach(System.out::println);

        List<Flight> flightsToWroclaw = flightService.findAllFlightTo("Wrocław");
        System.out.println("Loty do Wrocławia");
        flightsToWroclaw.forEach(System.out::println);

        List<Flight> flightsViaWarszawa = flightService.findFlightVia("Warszawa");
        System.out.println("Loty przez Warszawę");
        flightsViaWarszawa.forEach(System.out::println);
    }

}
