package com.telus.assignment.helper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RewardUtilTest {
    @Test
    void shouldCalculateRewardPointsCorrectly() {

        assertEquals(0, RewardUtil.calculatePoints(30));
        assertEquals(0, RewardUtil.calculatePoints(50));

        assertEquals(10, RewardUtil.calculatePoints(60));
        assertEquals(50, RewardUtil.calculatePoints(100));

        assertEquals(90, RewardUtil.calculatePoints(120));
        assertEquals(250, RewardUtil.calculatePoints(200));
    }
}
