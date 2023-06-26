package com.paymybuddy.service;

import com.paymybuddy.model.Account;
import com.paymybuddy.model.TransactionType;
import com.paymybuddy.model.Transfer;
import com.paymybuddy.repository.AccountRepository;
import com.paymybuddy.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransferService
{
    private final TransferRepository transferRepository;
    private final AccountRepository accountRepository;
    private final TransactionService transactionService;
    @Autowired
    public TransferService(TransferRepository transferRepository, AccountRepository accountRepository, TransactionService transactionService)
    {
        this.transferRepository = transferRepository;
        this.accountRepository = accountRepository;
        this.transactionService = transactionService;
    }

    public Transfer addTransfer(Long senderAccountId, Long receiverAccountId, String description, float amount) throws Exception
    {
        Account senderAccount = accountRepository.findById(senderAccountId).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        Account receiverAccount = accountRepository.findById(receiverAccountId).orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        double senderBalance = transactionService.getBalanceByAccountId(senderAccount);
        if (senderBalance < amount) throw new Exception("Insufficient balance in the sender's account");

        transactionService.addWithdrawal(senderAccountId, amount);
        transactionService.addDeposit(receiverAccountId, amount, TransactionType.DEPOT);

        Transfer transfer = new Transfer();
        transfer.setDescription(description);
        transfer.setAmount(amount);
        // TODO : corriger les foreign keys
        //transfer.setSenderAccount(senderAccount);
        //transfer.setReceiverAccount(receiverAccount);

        return transferRepository.save(transfer);
    }


    public List<Transfer> getAllTransfers()
    {
        return transferRepository.findAll();
    }
}
