package com.kodilla.testing.weather.mock;

import com.kodilla.testing.library.Book;
import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.mockito.ArgumentMatchers.doubleThat;
import static org.mockito.Mockito.when;

@DisplayName("TDD: Weather Forecast Test Suite")
@ExtendWith(MockitoExtension.class)
class WeatherForecastTestSuite {
    @Mock
    private Temperatures temperaturesMock;

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @DisplayName("when create temperaturesMap with sensors data, " +
            "then calculateForecast size should show the quantity of sensors")
    @Test
    void testCalculateForecastWithMock() {
        //Given
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);

        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }

    @DisplayName("when create temperaturesMap with sensors data, " +
            "then calculateForecast should show the average temperature")
    @Test
    void testAverageTemp() {
        //Given
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);

        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double result=weatherForecast.calculateAverageTemperature();

        //Then
        Assertions.assertEquals(25.56, result, 0.01);
    }

    @DisplayName("when create OddTemperaturesMapOdd with odd number of sensors data, " +
            "then calculateOddMedian should show the average temperatures median")
    @Test
    void testTempMedianOdd() {
        //Given
        Map<String, Double> oddTemperaturesMap = new HashMap<>();
        oddTemperaturesMap.put("Rzeszow", 25.5);
        oddTemperaturesMap.put("Krakow", 26.2);
        oddTemperaturesMap.put("Wroclaw", 24.8);
        oddTemperaturesMap.put("Warszawa", 25.2);
        oddTemperaturesMap.put("Gdansk", 26.1);

        when(temperaturesMock.getTemperatures()).thenReturn(oddTemperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double result = weatherForecast.calculateMedian();

        //Then
        Assertions.assertEquals(25.5, result, 0.01);
    }

    @DisplayName("when create evenTemperaturesMap with even number of sensors data, " +
            "then calculateEvenMedian should show the average temperatures median")
    @Test
    void testTempMedianEven() {
        //Given
        Map<String, Double> evenTemperaturesMap = new HashMap<>();
        evenTemperaturesMap.put("Rzeszow", 25.5);
        evenTemperaturesMap.put("Krakow", 26.2);
        evenTemperaturesMap.put("Wroclaw", 24.8);
        evenTemperaturesMap.put("Warszawa", 25.2);
        evenTemperaturesMap.put("Gdansk", 26.1);
        evenTemperaturesMap.put("Olsztyn", 26.2);

        when(temperaturesMock.getTemperatures()).thenReturn(evenTemperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double resultEven = weatherForecast.calculateMedian();

        //Then
        Assertions.assertEquals(25.8, resultEven, 0.01);
    }

}
