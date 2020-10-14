package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;
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
        double average = 0;
        for (Map.Entry<String, Double> tempMap : weatherForecast.calculateForecast().entrySet()) {
            average += tempMap.getValue();
        }
        double result = average / temperaturesMap.size();

        //Then
        Assertions.assertEquals(26.56, result, result);
    }

    @Nested
    @DisplayName("Test for median")
    class TestMedian {

        @DisplayName("when create temperaturesMap with even number of sensors data, " +
                "then calculateForecast should show the average temperatures median")
        @Test
        void testTempMedianEvenSensors() {
            //Given
            Map<String, Double> temperaturesMap = new HashMap<>();
            temperaturesMap.put("Rzeszow", 25.5);
            temperaturesMap.put("Krakow", 26.2);
            temperaturesMap.put("Wroclaw", 24.8);
            temperaturesMap.put("Warszawa", 25.2);
            temperaturesMap.put("Gdansk", 26.1);
            temperaturesMap.put("Olsztyn", 26.2);

            when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
            WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

            List<Double> tempList = new LinkedList<>();
            for (Map.Entry<String, Double> tempMap : weatherForecast.calculateForecast().entrySet()) {
                tempList.add(tempMap.getValue());
            }
            Collections.sort(tempList);

            //When
            int tempMedian1 = ((weatherForecast.calculateForecast().size() / 2) - 1);
            int tempMedian2 = ((weatherForecast.calculateForecast().size() / 2));
            double result = (tempList.get(tempMedian1) + tempList.get(tempMedian2)) / 2;

            //Then
            Assertions.assertEquals(26.8, result);
        }

        @DisplayName("when create temperaturesMap with odd numbers of sensors data, " +
                "then calculateForecast should show the average temperatures median")
        @Test
        void testTempMedianOddSensors() {
            //Given
            Map<String, Double> temperaturesMap = new HashMap<>();
            temperaturesMap.put("Rzeszow", 25.5);
            temperaturesMap.put("Krakow", 26.2);
            temperaturesMap.put("Wroclaw", 24.8);
            temperaturesMap.put("Warszawa", 25.2);
            temperaturesMap.put("Gdansk", 26.1);

            when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
            WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

            List<Double> tempList = new LinkedList<>();
            for (Map.Entry<String, Double> tempMap : weatherForecast.calculateForecast().entrySet()) {
                tempList.add(tempMap.getValue());
            }
            Collections.sort(tempList);

            //When
            int tempMedian = (temperaturesMap.size() / 2);
            double result = tempList.get(tempMedian);

            //Then
            Assertions.assertEquals(26.5, result);
        }
    }
}
