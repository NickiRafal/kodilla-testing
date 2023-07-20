package com.kodilla.good.patterns.flightservice;

import java.util.List;

public class ShowFlights {
    public static void main(String[] args) {


        FlightServis flightServis = new FlightServis();
        flightServis.addFlight("Gdańsk",null,"Wrocław");
        flightServis.addFlight("Gdańsk","Kraków","Wrocław");
        flightServis.addFlight("Wrocław","Warszawa","Gdańsk");
        flightServis.addFlight("Kraków",null,"Warszawa");

        List<Flight>flightsFromGdansk = flightServis.findAllFlightFrom("Gdańsk");
        System.out.println("Loty z Gdańska");
        flightsFromGdansk.forEach(System.out::println);

        List<Flight> flightsToWroclaw = flightServis.findAllFlightTo("Wrocław");
        System.out.println("Loty do Wrocławia");
        flightsToWroclaw.forEach(System.out::println);

        List<Flight> flightsViaWarszawa = flightServis.findFlightVia("Warszawa");
        System.out.println("Loty przez Warszawę");
        flightsViaWarszawa.forEach(System.out::println);
    }

}
