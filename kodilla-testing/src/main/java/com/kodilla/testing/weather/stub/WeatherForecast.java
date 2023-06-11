package com.kodilla.testing.weather.stub;

import java.util.*;

import static java.nio.file.Files.size;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }

    public double calculateAverageTemperature() {
        double sum = 0.0;
        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {
            sum += temperature.getValue();
        }
        int count = calculateForecast().size();
        double average = sum / count;
        return average;
    }

    public double calculateMedianTemperature() {
        Map<String, Double> resultMap = new HashMap<>();
        List <Double> list = new ArrayList<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
            list.add(temperature.getValue());
        }
        Collections.sort(list);
        double median =0;
        int size = list.size();

        if (size % 2 == 0) {
            int middleIndex = size / 2;
            double value1 = list.get(middleIndex - 1);
            double value2 = list.get(middleIndex);
            median = (value1 + value2) / 2;

        }else{
            int middleIndex = size / 2;
            median = list.get(middleIndex);
        }


        return median;
    }

}