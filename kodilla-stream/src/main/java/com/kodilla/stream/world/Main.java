package com.kodilla.stream.world;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Country poland = new Country("Poland", new BigDecimal("38420000"));
        Country germany = new Country("Germany", new BigDecimal("83190556"));
        Country usa = new Country("United States", new BigDecimal("331002651"));

        Continent europe = new Continent("Europe");
        europe.addCountry(poland);
        europe.addCountry(germany);

        Continent northAmerica = new Continent("North America");
        northAmerica.addCountry(usa);

        World world = new World();
        world.addContinent(europe);
        world.addContinent(northAmerica);

        BigDecimal totalPopulation = world.getPeopleQuantity();
        System.out.println("Total world population: " + totalPopulation);
        System.out.println(world.toString());
    }
}