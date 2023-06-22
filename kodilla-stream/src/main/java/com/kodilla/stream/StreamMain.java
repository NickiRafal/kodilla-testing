package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.beautifier.PoemDecorator;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {
    public static void main(String[] args) {
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);
        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String text1 = "Wyrażenie lambda a metody z argumentami";
        String text2 = "Uproszczony zapis wyrażeń lambda";
        String text3 = "Link do repozytorium wklej poniżej i wyślij do Mentora";

        // Upiększacz dodający "ABC" na początku i na końcu tekstu
        poemBeautifier.beautify(text1, text -> "ABC" + text + "ABC");

        // Upiększacz zamieniający tekst na duże litery
        poemBeautifier.beautify(text2 , text -> text.toUpperCase());

        // Własny upiększacz - dodawanie +++ na początku i końcu tekstu
        poemBeautifier.beautify(text3, text -> "+++"+ text+ "+++");

        // Własny upiększacz - dodawanie ___ na początku i na końcu tekstu
        poemBeautifier.beautify(text1, text -> "___" + text + "___");

    }
}
