package com.telus.assignment.service;

import com.telus.assignment.model.CustomerRewardSummary;
import com.telus.assignment.model.Purchase;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RewardServiceTest {

    private final RewardService service = new RewardService();

    @Test
    void shouldCalculateRewardsForMultipleCustomersAndMonths() {

        List<Purchase> data = List.of(
                new Purchase("C1", 120, LocalDate.of(2026, 1, 10)), // 90
                new Purchase("C1", 75,  LocalDate.of(2026, 1, 20)), // 25
                new Purchase("C1", 200, LocalDate.of(2026, 2, 15)), // 250

                new Purchase("C2", 90,  LocalDate.of(2026, 1, 5)),  // 40
                new Purchase("C2", 130, LocalDate.of(2026, 3, 25))  // 110
        );

        List<CustomerRewardSummary> result = service.calculateRewards(data);

        assertEquals(2, result.size());

        CustomerRewardSummary c1 = result.stream()
                .filter(c -> c.getCustomerId().equals("C1"))
                .findFirst()
                .orElseThrow();

        assertEquals(365, c1.getTotalPoints());
        assertEquals(115, c1.getMonthlyPoints().get("2026-01"));
        assertEquals(250, c1.getMonthlyPoints().get("2026-02"));

        CustomerRewardSummary c2 = result.stream()
                .filter(c -> c.getCustomerId().equals("C2"))
                .findFirst()
                .orElseThrow();

        assertEquals(150, c2.getTotalPoints());
        assertEquals(40, c2.getMonthlyPoints().get("2026-01"));
        assertEquals(110, c2.getMonthlyPoints().get("2026-03"));
    }
}
