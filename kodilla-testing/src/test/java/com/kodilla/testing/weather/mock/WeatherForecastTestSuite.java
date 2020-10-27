package com.kodilla.testing.weather.mock;

import com.kodilla.testing.library.Book;
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
    @Mock
    private Temperatures temperaturesMock2;
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
        Assertions.assertEquals(26.56, result, 0.01);
    }

    @DisplayName("when create temperaturesMap with number of sensors data, " +
                "then calculateForecast should show the average temperatures median")
    @Test
    void testTempMedian() {
            //Given
            Map<String, Double> evenTemperaturesMap = new HashMap<>();
            evenTemperaturesMap.put("Rzeszow", 25.5);
            evenTemperaturesMap.put("Krakow", 26.2);
            evenTemperaturesMap.put("Wroclaw", 24.8);
            evenTemperaturesMap.put("Warszawa", 25.2);
            evenTemperaturesMap.put("Gdansk", 26.1);
            evenTemperaturesMap.put("Olsztyn", 26.2);

            Map<String, Double> oddTemperaturesMap = new HashMap<>();
            oddTemperaturesMap.put("Rzeszow", 25.5);
            oddTemperaturesMap.put("Krakow", 26.2);
            oddTemperaturesMap.put("Wroclaw", 24.8);
            oddTemperaturesMap.put("Warszawa", 25.2);
            oddTemperaturesMap.put("Gdansk", 26.1);

            when(temperaturesMock.getTemperatures()).thenReturn(evenTemperaturesMap);
            WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

            when(temperaturesMock2.getTemperatures()).thenReturn(oddTemperaturesMap);
            WeatherForecast weatherForecast2 = new WeatherForecast(temperaturesMock2);

            List<Double> tempList = new LinkedList<>();
            for (Map.Entry<String, Double> tempMap : weatherForecast.calculateForecast().entrySet()) {
                tempList.add(tempMap.getValue());
            }

            List<Double> tempList2 = new LinkedList<>();
            for (Map.Entry<String, Double> tempMap2 : weatherForecast2.calculateForecast().entrySet()) {
                tempList2.add(tempMap2.getValue());
            }

            Collections.sort(tempList);
            Collections.sort(tempList2);

            //When
            int tempMedian1 = ((weatherForecast.calculateForecast().size() / 2) - 1);
            int tempMedian2 = ((weatherForecast.calculateForecast().size() / 2));
            double resultEven = (tempList.get(tempMedian1) + tempList.get(tempMedian2)) / 2;

            int tempMedianOdd = (weatherForecast2.calculateForecast().size() / 2);
            double resultOdd = tempList2.get(tempMedianOdd);

            //Then
            Assertions.assertEquals(26.8, resultEven,0.01);
            Assertions.assertEquals(26.5, resultOdd, 0.01);
    }
}
