package com.telus.assignment.model;

import java.time.LocalDate;

public class Purchase {

    private String customerId;
    private double amount;
    private LocalDate transactionDate;

    public Purchase(String customerId, double amount, LocalDate transactionDate) {
        this.customerId = customerId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }
}