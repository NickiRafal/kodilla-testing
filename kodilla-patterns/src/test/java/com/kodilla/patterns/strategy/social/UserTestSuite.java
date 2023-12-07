package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.AssertJUnit.assertEquals;

public class UserTestSuite {
    @Test
    void testDefaultSharingStrategies(){
        //Given
        User millenials = new Millenials("MilenialsUser");
        User yGenUser = new YGeneration("YGenUser");
        User zGenUser = new ZGeneration("ZGenUser");

        //When
        String name1 = millenials.sharePost();
        String name2 = yGenUser.sharePost();
        String name3 = zGenUser.sharePost();

        //Then
        assertEquals("publikuje na Facebboku",name1);
        assertEquals("publikuje na Twitterze",name2);
        assertEquals("publikuje na Snapchacie",name3);
    }
    @Test
    void testIndividualSharingStrategy(){
        //Given
        User user = new Millenials("CustomUser");
        //When
        user.setSocialPublisher(new SnapchatPublisher());
        String name1 = user.sharePost();
        //Then
        assertEquals("publikuje na Snapchacie",name1);

    }
}
