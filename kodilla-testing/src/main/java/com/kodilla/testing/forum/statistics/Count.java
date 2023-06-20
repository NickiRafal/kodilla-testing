package com.kodilla.testing.forum.statistics;

public class Count {
    private int userCount;
    private int postCount;
    private int commentCount;
    private double avgPostsPerUser;
    private double avgCommentsPerUser;
    private double avgCommentsPerPost;
    Statistics statistics ;
    public Count (Statistics statistics){
        this.statistics = statistics;
    }
    public void calculateAdvStatistics(Statistics statistics) {

        userCount = statistics.userNames().size();
        postCount = statistics.postsCount();
        commentCount = statistics.commentsCount();

        if (userCount > 0) {
            avgPostsPerUser = (double) postCount / userCount;
            avgCommentsPerUser = (double) commentCount / userCount;
        }

        if (postCount > 0) {
            avgCommentsPerPost = (double) commentCount / postCount;
        }
    }

    public void showStatistics() {
        System.out.println("User count: " + userCount);
        System.out.println("Post count: " + postCount);
        System.out.println("Comment count: " + commentCount);
        System.out.println("Average posts per user: " + avgPostsPerUser);
        System.out.println("Average comments per user: " + avgCommentsPerUser);
        System.out.println("Average comments per post: " + avgCommentsPerPost);
    }

    public int getUserCount() {
        return userCount;
    }

    public int getPostCount() {
        return postCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public double getAvgPostsPerUser() {
        return avgPostsPerUser;
    }
    public double getAvgCommentsPerUser() {
        return avgCommentsPerUser;
    }

    public double getAvgCommentsPerPost() {
        return avgCommentsPerPost;
    }
}