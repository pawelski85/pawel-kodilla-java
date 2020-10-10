package com.kodilla.testing.collection;

import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.jupiter.api.*;

import java.util.List;


public class CollectionTestSuite {
    @BeforeEach
    public void before(){
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after(){
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end");
    }

    @DisplayName("when create OddNumbersExterminator empty list" +
            "then getNumbers should return 0 numbers ")
    @Test
    void testOddNumbersExterminatorEmptyList(){
        //Given
        OddNumbersExterminator list=new OddNumbersExterminator();
        //When
        List<Integer> result =list.getNumbers();
        Integer expectedResult=0;
        //Then
        Assertions.assertEquals(expectedResult, result.size());
    }
    @DisplayName("when create OddNumbersExterminator list" +
            "then getEvenListNumbers should return only even numbers ")
    @Test
    void testOddNumbersExterminatorNormalList(){
        //Given
        OddNumbersExterminator numbers=new OddNumbersExterminator(9,2,4);
        //When
        List<Integer> result=numbers.getNumbers();
        Integer expectedResult=0;
        numbers.exterminate(result);
        List<Integer> evenListResult=numbers.getEvenListNumbers();
        //Then
        for(Integer even:evenListResult) {
            Assertions.assertEquals(expectedResult, even%2);
            System.out.println(even);
        }
    }
}

