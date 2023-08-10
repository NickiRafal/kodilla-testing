package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTestSuite {
    @Autowired
    private Calculator calculator;
    @Test
    void testCalculations(){
        //Given

        //When
        double addResult = calculator.add(2,8);
        double subResult = calculator.sub(9,4);
        double mulResult = calculator.mul(7,4);
        double divResult = calculator.div(4,2);
        //Then
        assertEquals(10,addResult);
        assertEquals(5,subResult);
        assertEquals(28,mulResult);
        assertEquals(2,divResult);
    }

}
