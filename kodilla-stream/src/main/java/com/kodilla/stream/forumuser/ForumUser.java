package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int userId;
    private final String username;
    private final char sex;
    private final LocalDate userBirthday;
    private final int numberOfPosts;

    public ForumUser(final int userId, final String username, final char sex, final LocalDate userBirthday, final int numberOfPosts) {
        this.userId = userId;
        this.username = username;
        this.sex = sex;
        this.userBirthday = userBirthday;
        this.numberOfPosts = numberOfPosts;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getUserBirthday() {
        return userBirthday;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", userBirthday=" + userBirthday +
                ", numberOfPosts=" + numberOfPosts +
                '}';
    }
}
