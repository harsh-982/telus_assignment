package com.telus.assignment.controller;

import com.telus.assignment.model.CustomerRewardSummary;
import com.telus.assignment.model.Purchase;
import com.telus.assignment.service.RewardService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 * REST controller for reward calculation APIs.
 */
@RestController
@RequestMapping("/api/reward-points")
public class TelusRewardController {

    private final RewardService service;

    public TelusRewardController(RewardService service) {
        this.service = service;
    }

    /**
     *Calculates reward points for provided transactions.
     *@param purchases transaction list
     *@return customer reward summary
     */
    @PostMapping
    public List<CustomerRewardSummary> calculateRewards(@RequestBody List<Purchase> purchases) {
        return service.calculateRewards(purchases);
    }
}
