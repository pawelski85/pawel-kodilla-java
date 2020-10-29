package com.kodilla.testing.forum.statistics;
import com.kodilla.testing.forum.statistics.StatisticsCalculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.intThat;
import static org.mockito.Mockito.when;







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
public class StatisticsCalculatorTestSuite {
    @Mock
    private Statistics statisticsMock;
    @Mock
    private Statistics statisticsMock2;
    @Mock
    private Statistics statisticsMock3;


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

    @DisplayName("when create usersNames list with users data, " +
            "then calculateAdvStatistics should show the quantity of users")
    @Test
    void testCalculateNumberOfUsers() {
        //Given
        List<String> usersNames=new LinkedList<>();
        usersNames.add("pawel");
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        StatisticsCalculator statistics1=new StatisticsCalculator(statisticsMock);

        //When
        statistics1.calculateAdvStatistics(statisticsMock);
        int result=statistics1.numberOfUsers;

        //Then
        Assertions.assertEquals(1, result);
    }

    @DisplayName("when create posts list with posts data, " +
            "then calculateAdvStatistics should show the quantity of posts")
    @Test
    void testCalculateNumberOfPosts() {
        //Given
        List<String> posts=new LinkedList<>();
        posts.add("post");
        when(statisticsMock.postsCount()).thenReturn(posts.size());
        StatisticsCalculator statistics1=new StatisticsCalculator(statisticsMock);

        //When
        statistics1.calculateAdvStatistics(statisticsMock);
        int result=statistics1.numberOfPosts;

        //Then
        Assertions.assertEquals(1, result);
    }

    @DisplayName("when create comments list with comments data, " +
            "then calculateAdvStatistics should show the quantity of comments")
    @Test
    void testCalculateNumberOfComments() {
        //Given
        List<String> comments=new LinkedList<>();
        comments.add("comment");
        when(statisticsMock.commentsCount()).thenReturn(comments.size());
        StatisticsCalculator statistics1=new StatisticsCalculator(statisticsMock);

        //When
        statistics1.calculateAdvStatistics(statisticsMock);
        int result=statistics1.numberOfComments;

        //Then
        Assertions.assertEquals(1, result);
    }
}
