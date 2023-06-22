package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)

public class StatisticsUserTest {
    @Mock
    private Statistics statisticsMock;
    @Test
    public void testCalculateAdvStatisticsWithZeroPosts() {
        // Given

        when(statisticsMock.postsCount()).thenReturn(0);
        Count calculator = new Count(statisticsMock);

        // When
        calculator.calculateAdvStatistics(statisticsMock);

        // Then
        Assertions.assertEquals(0, calculator.getPostCount());
        Assertions.assertEquals(0, calculator.getAvgPostsPerUser());
    }
    @Test
    public void testCalculateAdvStatisticsWithThousandPosts() {
        // Given

        when(statisticsMock.postsCount()).thenReturn(1000);
        Count calculator = new Count(statisticsMock);

        // When
        calculator.calculateAdvStatistics(statisticsMock);

        // Then
        Assertions.assertEquals(1000, calculator.getPostCount());
        Assertions.assertEquals(0, calculator.getAvgCommentsPerPost());
    }

    @Test
    public void testCalculateAdvStatisticsWithZeroComments() {
        // Given

        when(statisticsMock.commentsCount()).thenReturn(0);
        Count calculator = new Count(statisticsMock);

        // When
        calculator.calculateAdvStatistics(statisticsMock);

        // Then
        Assertions.assertEquals(0, calculator.getCommentCount());
        Assertions.assertEquals(0, calculator.getAvgCommentsPerUser());
        Assertions.assertEquals(0, calculator.getAvgCommentsPerPost());
    }
    @Test
    public void testCalculateAdvStatisticsWithCommentsLessThanPosts() {
        // Given
        List<ForumUser>test = new ArrayList<>();
        ForumUser forumUser1 = new ForumUser("Rafal","Nicki");
        ForumUser forumUser2 = new ForumUser("Rafal","Nicki");
        test.add(forumUser1);
        test.add(forumUser2);

        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(50);
        when(statisticsMock.userNames()).thenReturn(test);
        Count calculator = new Count(statisticsMock);

        // When
        calculator.calculateAdvStatistics(statisticsMock);

        // Then
        Assertions.assertEquals(2, calculator.getUserCount());
        Assertions.assertEquals(100, calculator.getPostCount());
        Assertions.assertEquals(50, calculator.getCommentCount());
        Assertions.assertEquals(50.0, calculator.getAvgPostsPerUser());
        Assertions.assertEquals(25.0, calculator.getAvgCommentsPerUser());
        Assertions.assertEquals(0.5, calculator.getAvgCommentsPerPost());
    }
    public  List<ForumUser> generateLictUser(){
        List<ForumUser> users = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            ForumUser forumUser = new ForumUser("Rafal"+i,"Nicki"+i);
            users.add(forumUser);
        }
        return users;
    }
    @Test
    public void testCalculateAdvStatisticsWithHundredUsers() {
        // Given
        Statistics statisticsMock = Mockito.mock(Statistics.class);
        when(statisticsMock.userNames()).thenReturn(generateLictUser());
        Count calculator = new Count(statisticsMock);

        // When
        calculator.calculateAdvStatistics(statisticsMock);

        // Then
        Assertions.assertEquals(100, calculator.getUserCount());
        Assertions.assertEquals(0, calculator.getPostCount());
        Assertions.assertEquals(0, calculator.getCommentCount());
        Assertions.assertEquals(0.0, calculator.getAvgPostsPerUser());
        Assertions.assertEquals(0.0, calculator.getAvgCommentsPerUser());
        Assertions.assertEquals(0.0, calculator.getAvgCommentsPerPost());
    }
}