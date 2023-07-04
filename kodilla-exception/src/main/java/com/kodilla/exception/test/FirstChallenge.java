package com.kodilla.exception.test;

import java.io.IOException;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
                throw new ArithmeticException();
        }
        System.out.println(a/b);
        return a / b;
    }


    public static void main(String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();
        try {
            firstChallenge.divide(10, 5);
            firstChallenge.divide(20, 4);
            firstChallenge.divide(3, 0);
        }catch (ArithmeticException e) {
            System.out.println("błąd arytmetyczny, dzielenie przez zero jest niedozwolone ");
        }finally {
            System.out.println("Dzielenie przez zero jest niedozwolone");
        }
    }
}