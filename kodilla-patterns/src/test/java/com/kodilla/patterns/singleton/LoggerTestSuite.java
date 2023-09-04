package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertEquals;

public class LoggerTestSuite {
    @Test
    void testLogAndLastLog(){
        //Given
        Logger logger = Logger.INSTANCE;
        //When
        logger.log("Log1");
        //Then
        assertEquals("Log1",logger.getLastLog());
    }
    @Test
    void testSingleton() {
        // Given
        Logger logger1 = Logger.INSTANCE;
        Logger logger2 = Logger.INSTANCE;

        // When
        logger1.log("Log from logger1");
        logger2.log("Log from logger2");

        // Then
        assertEquals("Log from logger2", logger1.getLastLog());
        assertEquals("Log from logger2", logger2.getLastLog());
    }
}
