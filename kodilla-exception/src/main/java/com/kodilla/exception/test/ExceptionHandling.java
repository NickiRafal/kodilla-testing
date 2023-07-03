package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();
        // Przykład kiedy wystąpi wyjątek
        try {
            String result = secondChallenge.probablyIWillThrowException(1.5, 1.5);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Złapałem wyjątek: " + e);
        } finally {
            System.out.println("Obsługa wyjątków zakończona.");
        }
        //przykład kiedy wyjątek nie nastąpi
        try {
            String result = secondChallenge.probablyIWillThrowException(1.5, 2);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Złapałem wyjątek: " + e);
        } finally {
            System.out.println("Obsługa wyjątków zakończona.");
        }
    }
}