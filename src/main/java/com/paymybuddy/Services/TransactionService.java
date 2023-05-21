package com.paymybuddy.Services;

import com.paymybuddy.Models.Account;
import com.paymybuddy.Models.Transaction;
import com.paymybuddy.Models.TransactionType;
import com.paymybuddy.Repository.AccountRepository;
import com.paymybuddy.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;



    @Autowired
    private AccountRepository accountRepository;

    public Transaction addDeposit(Long accountId, float amount, TransactionType transactionType) throws Exception {
        Optional<Account> account = accountRepository.findById(accountId);

        if (!account.isPresent()){

            throw new Exception("account not found");
        }

        Transaction deposit = new Transaction();

        deposit.setAccount(account.get());
        deposit.setAmount(amount);
        deposit.setType(transactionType.DEPOT);
        transactionRepository.save(deposit);
        return deposit;
    }

    public List<Transaction> listDeposits(Account accountId) {
        return transactionRepository.findAllByAccountIdAndType(accountId, TransactionType.DEPOT);
    }

    public void removeTransaction(Long transactionId) {
        transactionRepository.deleteById(transactionId);
    }

    public double getBalanceByAccountId(Account accountId) {
        List<Transaction> deposits = transactionRepository.findAllByAccountIdAndType(accountId, TransactionType.DEPOT);
        double depositSum = deposits.stream().mapToDouble(Transaction::getAmount).sum();

        List<Transaction> withdrawals = transactionRepository.findAllByAccountIdAndType(accountId, TransactionType.RETRAIT);
        double withdrawalSum = withdrawals.stream().mapToDouble(Transaction::getAmount).sum();

        return depositSum - withdrawalSum;
    }

    public void addWithdrawal(Long accountId, float amount) throws Exception {
        Optional<Account> account = accountRepository.findById(accountId);

        if (!account.isPresent()){

            throw new Exception("account not found");
        }
        Transaction withdrawal = new Transaction();
        withdrawal.setAccount(account.get());
        withdrawal.setType(TransactionType.RETRAIT);
        withdrawal.setAmount(amount);


        transactionRepository.save(withdrawal);
    }

}


