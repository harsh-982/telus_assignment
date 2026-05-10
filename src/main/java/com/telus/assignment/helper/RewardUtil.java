package com.telus.assignment.helper;

public class RewardUtil {

    public static int calculatePoints(double amount) {

        if (amount <= 50) {
            return 0;
        } else if (amount <= 100) {
            return (int) (amount - 50);
        } else {
            int pointsFrom50To100 = 50; // fixed points for this range as amount > 100
            int pointsAbove100 = (int) ((amount - 100) * 2);

            return pointsFrom50To100 + pointsAbove100;
        }
    }
}