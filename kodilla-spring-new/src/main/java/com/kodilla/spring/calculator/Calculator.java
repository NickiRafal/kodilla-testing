package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class Calculator {
    @Autowired
    private Display display;

    public double add(double a, double b){
        double result = a+b;
        display.displayValue(result);
        return result;
    }
    public double sub (double a , double b){
        double result = a-b;
        display.displayValue(result);
        return result;
    }
    public double mul (double a, double b){
        double result = a*b;
        display.displayValue(result);
        return result;
    }
    public  double div(double a, double b){
        if(b==0){
            throw new IllegalArgumentException("Zero jest niedozwolone");
        }
        double result = a/b;
        display.displayValue(result);
        return result;
    }
}
