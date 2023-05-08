package com.paymybuddy.Services;

import com.paymybuddy.Models.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    public void removeTransaction(Long transactionId) {
    }

    public double getBalanceSheet(Long userId) {
        return userId;
    }

    public Transaction addDeposit(Long userId, double amount) {
        Transaction transaction = null;
        return null;
    }

    public List<Transaction> listDeposits(Long userId) {
        List<Transaction> transactionList = null;
        return transactionList;
    }
}
