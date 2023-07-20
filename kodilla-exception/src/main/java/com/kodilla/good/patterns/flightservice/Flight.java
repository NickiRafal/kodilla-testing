package com.kodilla.good.patterns.flightservice;

import java.util.Objects;

public class Flight {
    private String from;
    private String via;
    private String to;

    public Flight(String from, String via, String to) {
        this.from = from;
        this.via = via;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public String getVia() {
        return via;
    }

    public String getTo() {
        return to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(from, flight.from) && Objects.equals(via, flight.via) && Objects.equals(to, flight.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, via, to);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "from='" + from + '\'' +
                ", via='" + via + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}
