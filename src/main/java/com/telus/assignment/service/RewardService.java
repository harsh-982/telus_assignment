package com.telus.assignment.service;

import com.telus.assignment.helper.RewardUtil;
import com.telus.assignment.model.CustomerRewardSummary;
import com.telus.assignment.model.Purchase;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.*;

@Service
public class RewardService {

    public List<CustomerRewardSummary> calculateRewards(List<Purchase> purchases) {

        Map<String, CustomerRewardSummary> customerMap = new HashMap<>();

        for (Purchase purchase : purchases) {

            if (purchase.getAmount() <= 0 || purchase.getTransactionDate() == null) {
                continue;
            }
            int points = RewardUtil.calculatePoints(purchase.getAmount());

            String customerId = purchase.getCustomerId();
            YearMonth ym = YearMonth.from(purchase.getTransactionDate());
            String month = ym.toString();

            if (!customerMap.containsKey(customerId)) {
                customerMap.put(
                        customerId,
                        new CustomerRewardSummary(customerId, new HashMap<>())
                );
            }

            CustomerRewardSummary summary = customerMap.get(customerId);

            summary.addPoints(month, points);
        }

        return new ArrayList<>(customerMap.values());
    }
}