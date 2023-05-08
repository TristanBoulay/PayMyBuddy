package com.paymybuddy.Controllers;

import com.paymybuddy.Models.Transaction;
import com.paymybuddy.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/deposit")
    public ResponseEntity<Transaction> addDeposit(@RequestParam("userId") Long userId, @RequestParam("amount") double amount) {
        Transaction deposit = transactionService.addDeposit(userId, amount);
        return ResponseEntity.ok(deposit);
    }

    @GetMapping("/deposit")
    public ResponseEntity<List<Transaction>> listDeposits(@RequestParam("userId") Long userId) {
        List<Transaction> deposits = transactionService.listDeposits(userId);
        return ResponseEntity.ok(deposits);
    }

    @PostMapping("/remove")
    public ResponseEntity<Void> removeTransaction(@RequestParam("transactionId") Long transactionId) {
        transactionService.removeTransaction(transactionId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/balance-sheet")
    public ResponseEntity<Double> getBalanceSheet(@RequestParam("userId") Long userId) {
        double balanceSheet = transactionService.getBalanceSheet(userId);
        return ResponseEntity.ok(balanceSheet);
    }
}

