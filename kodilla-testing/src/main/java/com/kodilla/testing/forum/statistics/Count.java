package com.kodilla.testing.forum.statistics;

;

import java.util.ArrayList;
import java.util.List;

public class Count {
    Statistics statistics;
    private int userCount;
    private int postCount;
    private int commentCount;
    private double avgPostsPerUser;
    private double avgCommentsPerUser;
    private double avgCommentsPerPost;

    public Count(Statistics statistics) {
        this.statistics = statistics;
    }

    public List<ForumUser> calculateAdvStatisticsUser(Statistics statistics){
        List<ForumUser> list = new ArrayList<>();
        ForumUser forumUser = new ForumUser("Rafał","Nicki");
        list.add(forumUser);
        list=statistics.userNames();
        return list;

    }
    public int calculateAdvStatisticsPost(Statistics statistics){
         List<ForumPost> postListw = new ArrayList<>();
         ForumPost forumPost1 = new ForumPost("Tresc","Rafal");
         ForumPost forumPost2 = new ForumPost("Tresc","Rafal");
         postListw.add(forumPost1);
         postListw.add(forumPost2);

        return statistics.postsCount();
    }
    public  int calculateAdvStatisticsComment(Statistics statistics){

        ForumPost post1 = new ForumPost("Tresc","Rafał");
        ForumComment forumComment1 = new ForumComment(post1,"test","Rafał" );
        List<ForumComment> forumCommentList = new ArrayList<>();
        forumCommentList.add(forumComment1);

        return statistics.commentsCount();
    }

}



