package com.telus.assignment.model;

import java.util.Map;

public class CustomerRewardSummary {

    private String customerId;
    private Map<String, Integer> monthlyPoints;
    private int totalPoints;

    public CustomerRewardSummary(String customerId, Map<String, Integer> monthlyPoints) {
        this.customerId = customerId;
        this.monthlyPoints = monthlyPoints;
        this.totalPoints = 0; // initialized internally
    }

    public String getCustomerId() {
        return customerId;
    }

    public Map<String, Integer> getMonthlyPoints() {
        return monthlyPoints;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void addPoints(String month, int points) {
        monthlyPoints.put(month, monthlyPoints.getOrDefault(month, 0) + points);
        totalPoints += points;
    }
}
