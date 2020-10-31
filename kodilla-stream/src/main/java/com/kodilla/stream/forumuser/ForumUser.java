package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int userID;
    private final char sex;
    private final LocalDate birth;
    private final int postsQuantity;

    public ForumUser(int userID, char sex, LocalDate birth, int postsQuantity) {
        this.userID = userID;
        this.sex = sex;
        this.birth = birth;
        this.postsQuantity = postsQuantity;
    }


}
