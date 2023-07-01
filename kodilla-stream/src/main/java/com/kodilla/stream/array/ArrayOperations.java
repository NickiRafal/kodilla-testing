package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {
     static double getAverage(int[] numbers){
        IntStream.of(numbers)
                .forEach(System.out::println);
        double average = IntStream.range(0, numbers.length)
                .mapToDouble(i -> numbers[i])
                .average()
                .orElse(0.0);

        return average;
    }

     static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        double average = getAverage(numbers);
        System.out.println("Average: " + average);
    }
}
