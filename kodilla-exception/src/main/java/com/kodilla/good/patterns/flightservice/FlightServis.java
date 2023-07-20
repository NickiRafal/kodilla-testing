package com.kodilla.good.patterns.flightservice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightServis {
   private List<Flight>flights;

    public FlightServis() {
        flights = new ArrayList<>();
    }
    public void addFlight(String from, String via, String to){
        flights.add(new Flight(from,via,to));
    }
    public List<Flight> findAllFlightTo(String city){
        return flights.stream()
                .filter(flight -> flight.getTo().equals(city))
                .collect(Collectors.toList());
    }
    public List<Flight> findAllFlightFrom(String city){
        return flights.stream()
                .filter(flight -> flight.getFrom().equals(city))
                .collect(Collectors.toList());
    }
    public List<Flight> findFlightVia(String city){
        return flights.stream()
                .filter(flight -> flight.getVia() != null && flight.getVia().equals(city) )
                .collect(Collectors.toList());
    }
}
