package com.kodilla.stream.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage() {
        int[] numbers = {1, 2, 3, 4, 5};
        double expectedAverage = 3.0;

        double actualAverage = ArrayOperations.getAverage(numbers);

        Assertions.assertEquals(expectedAverage, actualAverage);
    }
}
