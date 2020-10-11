package com.kodilla.testing.collection;

import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.jupiter.api.*;

import java.util.LinkedList;
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

        //Then
        Assertions.assertEquals(0, result.size());
    }
    @DisplayName("when create OddNumbersExterminator list" +
            "then getEvenListNumbers should return only even numbers ")
    @Test
    void testOddNumbersExterminatorNormalList(){
        //Given
        OddNumbersExterminator numbers=new OddNumbersExterminator();
        List<Integer> numbersList=new LinkedList<>();
        numbersList.add(9);
        numbersList.add(2);
        numbersList.add(4);

        //When
        numbers.exterminate(numbersList);
        List<Integer> evenListResult=numbers.getEvenListNumbers();
        int result=evenListResult.size();

        //Then
        Assertions.assertEquals(2, result);
    }
}

