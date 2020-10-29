package com.kodilla.testing.forum.statistics;

import java.util.LinkedList;
import java.util.List;

public class StatisticsCalculator {
    int numberOfUsers;
    int numberOfPosts;
    int numberOfComments;
    double averageUserPosts;
    double averageUserComments;
    double averageCommentToPost;

    public StatisticsCalculator(Statistics statistics) {
    }

    public void calculateAdvStatistics(Statistics statistics) {
        List<String> list = new LinkedList<>();
        list = statistics.usersNames();
        this.numberOfUsers = list.size();
        this.numberOfPosts = statistics.postsCount();
        this.numberOfComments = statistics.commentsCount();
        this.averageUserPosts = statistics.postsCount() / list.size();


    }
}
