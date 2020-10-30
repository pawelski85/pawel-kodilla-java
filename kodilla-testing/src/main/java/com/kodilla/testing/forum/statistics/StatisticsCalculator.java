package com.kodilla.testing.forum.statistics;

import java.util.LinkedList;
import java.util.List;

public class StatisticsCalculator {
    private int numberOfUsers;
    private int numberOfPosts;
    private int numberOfComments;
    private double avUsPosts;
    private double avUsComments;
    private double avCommentToPost;

    public StatisticsCalculator(Statistics statistics) {
    }

    public void calculateAdvStatistics(Statistics statistics) {
        List<String> list = new LinkedList<>();
        list = statistics.usersNames();
        this.numberOfUsers = list.size();
        this.numberOfPosts = statistics.postsCount();
        this.numberOfComments = statistics.commentsCount();
        this.avUsPosts = (double)statistics.postsCount() / list.size();
        this.avUsComments=(double)statistics.commentsCount() / list.size();
        this.avCommentToPost=(double)statistics.commentsCount()/statistics.postsCount();
    }

    public double getAvCommentToPost() {
        return avCommentToPost;
    }

    public double getAvUsComments() {
        return avUsComments;
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public double getAvUsPosts() {
        return avUsPosts;
    }

    public int getNumberOfComments() {
        return numberOfComments;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }
}
