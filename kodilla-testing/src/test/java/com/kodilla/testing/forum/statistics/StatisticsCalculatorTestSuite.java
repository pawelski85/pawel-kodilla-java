package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
        import java.util.*;

@DisplayName("TDD: Statistics Calculator Test Suite")
@ExtendWith(MockitoExtension.class)
public class StatisticsCalculatorTestSuite {
    @Mock
    private Statistics statisticsMock;

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
        int result=statistics1.getNumberOfUsers();

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
        int result=statistics1.getNumberOfPosts();

        //Then
        Assertions.assertEquals(1, result);
    }

    @DisplayName("when create comments list with comments data, " +
            "then calculateAdvStatistics should show the quantity of comments")
    @Test
    void testCalculateNumberOfComments() {
        //Given
        when(statisticsMock.commentsCount()).thenReturn(1);
        StatisticsCalculator statistics1=new StatisticsCalculator(statisticsMock);

        //When
        statistics1.calculateAdvStatistics(statisticsMock);
        int result=statistics1.getNumberOfComments();

        //Then
        Assertions.assertEquals(1, result);
    }

    @DisplayName("when create userNames list with users data and number of posts, " +
            "then calculateAdvStatistics should show the average user posts")
    @Test
    void testCalculateAverageUserPosts() {
        //Given
        List<String> usersNames=new LinkedList<>();
        usersNames.add("pawel");
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.postsCount()).thenReturn(1);
        StatisticsCalculator statistics1=new StatisticsCalculator(statisticsMock);

        //When
        statistics1.calculateAdvStatistics(statisticsMock);
        double result=statistics1.getAvUsPosts();

        //Then
        Assertions.assertEquals(1, result, 0.01);
    }

    @DisplayName("when create userNames list with users data and number of comments, " +
            "then calculateAdvStatistics should show the average user comments")
    @Test
    void Av_User_Comments() {
        //Given
        List<String> usersNames=new LinkedList<>();
        usersNames.add("pawel");
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.commentsCount()).thenReturn(1);
        StatisticsCalculator statistics1=new StatisticsCalculator(statisticsMock);

        //When
        statistics1.calculateAdvStatistics(statisticsMock);
        double result=statistics1.getAvUsComments();

        //Then
        Assertions.assertEquals(1, result, 0.01);
    }

    @DisplayName("when create comments list with and posts list, " +
            "then calculateAdvStatistics should show the average comment to post")
    @Test
    void Av_Comment_To_Post() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(2);
        when(statisticsMock.commentsCount()).thenReturn(1);
        StatisticsCalculator statistics1=new StatisticsCalculator(statisticsMock);

        //When
        statistics1.calculateAdvStatistics(statisticsMock);
        double result=statistics1.getAvCommentToPost();

        //Then
        Assertions.assertEquals(0.5, result, 0.01);
    }
}
