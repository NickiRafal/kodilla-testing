package com.kodilla.exception.test;

public class Main {
    public static void main(String[] args) {
        FlightSearch flightSearch = new FlightSearch();
        Flight flight1 = new Flight("Warszawa", "Berlin");
        Flight flight2 = new Flight("Paryż", "Londyn");
        Flight flight3 = new Flight("Paryż", "Rzym");
        Flight flight4 = new Flight("Moskwa", "Londyn");

        try {
            flightSearch.findFlight(flight1);
            flightSearch.findFlight(flight2);
            flightSearch.findFlight(flight3);
            flightSearch.findFlight(flight4);
        } catch (RouteNotFoundException e) {
            System.out.println("Nie znaleziono trasy: " + e.getMessage());

        }
    }
}