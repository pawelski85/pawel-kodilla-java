package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SecondChallengeTestSuite {
    @Test
    void testPropably() {
        // given
        SecondChallenge secondChallenge = new SecondChallenge();
        // when & then
        //assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1,1));
        assertAll(
                  () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(3,2)),
                  () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2,1.5)),
                  () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.5,1))
        );
    }
}
