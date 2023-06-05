package com.kodilla;
import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calcutator;
public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("Testowanie użytkownika", "Nicki Rafał");
        String pom = simpleUser.getUsername();
        if (pom.equals("Testowanie użytkownika ")){
            System.out.println("Test ok");
        }else {
            System.out.println( "Test Error");
        }
        Calcutator calcutator = new Calcutator();
        // Test dla metody add(int a, int b)
        int a = 5;
        int b = 3;
        int expectedResult = 8;
        int result = calcutator.add(5,3);
        System.out.println("Wynik dodawania: " + result);
        if (result == expectedResult) {
            System.out.println("Test dla metody add() przeszedł pomyślnie.");
        } else {
            System.out.println("Test dla metody add() nie przeszedł. Oczekiwany wynik: " + expectedResult);
        }

        // Test dla metody subtract(int a, int b)
        a = 10;
        b = 4;
        expectedResult = 6;
        result = calcutator.subtract(10,4);
        System.out.println("Wynik odejmowania: " + result);
        if (result == expectedResult) {
            System.out.println("Test dla metody subtract() przeszedł pomyślnie.");
        } else {
            System.out.println("Test dla metody subtract() nie przeszedł. Oczekiwany wynik: " + expectedResult);
        }
    }
}