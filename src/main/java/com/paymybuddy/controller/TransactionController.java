package com.paymybuddy.controller;

import com.paymybuddy.model.Account;
import com.paymybuddy.model.Transaction;
import com.paymybuddy.model.TransactionType;
import com.paymybuddy.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/transaction")
public class TransactionController
{
    @Autowired
    private TransactionService transactionService;
    //@Autowired
    //private TransactionType transactionType;

    @PostMapping("/deposit")
    public ResponseEntity<Transaction> addDeposit(@RequestParam("userId") Long userId, @RequestParam("amount") float amount, @RequestParam("type")TransactionType transactionType) throws Exception
    {
        Transaction deposit = transactionService.addDeposit(userId, amount, transactionType.DEPOT);
        return ResponseEntity.ok(deposit);
    }

    @GetMapping("/deposit")
    public ResponseEntity<List<Transaction>> listDeposits(@RequestParam("userId") Account userId)
    {
        List<Transaction> deposits = transactionService.listDeposits(userId);
        return ResponseEntity.ok(deposits);
    }

    @PostMapping("/remove")
    public ResponseEntity<Void> removeTransaction(@RequestParam("transactionId") Long transactionId)
    {
        transactionService.removeTransaction(transactionId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/balance-sheet")
    public ResponseEntity<Double> getBalanceSheet(@RequestParam("userId") Account userId)
    {
        double balanceSheet = transactionService.getBalanceByAccountId(userId);
        return ResponseEntity.ok(balanceSheet);
    }
}

