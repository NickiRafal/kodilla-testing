package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertEquals;

public class BigmacTestSuite {
    @Test
    void testBigmacBuilder(){
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bum("Z sezamem")
                .burgers(3)
                .sauce("1000 wysp")
                .ingredient("cebula")
                .ingredient("bekon")
                .ingredient("ogórek")
                .ingredient("papryczki")
                .ingredient("sałata")
                .build();
        //When
        int burgersCount = bigmac.getBurgers();
        int ingredientsCount = bigmac.getIngredients().size();
        String sauce = bigmac.getSauce();
        //Then
        assertEquals(5,ingredientsCount);
        assertEquals(3,burgersCount);
        assertEquals("1000 wysp",sauce);
    }
}
