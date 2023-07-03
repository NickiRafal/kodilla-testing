package com.kodilla.exception.io;

import com.kodilla.exception.test.SecondChallenge;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class SecondChallengeTest {
    @Test
    void testProbablyIWillThrowException(){
        SecondChallenge secondChallenge = new SecondChallenge();
        // Testowanie przypadku, gdy x jest większe lub równe 2
        assertThrows(Exception.class,()->secondChallenge.probablyIWillThrowException(2,15));
        // Testowanie przypadku gdy x jest mniejsze niż 1
        assertThrows(Exception.class,()->secondChallenge.probablyIWillThrowException(0.5,1.5));
        // Testowanie przypadku gdy y jest równe 1.5
        assertThrows(Exception.class,()->secondChallenge.probablyIWillThrowException(1,1.5));
        // Testowanie przypadku, gdy x jest między 1 a 2, a y jest różne od 1.5
        assertDoesNotThrow(()->secondChallenge.probablyIWillThrowException(1.5,2));
    }


}
