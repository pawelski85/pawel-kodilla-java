package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures){
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()){

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double calculateAverageTemperature(){
        double averageTemperature=0;
        int i=0;
        for (Map.Entry<String, Double> temperatures : temperatures.getTemperatures().entrySet()) {
            averageTemperature+=temperatures.getValue();
            i++;
        }
            return averageTemperature/i;
    }

    public double calculateMedian() {
        List<Double> resultMap = new LinkedList<>();

        for (Map.Entry<String, Double> temperatures : temperatures.getTemperatures().entrySet()) {
            resultMap.add(temperatures.getValue());
        }
        Collections.sort(resultMap);
        int tempIndex = (resultMap.size() / 2);

        if (resultMap.size() % 2 == 0) {
            return ((resultMap.get(tempIndex) + resultMap.get(tempIndex - 1)) / 2);
        }
        else {
            return resultMap.get(tempIndex);
        }
    }
}
