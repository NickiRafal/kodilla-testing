package com.kodilla.testing.collection;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionTestSuite {
    private OddNumbersExterminator exterminator;

    @BeforeEach
    public void before() {
        exterminator = new OddNumbersExterminator();
        System.out.println("Tworzenie instancji klasy OddNumbersExterminator niezbędnej do testu ");
    }
    @AfterEach
    public void after(){
        System.out.println("Koniec testu");
    }

    @Test
    @DisplayName("Test metody exterminate() na pustej liście")
    public void testOddNumbersExterminatorEmptyList() {
        List<Integer> emptyList = new ArrayList<>();
        List<Integer> result = exterminator.exterminate(emptyList);

        Assert.assertEquals(emptyList, result);
    }

    @Test
    @DisplayName("Test exterminate czy poprawnie usuwa liczby nieparzyste")
    public void testOddNumbersExterminatorNormalList() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> expected = Arrays.asList(2, 4, 6, 8, 10);

        List<Integer> result = exterminator.exterminate(numbers);

        Assert.assertEquals(expected, result);
    }
}

