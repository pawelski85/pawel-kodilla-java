package com.kodilla.testing.shape;

import com.kodilla.testing.shape.*;
import org.junit.jupiter.api.*;

@DisplayName("TDD: Shape Collector Test Suite")
public class ShapeCollectorTestSuite {

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


    @Nested
    @DisplayName("Test for list")
    class TestList {
        @DisplayName("when create ShapeCollector with figure, " +
                "then addFigure should add figure to the shapeList")
        @Test
        void testAddFigure(){
            //Given
            ShapeCollector figure=new ShapeCollector(new ShapeDrawer(new Circle()));
            figure.addFigure(new Circle());

            //When
            int result = figure.getShapeListSize();;

            //Then
            Assertions.assertEquals(1, result);
        }
        @DisplayName("When removeFigure should add figure to the shapeList")
        @Test
        void testRemoveFigure(){
            //Given
            ShapeCollector figure=new ShapeCollector(new ShapeDrawer(new Circle()));
            figure.addFigure(new Circle());

            //When
            int result = figure.getShapeListSize();;
            System.out.println("Shape List contains " + result + " figure");

            //Then
            Assertions.assertEquals(1, result);
        }








    }

    @Nested
    @DisplayName("Test for Shape")
    class TestFields {
    }
}


