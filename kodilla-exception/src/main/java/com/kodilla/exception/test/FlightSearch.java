package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {
    private Map<String, Boolean> airportMap;

    public FlightSearch() {
        airportMap = new HashMap<>();
        airportMap.put("Warszawa", true);
        airportMap.put("Berlin", true);
        airportMap.put("Paryż", false);
        airportMap.put("Londyn", true);
        airportMap.put("Rzym", false);
    }

    public void findFlight(Flight flight) throws RouteNotFoundException {
        String departureAirport = flight.getDepartureAirport();
        String arrivalAirport = flight.getArrivalAirport();

        if (!airportMap.containsKey(departureAirport) || !airportMap.containsKey(arrivalAirport)) {
            throw new RouteNotFoundException("Nie znaleziono trasy.");

        }

        boolean canFlyToDestination = airportMap.get(arrivalAirport);
        if (!canFlyToDestination) {
            throw new RouteNotFoundException("Nie można polecieć do miejsca docelowego.");
        }

        System.out.println("Lot znaleziony z " + departureAirport + " do " + arrivalAirport);
    }
}