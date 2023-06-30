package com.kodilla.stream.world;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity() {
        // Given
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

        // When
        BigDecimal expectedPopulation = new BigDecimal("452613207");

        // Then
        Assertions.assertEquals(expectedPopulation, world.getPeopleQuantity(),
                "Incorrect total population on the world");
    }
}
