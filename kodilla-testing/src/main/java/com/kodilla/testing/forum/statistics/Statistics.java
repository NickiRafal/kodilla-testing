package com.kodilla.testing.forum.statistics;
import java.util.List;

public interface Statistics {
    List<ForumUser> userNames();
    int postsCount();
    int commentsCount();


}
