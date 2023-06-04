
package com.kodilla.testing.forum;                             // [1]

import com.kodilla.testing.user.SimpleUser;
import org.junit.jupiter.api.DisplayName;                   // [2]
import org.junit.jupiter.api.Assertions;                       // [3]
import org.junit.jupiter.api.Test;                             // [4]
@DisplayName("Forum Test Suite")
class ForumTestSuite {
    @DisplayName(
            "When created SimpleUser with name, " +
                    "then getUsername should return correct name"
    )// [5]

    @Test
    // [6]
    void testCaseUsername() {                                   // [7]
        //Given
        SimpleUser simpleUser = new SimpleUser("theForumUser", "Rafal Nicki");  // [8]

        //When
        String result = simpleUser.getUsername();                // [9]

        String expectedResult = "theForumUser";                  // [10]

        //Then
        Assertions.assertEquals(expectedResult, result);         // [11]
    }
}