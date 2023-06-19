package com.kodilla.testing.forum.statistics;

import com.kodilla.testing.library.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
    public class statisticsUserTest {

    private List<ForumUser> generateListOfUser(int x) {
        List<ForumUser> resultList = new ArrayList<>();
        for (int n = 1; n <= x; n++) {
            ForumUser forumUser = new ForumUser("Rafał"+n,"Nicki"+n);
            resultList.add(forumUser);
        }
        return resultList;
    }
    @Mock
    private Statistics statisticsMock;

    @Test
    void calculateAdvStatisticsUser(){

    Count count = new Count(statisticsMock);
    List<ForumUser> userList = new ArrayList<>();
    List<ForumUser> resaltList100 = generateListOfUser(100);
        List<ForumUser> resaltList0 = generateListOfUser(0);
    when(statisticsMock.userNames()).thenReturn(userList);
    //when
        List<ForumUser>users = count.calculateAdvStatisticsUser(statisticsMock);
        //Then

        assertEquals(100, resaltList100.size());
        assertEquals(0, resaltList0.size());


    }
    @Test
    void calculateAdvStatisticsPost(){
        Count count = new Count(statisticsMock);
        List<ForumPost> forumPostList = new ArrayList<>();
        ForumPost forumPost1 = new ForumPost("Tresc","Rafal");
        ForumPost forumPost2 = new ForumPost("Tresc","Rafal");
        forumPostList.add(forumPost1);
        forumPostList.add(forumPost2);
        when(statisticsMock.postsCount()).thenReturn(forumPostList.size());

        int postList = count.calculateAdvStatisticsPost(statisticsMock);
        assertEquals(2, postList);
    }
    @Test
    void calculateAdvStatisticsComment(){
        Count count = new Count(statisticsMock);
        ForumPost post1 = new ForumPost("Tresc","Rafał");
        ForumComment forumComment1 = new ForumComment(post1,"test","Rafał" );
        List<ForumComment> forumCommentList = new ArrayList<>();
        forumCommentList.add(forumComment1);
        when(statisticsMock.commentsCount()).thenReturn(forumCommentList.size());


        int postList = count.calculateAdvStatisticsComment(statisticsMock);
        assertEquals(1, postList);

    }
}


